package et.spi;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class CacheService {

    @Cacheable("myCache")
    public String getCachedData(String key) {
        log.info("getting data without cache");
        return expensiveMethodCall(key);
    }

    private String expensiveMethodCall(String key) {
        return key;
    }
}