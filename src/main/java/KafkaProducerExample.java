import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.99.100:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<String, String>("second_topic", Integer.toString(i), Integer.toString(i)));

        producer.close();
        producer.flush();
        /*
        Properties properties = new Properties();

        // bootstrap broker
        properties.setProperty("bootstrap.servers", "192.168.99.100:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        // acks
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "1");
        properties.setProperty("linger.ms", "5");

        // create a new producer with properties
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // sending message
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("second_topic", "3", "intelli IDEA message for key: ");
        producer.send(record);
        producer.flush();

        for (int i = 0; i < 10; ++i) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", i + "", "intelli IDEA message for key: " + i);
            producer.send(record);
        }
         */

        producer.close();
    }
}
