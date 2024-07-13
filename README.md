# Snowflake geneartor

Tiny unique id genarator in Twitter Snowflake format.

ID format is shown below

| 1 bit  | 41 bits     | 10 bits       | 12 bits       |
|-------|-------------|---------------|---------------|
| sign  | timestamp   | machine ID    | sequence      |


## Build and run

- Java build
```
export MACHINE_ID=<val>

./gradlew clean build

java -jar build/libs/SnowflakeGenerator-all.jar
```


- Docker build
```
export DOCKER_REGISTRY=<val>

./gradlew jibDockerBuild

docker run -it  -p8080:8080 -eMACHINE_ID=<value> <registry_name>/snowflakegenerator:<app:version>
```

Note: additionaly export DOCKER_USERNAME and DOCKER_PWD variables for non-local registry


