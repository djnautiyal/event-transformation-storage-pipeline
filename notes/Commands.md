## Windows CMD
- netstat -ano -p tcp | findstr 8081
- tasklist | findstr 16884

## Kafka(/kafka folder)
- docker compose -f docker-compose-multi-node.yaml up -d
- docker compose -f docker-compose-multi-node.yaml down
- docker logs --follow --since=2s kafka-kafka-2-1 | grep INFO

## CockroachDB(/crdb folder)
- docker compose -f docker-compose-crdb.yaml up -d
- docker compose -f docker-compose-crdb.yaml down
- docker exec -it e76d9f60bcd ./cockroach sql --insecure(opens sql shell)
- docker exec -it  216aa4d87f bash(opens bash)

## Inside /cockroach of the container using bash
- ./cockroach sql --database=conference_app < ./sql/create_tables.sql  --insecure
- ./cockroach sql --insecure

## SQL commands
- SHOW DATABASES;
- USE db_name;