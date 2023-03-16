package et.spi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpiEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpiEngineApplication.class, args);
	}



}
