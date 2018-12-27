import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author loodeer
 * @date 2018-12-19 21:00
 */
public class HttpClientExample {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpClientExample http = new HttpClientExample();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

        System.out.println("\nTesting 2 - Send Http POST request");
        http.sendPost();

    }

    private void sendGet() throws IOException {
        String url = "http://127.0.0.1:8090/user/get?id=2";

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);

        System.out.println("\nSending 'GET' request to url : " + url);
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());
    }

    private void sendPost() throws IOException {
        String url = "http://127.0.0.1:8090/user/register";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("telphone", "13334567890"));
        urlParameters.add(new BasicNameValuePair("otpCode", "8888"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());
    }
}
