@echo off
mvn clean
mvn package
mvn dependency:copy-dependencies -DoutputDirectory=target/dependency