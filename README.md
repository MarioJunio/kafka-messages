# Cria um novo topico
kafka-topics.sh --create --topic <nome_topico> --partitions 3 --replication-factor 1 --if-not-exists --zookeeper localhost:2181

#   LIstar todos os tópicos
kafka-topics.sh --list --zookeeper localhost:2181

# Inicia um console producer para publicar em um topico
kafka-console-producer.sh --broker-list localhost:9092 --topic <nome_topico>

# Inicia um console consumer para processar as mensagens de um topico 
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <nome_topico> --from-beginning --max-messages 1000 --group <nome_grupo>

 # Monitor consumo por grupo
watch kafka-consumer-groups.sh --group <nome_grupo> --bootstrap-server localhost:9092 --describe
