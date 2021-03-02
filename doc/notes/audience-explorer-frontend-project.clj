(defproject audience-explorer/frontend "0.1.0-SNAPSHOT"
  :description ""
  :url ""
  :min-lein-version "2.5.0"

  :dependencies
  [[org.clojure/clojure "1.8.0"]
   [org.clojure/clojurescript "1.8.34"]
   [org.clojure/core.async "0.2.374" exclusions [org.clojure/tools.reader]]

   ;; Web server
   [ring "1.4.0"]
   [ring/ring-defaults "0.1.5"]
   [compojure "1.4.0"]
   [ring-server "0.4.0"]

   ;; Json
   [cheshire "5.5.0"]

   ;; Templating
   [hiccup "1.0.5"]

   ;; Environment variables from project.clj
   [environ "1.0.1"]

   ;; TODO Not sure what this is...
   [prone "0.8.2"]

   ;; Reagent
   [reagent "0.6.0-alpha"]
   [reagent-utils "0.1.7"]

   ;; Routing and HTML5 pushstate
   [secretary "1.2.3"]
   [venantius/accountant "0.1.7"
    :exclusions [org.clojure/tools.reader]]

   ;; D3 Charts
   ;; NOTE: Using a customized externs file because the
   ;; nvd3 externs included in cljsjs doesn't have
   ;; everything needed to make the compiler
   ;; optimizations work without breaking charts
   [cljsjs/nvd3 "1.8.1-0"]

   ;; JS libs
   [cljsjs/react-select "1.0.0-beta6-1"]]

  :plugins
  [[lein-environ "1.0.1"]
   [lein-cljsbuild "1.1.1"]
   [lein-asset-minifier "0.2.2"
    :exclusions [org.clojure/clojure
                 org.clojure/core.async
                 com.google.javascript/closure-compiler]]
   [lein-figwheel "0.5.2"
    :exclusions [org.clojure/clojure ring/ring-core]]]

  ;; Standalone mock server
  :main audience-explorer.server
  :ring {:handler      audience-explorer.handler/app
         :uberwar-name "audience-explorer.war"}

  ;; Paths
  :source-paths ["src/clj" "src/cljc" "src/cljs"]
  :resource-paths ["resources" "target/cljsbuild"]
  ;; Clean out the target directory, cljsbuild compiler related
  ;; directories. This makes sure that "lein cljsbuild" works for all
  ;; builds
  :clean-targets ^{:protect false}
  [:target-path
   [:cljsbuild :builds :app :compiler :output-dir]
   [:cljsbuild :builds :app :compiler :output-to]
   [:cljsbuild :builds :min :compiler :output-dir]
   [:cljsbuild :builds :min :compiler :output-to]]

  ;; Repl config
  :figwheel
  {:http-server-root "public"
   :server-port      3449
   :css-dirs         ["resources/public/css"]
   :ring-handler     audience-explorer.handler/app}

  ;; App is the dev build, min is prod
  :cljsbuild
  {:builds
   {:app
    {:source-paths ["src/cljs" "src/cljc" "env/dev/cljs"]
     :compiler     {:output-to     "target/cljsbuild/public/js/app.js"
                    :output-dir    "target/cljsbuild/public/js/out"
                    :asset-path    "/js/out"
                    :main          "audience-explorer.dev"
                    :optimizations :none
                    :pretty-print  true
                    :source-map    true}
     ;; On-load callback can be specified here
     ;; :figwheel     {:on-jsload nil}
     }
    :min
    {:source-paths ["src/cljs" "src/cljc" "env/prod/cljs"]
     :compiler     {:main          "audience-explorer.prod"
                    :output-to     "resources/public/js/compiled/app.min.js"
                    :output-dir    "target/cljsbuild/public/js/out-min"
                    :asset-path    "/js/out-min"
                    :externs       ["resources/public/js/externs/nvd3.ext.js"]
                    :optimizations :advanced
                    ;; NOTE: Enable this to get symbol names back when debugging
                    ;; missing externs definitions
                    ;; :pretty-print true
                    ;; :pseudo-names true
                    }}}}

  ;; The repl and dev profiles are used when jacking-in
  :profiles
  {:repl
   ;; In the latest CIDER, cider-jack-in-clojurescript "injects" those
   ;; dependencies in the project, so we don't need to explicitly
   ;; reference them....
   ;; :dependencies [[org.clojure/tools.nrepl "0.2.12"]]
   ;; :plugins [[cider/cider-nrepl "0.11.0-SNAPSHOT"]]
   {:dependencies [[com.cemerick/piggieback "0.2.1"]
                   [figwheel-sidecar "0.5.2"]]
    :repl-options
    {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}

   :dev
   {:repl-options {:init-ns audience-explorer.repl}
    :dependencies [[ring/ring-mock "0.3.0"]
                   [ring/ring-devel "1.4.0"]
                   [binaryage/devtools "0.5.2"]
                   [figwheel-sidecar "0.5.2"]]
    :source-paths ["env/dev/clj"]
    :env          { ;; This is how the client will resolve xhr calls to a
                   ;; specific backend:
                   :api-server-root
                   ;; Prod API server
                   ;; "http://54.163.189.242:3000"
                   ;; Local API server
                   "http://127.0.0.1:3000"
                   ;; Local MOCK server
                   ;;http://127.0.0.1:3449/mock"
                   :dev true}}
   ;; Unused or not unused?
   :uberjar       {:hooks       [minify-assets.plugin/hooks]
                   :prep-tasks  ["compile" ["cljsbuild" "once"]]
                   :env         {:production true :api-server-root "http://54.163.189.242:3000"}
                   :aot         :all
                   :omit-source true
                   :cljsbuild   {:jar    true
                                 :builds {:app
                                          {:source-paths ["env/prod/cljs"]
                                           :compiler
                                           {:optimizations :advanced
                                            :pretty-print  false}}}}}}
  ;; Unused?
  :minify-assets {:assets {"resources/public/css/site.min.css" "resources/public/css/site.css"}}
  :uberjar-name  "audience-explorer.jar")
