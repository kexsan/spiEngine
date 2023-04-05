package et.spi;



import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.ConfigurableEnvironment;

import static org.mockito.Mockito.when;
@Log
public class MyTest {

    @Mock
    private ConfigurableEnvironment env;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMyMethod() {
        when(env.getProperty("my.property")).thenReturn("my.value");
        when(env.getProperty("classpath")).thenReturn(System.getProperty("java.class.path"));

        log.info(env.getProperty("classpath"));
    }




}

