package et.spi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestProps {

    @Value("${test.value1}")
    String testProp;

    @PostConstruct
    void run() {
        System.out.println(testProp);

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory is: " + currentDirectory);
    }
}