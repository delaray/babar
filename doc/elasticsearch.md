# ElasticSearch

The simplest way to set up Elasticsearch is to create a managed deployment with Elasticsearch Service on Elastic Cloud. If you prefer to manage your own test environment, you can install and run Elasticsearch using Docker.  

## Install and Run ElasticSearch

docker network create elastic  
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.13.2  
docker run --name es01-test --net elastic -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.13.2  

## Install and Run Kibana  

docker pull docker.elastic.co/kibana/kibana:7.13.2  
docker run --name kib01-test --net elastic -p 5601:5601 -e "ELASTICSEARCH_HOSTS=http://es01-test:9200" docker.elastic.co/kibana/kibana:7.13.2  