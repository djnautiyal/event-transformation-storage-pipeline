netstat -ano -p tcp | findstr 8081
tasklist | findstr 16884


docker compose -f docker-compose-multi-node.yaml up -d
docker compose -f docker-compose-multi-node.yaml down

docker logs --follow --since=2s kafka-kafka-2-1 | grep INFO

