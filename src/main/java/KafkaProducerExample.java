import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // bootstrap broker
        properties.setProperty("bootstrap.servers", "192.168.99.100:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        // acks
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "3");
        properties.setProperty("linger.ms", "5");

        // create a new producer with properties
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // sending message
        for (int i = 0; i < 10; ++i) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", i + "", "intelli IDEA message for key: " + i);
            producer.send(record);
        }

        producer.close();
    }
}
