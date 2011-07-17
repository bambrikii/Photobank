set MAVEN_OPTS=-Xmx512m -XX:MaxPermSize=256m
mvn clean compile package tomcat:redeploy -DskipTests=true -e
