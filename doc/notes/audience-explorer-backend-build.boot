;; Audience Explorer Backend


;; * Project configuration

(def +version+ "0.2.0-SNAPSHOT")

(task-options!
 pom {:project 'audience-explorer/backend
      :version +version+})

;; ** Dependencies

(set-env!
 :dependencies
 '[[org.clojure/clojure                       "1.8.0"]
   [boot/core                                 "2.5.5"]

   ;; System deps
   [org.clojure/core.async                    "0.2.374"]
   [com.taoensso/timbre                       "4.2.1"]
   [org.slf4j/slf4j-nop                       "1.7.21"]
   [com.stuartsierra/component                "0.3.1"]
   [prismatic/schema                          "1.0.4"]

   ;; Data manipulation
   [me.raynes/fs                              "1.4.6"]
   [org.clojure/data.csv                      "0.1.3"]
   [cheshire                                  "5.5.0"]

   ;; Elastic Search
   [clojurewerkz/elastisch                    "2.2.0-rc1"]

   ;; Postgres
   [honeysql                                  "0.6.3"]
   [com.layerware/hugsql                      "0.4.5"]
   [com.layerware/hugsql-adapter-clojure-jdbc "0.4.5"]
   [org.postgresql/postgresql                 "9.4.1207"]
   [hikari-cp                                 "1.6.1"]

   ;; Web server
   [ring                                      "1.4.0"]
   [ring/ring-jetty-adapter                   "1.4.0"]
   [ring/ring-json                            "0.4.0"]
   [fuck-cors                                 "0.1.6"]
   [compojure                                 "1.5.0"]

   ;; Auth
   [org.clojure/data.codec                    "0.1.0"]
   [buddy/buddy-hashers                       "0.14.0"]
   [buddy/buddy-auth                          "0.13.0"]])


;; * Environments

;; We consider two operational modes:

;; - API is the web-service aspect, serving data from ES and PG for the frontend
;; as well as processing audience creatiion requests.

;; - Integration is the end of the data pipeline where we ingest all the files
;; generated upstream into both ES and PG. Though this mode is conceptually
;; separate from the API and should utlimately be split out there is still some
;; coupling in that we reuse some of the plumbing to connect to the datastores

;; NOTE that integration is mostly interactive and its operations are defined as
;; boot tasks in a separate file

;; ** API

(set-env!
 :source-paths #{"src"}
 :resource-paths #{"src"})

(deftask run-api
  "Start the API server."
  []
  (require 'api.system)
  (let [start-system (resolve 'api.system/start-system)]
    (start-system)
    (while true
      (Thread/sleep 1000))))

;; ** Integration

(require '[integration.tasks :refer :all])


;; * Test

(deftask testing
  "Sets up the testing environment, required prior to running tests."
  []
  (merge-env!
   :source-paths #{"test"}
   :dependencies
   '[[adzerk/boot-test "1.1.1" :scope "test"]])
  (require 'adzerk.boot-test)
  identity)

(deftask tests [n namespaces NAMESPACE #{sym} "The set of namespace symbols to run tests in."]
  "Run the project unit-tests.
   NOTE that this will require a fully configured environment."
  (comp
   (testing)
   ((resolve 'adzerk.boot-test/test) :namespaces namespaces)))

(deftask integration-tests
  [d data-dir DATA_DIR file "A directory to import"]
  "Run the integration tests for the given data directory.
  NOTE that this will require a fully configured environment."
  (comp
   (testing)
   ((resolve 'adzerk.boot-test/test) :namespaces ['integration.integration-test])))
