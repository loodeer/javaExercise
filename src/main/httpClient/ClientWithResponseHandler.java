import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author loodeer
 * @date 2018-12-19 19:42
 */
public class ClientWithResponseHandler {

    /**
     * This example demonstrates how to process HTTP responses using a response handler.
     * This is the recommended way of executing HTTP requests and processing HTTP responses.
     * This approach enables the caller to concentrate on the process of digesting HTTP responses and to delegate the task of system resource deallocation to HttpClient.
     * The use of an HTTP response handler guarantees that the underlying HTTP connection will be released back to the connection manager automatically in all cases.
     * @param args
     * @throws IOException
     */
    public final static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("http://baidu.com");
            System.out.println("request 请求：" + httpGet.getRequestLine());

            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override public String handleResponse(HttpResponse httpResponse)
                        throws ClientProtocolException, IOException {
                    int status = httpResponse.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = httpResponse.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("请求报错，状态码：" + status);
                    }
                }
            };
            String responseBody = httpClient.execute(httpGet, responseHandler);
            System.out.println(responseBody);
        } finally {
            httpClient.close();
        }
    }
}
