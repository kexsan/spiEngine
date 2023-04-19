package et.spi;

import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

public class CreateTopicExample {


    public static void main(String[] args) throws Exception {
        // Set the configuration properties for the Kafka AdminClient
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // Create a new AdminClient instance
        try (AdminClient adminClient = AdminClient.create(config)) {
            // Create a new Kafka topic with the given name, replication factor, and number of partitions
            NewTopic newTopic = new NewTopic("my-topic", 1, (short) 1);

            // Create the topic using the AdminClient
            adminClient.createTopics(Collections.singleton(newTopic)).all().get();
        }

        System.out.println("Topic created successfully");
    }
}
