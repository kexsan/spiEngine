package st;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtMetaDataProviderConf {

    @Bean
    public ExtMetaDataProvider extMetaDataProvider(){
        return new ExtMetaDataProvider();
    }
}
