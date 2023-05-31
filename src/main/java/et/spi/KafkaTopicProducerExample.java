package et.spi;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaTopicProducerExample {

    public static void main(String[] args) throws Exception {
        produce();
       // consume();
    }

    private static void consume() {

        // Set the configuration properties for the Kafka consumer
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "my-group");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());

        // Create a new Kafka consumer instance
        Consumer<String, String> consumer = new KafkaConsumer<>(props);

        // Subscribe to the "my-topic" Kafka topic
        String topic = "my-topic";
        consumer.subscribe(Collections.singleton(topic));

        // Consume messages from the topic
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            records.forEach(record -> {
                System.out.printf("Received message: key=%s, value=%s, topic=%s, partition=%d, offset=%d%n",
                        record.key(), record.value(), record.topic(), record.partition(), record.offset());
            });
        }
    }

    private static void produce() {
        // Set the configuration properties for the Kafka producer
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create a new Kafka producer instance
        Producer<String, String> producer = new KafkaProducer<>(props);

        // Send a message to the "my-topic" Kafka topic
        String topic = "my-topic";
        String key = "my-key";
        String value = "Hello, Jack!";
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        producer.send(record);

        // Close the producer
        producer.close();

        System.out.println("Message sent successfully");
    }
}