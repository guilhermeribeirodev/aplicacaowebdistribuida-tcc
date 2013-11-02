import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 10/31/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProdutoTeste {

    @Test
    public void readAll() throws URISyntaxException, IOException, HttpException {

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8081/produtos");
        HttpResponse response = client.execute(request);


        BufferedReader rd = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line+"\n");
        }
    }

}
