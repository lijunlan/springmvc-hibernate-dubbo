base_dir=$(dirname $0)
cd $base_dir/../lee2;
mvn clean package -DskipTests -Pdev;
bin/start.sh
