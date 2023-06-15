package et.spi;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.Callable;

public class HttpTestTask  implements Callable<String>
{
    @Override
    public String call() throws Exception
    {
        final String cc = "ss";
        for (int i =0;i<100;i++)
        {
            cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=CardList&customerId=AAAAAA&sessionId=" + composeIncidentId());
            final String sessionId = composeIncidentId();
            //cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=SaveClientSession&customerId=AAABSZ&authorizationCode=0&ivrAuthorized=false&customerVerified=true&consultationCall=false&specialModeComment=sdfsdfsfdsfdsfd&callTimer=1632163157538&operationName=save&contactType=PC&roleId=supervisor&sessionId=" + sessionId);
            // cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=SaveAuthStatus&authorizationCode=512&customerId=AAABSZ&specialModeComment=33333&contactId=30004&sessionId="+sessionId+"&roleId=supervisor" );
            // cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=SaveClientSession&authorizationCode=0&ivrAuthorized=false&customerVerified=false&ani=26400&dnis=4444&consultationCall=false&callTimer=1632165098984&operationName=save&contactType=CC&specialModeComment=&sessionId="+sessionId+"&roleId=supervisor" );
            // cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=DeleteClientSession&customerId=AAABSZ&sessionId="+sessionId );


            //  cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=CardIssueDataAddInfo&customerId=AAAAAA&servicePacketCode=b01&contractKindCode=fsdf&type=r&kind=dweq&sessionId="+sessionId);
            // cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=CardIssueData&customerId=AAAAAA&servicePacketCode=b01&contractKindCode=fsdf&type=r&kind=dweq&sessionId="+sessionId);
            //   cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=UserRoles");
            //  cc("http://localhost:9080/Advisor/servlet/MainServices?actionId=SaveClientSession&customerId=AAABSZ&authorizationCode=0&ivrAuthorized=false&customerVerified=true&consultationCall=false&specialModeComment=sdfsdfsfdsfdsfd&callTimer=1632163157538&operationName=save&contactType=PC&roleId=supervisor&sessionId=" + sessionId);


            //cc("http://localhost:10001/api/websphere?actionId=UserRoles");
            //cc("http://localhost:10001/api/websphere?actionId=SaveClientSession&customerId=AAABSZ&authorizationCode=0&ivrAuthorized=false&customerVerified=true&consultationCall=false&specialModeComment=sdfsdfsfdsfdsfd&callTimer=1632163157538&operationName=save&contactType=PC&roleId=supervisor&sessionId=" + sessionId);
            //cc("http://localhost:10001/api/websphere?actionId=CardList&customerId=AAAAAA&sessionId=" + composeIncidentId());



        }
        return cc;
    }

    public static String composeIncidentId() {
        return UUID.randomUUID().toString()/*+" exception with id was received "*/;
    }

    int count ;
    String expected;
    private String cc(String req)
    {
        try
        {
            // Create a neat value object to hold the URL
            URL url = new URL(req);


            HttpURLConnection connection = null;

            connection = (HttpURLConnection) url.openConnection();



            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("Authorization", "Basic dV8wMDAzOkdmaGprbTkxMQ=="  /*Base64.encode("u_0003:Gfhjkm911".getBytes())*/);
            // connection.setRequestProperty("Authorization", "Basic dV8xMjM0NTY3ODkxMDpHZmhqa205MTE="  /*Base64.encode("u_1234567890:Gfhjkm911".getBytes())*/);

// This line makes the request
            long start = System.currentTimeMillis();
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
            System.out.println(System.currentTimeMillis()-start );
            return text;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "req";
    }
}
