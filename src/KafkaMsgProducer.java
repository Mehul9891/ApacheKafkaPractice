import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.Scanner;

public class KafkaMsgProducer {

    Logger logger = LoggerFactory.getLogger(KafkaMsgProducer.class);
    public static void main(String args[]){

        String topicName = "my_latest_topic";
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9094");
        props.put("retries", 0);
        props.put("acks", "all");
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> producer = new KafkaProducer(props);

        for(int i = 0; i < 10; i++){
          Scanner scan = new Scanner(System.in);
          String input = scan.nextLine();
            producer.send(new ProducerRecord(topicName,
                    "Hello", input));
        System.out.println("Message sent successfully");

    }
        producer.close();
    }
}
