package et.spi;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class MatcherAssert {
    @BeforeAll
    public static void init() throws IOException, ParseException {
        log.info("on side init ");
    }

    @BeforeEach
    public void setup() {
        /*MockitoAnnotations.initMocks(
                this);*/
        log.info("on side init");

    }


    @Test
    public void testMatcherAssert() {

        try {
            InputStream inputStream = TestRL.class.getClassLoader().getResourceAsStream("variables.json");
            log.info(String.valueOf(inputStreamToString(inputStream)));
        } catch (IOException exception) {

            org.hamcrest.MatcherAssert.assertThat(exception, instanceOf(NullPointerException.class));

        }

    }

    public String inputStreamToString(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();

    }

    private static void closeSilently(InputStream inputStream) {
        try {

            inputStream.close();
        } catch (Exception e) {

        }
    }
}
