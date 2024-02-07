package et.spi;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.lang.Nullable;

import java.io.*;
import java.nio.charset.Charset;

@Slf4j
public class TestRL {

    /*  @Mock
      private ConfigurableEnvironment env;*/
    private InputStream inputStream;
    //@Autowired
    // private ResourceLoader resourceLoader;

    @BeforeEach
    @SneakyThrows
    public void setup() {

        //MockitoAnnotations.initMocks(this);
        // InputStream inputStream = resourceLoader.getResource("classpath:variables.json").getInputStream();
        inputStream = TestRL.class.getClassLoader().getResourceAsStream("variables.json");
    }

    @SneakyThrows
    @Test
    public void testMyMethod() {

        //log.info(String.valueOf(readInputStream(inputStream)));
        log.info(String.valueOf(inputStreamToString(inputStream)));
        // log.info(env.getProperty("classpath"));
    }


    private String readInputStream(InputStream inputStream) {

        InputStream stream = new BufferedInputStream(inputStream);
        byte[] buffer = new byte[1024];
        try {
            while (stream.read() != -1) {
                stream.read(buffer);
            }
        } catch (IOException e) {
            try {
                inputStream.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            closeSilently(inputStream);
        }

        return new String(buffer, Charset.forName("UTF-8"));
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


    public static String copyToString(@Nullable InputStream in, Charset charset) throws IOException {
        if (in == null) {
            return "";
        }

        StringBuilder out = new StringBuilder(1024);
        InputStreamReader reader = new InputStreamReader(in, charset);
        char[] buffer = new char[1024];
        int charsRead;
        while ((charsRead = reader.read(buffer)) != -1) {
            out.append(buffer, 0, charsRead);
        }
        return out.toString();
    }


}

