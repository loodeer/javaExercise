import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * Manual connection release
 * This example demonstrates how to ensure the release of the underlying HTTP connection back to the connection manager in case of a manual processing of HTTP responses.
 * @author loodeer
 * @date 2018-12-19 20:10
 */
public class ClientConnectionRelease {

    public final static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("http://beibei.com");

            System.out.println("请求：" + httpGet.getRequestLine());
            CloseableHttpResponse response = httpClient.execute(httpGet);

            try {
                System.out.println("--------------");
                System.out.println(response.getStatusLine());

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream inputStream = entity.getContent();
                    try {
                        inputStream.read();
                    } catch (IOException ex) {
                        throw ex;
                    } finally {
                        inputStream.close();
                    }
                }
            } finally {
                response.close();
            }
        } finally {
           httpClient.close();
        }
    }

}
