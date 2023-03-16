package et.spi;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.ServiceLoader;

@Data
@Slf4j
@RestController
public class BaseController {

    private final CacheService cacheService;

    public BaseController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/testSpi")
    public ResponseEntity hello(@RequestParam(value = "name", defaultValue = "Spi tester") String name) {

        try {
            cc();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        log.debug("CLASSPATHtishko" + System.getenv("CLASSPATH"));
        return new ResponseEntity<>(String.format("Hello %s!", name) + " " + System.getenv("CLASSPATH"), HttpStatus.OK);


    }


    @GetMapping("/testCache")
    public ResponseEntity testCache(@RequestParam(value = "name", defaultValue = "tester testCache") String name) {

        try {
            return new ResponseEntity<>(dd(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Cacheable("myCache")
    public String dd(String s) {
        log.info("From input");

        log.debug(cacheService.getCachedData(s));
        return s != null ? s : "NULL";
    }


    private void cc() {
        log.info("I'm logger");
        System.out.println("CLASSPATH " + System.getenv("CLASSPATH"));
        extracted();
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);
        Iterator<ExchangeRateProvider> iterator = loader.iterator();
        if (iterator.hasNext()) {
            System.out.println("resolved classes: ");
            ExchangeRateProvider provider = iterator.next();
            System.out.println(provider);
            System.out.println(provider.create().getQuotes("", LocalDate.now()));


        } else throw new IllegalStateException("implementation of the of the ExchangeRateProvider isn't not found");

    }

    private static void extracted() {
        try {

            Class<?> aClass = Class.forName("et.spi.YahooFinanceExchangeRateProvider");

            if (aClass != null) {
                log.info(aClass.getCanonicalName());
                log.info("Class file location: " + aClass.getClassLoader().getResource("et/spi/YahooFinanceExchangeRateProvider.class"));
            }
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        } finally {
        }
    }
}
