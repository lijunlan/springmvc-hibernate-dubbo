#! /bin/bash

base_dir=$(dirname $0)
cd $base_dir/../

cd lee3
mvn clean install

cd ..
cd lee1
mvn clean package -Pdev -DskipTests
