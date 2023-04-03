package et.spi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvComponent {

    @Autowired
    private Environment environment;

    public void retrieveApplicationName() {
        String applicationName = environment.getProperty("spring.application.name");
        System.out.println("Application name: " + applicationName);
    }
}