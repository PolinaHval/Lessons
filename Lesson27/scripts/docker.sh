docker network create demo_network

docker run --rm \
    --name tomcat \
    -p 8080:8080 \
    --network demo_network \
    -v "/Users/admin/IdeaProjects/NewJavaEE/Lesson26/target/Lesson26-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" \
    tomcat:9.0.53-jdk11-openjdk

docker run --rm \
    --name demo-postgres \
    --network demo_network \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -p 15432:5432 \
    -v "/Users/admin/IdeaProjects/NewJavaEE/Lesson26/dev-env/postgres/init.sql:/docker-entrypoint-initdb.d/1-init.sql" \
    postgres:13.4-alpine
