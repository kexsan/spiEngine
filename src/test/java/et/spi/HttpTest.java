package et.spi;


import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: tishko
 * Date: 28/05/2021
 * Time: 11:41 AM
 * To change this template use File | Settings | File and Code Templates.
 */
public class HttpTest
{
    private List<HttpTestTask> tasks = new ArrayList<HttpTestTask>();
    private final ExecutorService exec = Executors.newCachedThreadPool();
    public static void main(String[] args)
    {
        //new HttpTest().run();
        try
        {
            new HttpTest().test();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public  void test1(){
        try
        {
            test();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void test() throws InterruptedException
    {
        for (int i=0;i<100;i++){
            tasks.add(new HttpTestTask());
        }
        exec.invokeAll(tasks);
        exec.shutdown();
    }

    private void run()
    {
        for (int i =0 ; i<1000; i++)
        {
            //cc("http://localhost:3000/api/websphere?actionId=CustomerSearch&customerId=AAAAAA");
            //cc("http://localhost:3000/api/websphere?actionId=AMobile&customerId=AAAAAA&sessionId=470c6042-4390-4361-aa43-c5328ad1c6a4");
            // cc("http://localhost:3000/api/websphere?actionId=Claims&customerId=AAAAAA&sessionId=470c6042-4390-4361-aa43-c5328ad1c6a4");
            cc("http://localhost:3000/api/websphere?actionId=CardListStatuses&customerId=AAAAAA&sessionId="+composeIncidentId());
            //cc("http://localhost:3000/api/websphere?actionId=LifeStyle&customerId=AAAAAA&sessionId=470c6042-4390-4361-aa43-c5328ad1c6a4");
            //cc("http://localhost:3000/api/websphere?actionId=LifeStyle&customerId=AAAAAA&sessionId=470c6042-4390-4361-aa43-c5328ad1c6a4");
            //cc("http://localhost:3000/api/websphere?actionId=AccountFilter&operationName=ACCOUNT_CONVERTATIONS&sessionId=470c6042-4390-4361-aa43-c5328ad1c6a4");
            //  cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=CardIssueDataAddInfo&customerId=AAAAAA&servicePacketCode=b01&contractKindCode=fsdf&type=r&kind=dweq&sessionId="+composeIncidentId());
            // cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=CardIssueData&customerId=AAAAAA&servicePacketCode=b01&contractKindCode=fsdf&type=r&kind=dweq&sessionId="+composeIncidentId());

            //  http://localhost:9080/Advisor/servlet/MainServices?actionId=CardIssueDataAddInfo&customerId=AAAAAA&servicePacketCode=b01&contractKindCode=fsdf&type=r&kind=dweq

            cc("http://localhost:3001/api/websphere?actionId=CardIssueDataAddInfo&customerId=AAAAAA&servicePacketCode=b01&contractKindCode=fsdf&type=r&kind=dweq&sessionId="+composeIncidentId());
            cc("http://localhost:3001/api/websphere?actionId=CardIssueData&customerId=AAAAAA&servicePacketCode=b01&contractKindCode=fsdf&type=r&kind=dweq&sessionId="+composeIncidentId());


        }


// Finally we have the response
        System.out.println();
    }
    public static String composeIncidentId() {
        return UUID.randomUUID().toString()/*+" exception with id was received "*/;
    }
    int count ;
    String expected;
    private void cc(String req)
    {
        try
        {
            // Create a neat value object to hold the URL
            URL url = new URL(req);


            HttpURLConnection connection = null;

            connection = (HttpURLConnection) url.openConnection();



            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("authorization", "Basic dV8xMjM0NTY3ODkxMDpHZmhqa205MTE="  /*Base64.encode("u_12345678910:Gfhjkm911".getBytes())*/);

// This line makes the request

            InputStream responseStream = connection.getInputStream();
            String text = IOUtils.toString(responseStream, StandardCharsets.UTF_8.name());
            if (expected==null){
                expected=text;
            }
            if (text.equals(expected))
            {
                System.out.println("Passed");
            }

            System.out.println(text);
            count++;
            System.out.println(count);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
