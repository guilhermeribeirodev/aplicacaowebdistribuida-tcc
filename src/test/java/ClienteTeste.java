import br.org.base.model.Cliente;
import br.org.base.model.Produto;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;

import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 10/31/13
 * Time: 3:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class ClienteTeste {


    @Test
    public  void create() throws URISyntaxException, HttpException {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(
                    "http://localhost:8081/clientes");

            StringEntity input = new StringEntity("{\"nome\":\"asdasdas\",\"idade\":20}");
            input.setContentType(MediaType.APPLICATION_JSON);
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }


    @Test
    public void readAll() throws URISyntaxException, IOException, HttpException {

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8081/clientes");
        HttpResponse response = client.execute(request);


        BufferedReader rd = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line+"\n");
        }
    }



    @Test
    public void test(){

        Set clis = new HashSet();


        Cliente c = new Cliente();
        c.setDocumento("lkjlkjlkjlkj");

        clis.add(c);

        c.setIdade(12);

        clis.add(c);
        clis.add(new Cliente());
        clis.add(new Produto());


        for(Object cl : clis){
            System.out.println(cl);
        }

        System.out.println("\n/////////");

        List list = new LinkedList<>();

        Cliente g = new Cliente();

        g.setNome("sdjflksjdfl");

        list.add(new Cliente());
        list.add(g);
        list.add(new Cliente());
        list.add(new Produto());

        list.remove(g);

        list.remove(new Cliente());


        for(Object o: list){
            System.out.println(o);

        }


        System.out.println("\n/////////");

        Map<String, Object> hs = new HashMap<>();

        int ch = 65;
        for(int i =0; i< 10;i++){

            hs.put("chave map"+ Character.toChars(ch),  new Cliente());

            ch++;
        }

        hs.put("chave map2",  new Produto());


       Iterator it = hs.entrySet().iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }


        System.out.println("\n/////////");

        Map<String, Object> ts = new TreeMap<>();

        for(int i =0; i< 10;i++) ts.put("chave tree"+i,  new Produto());

        ts.put("chave tree2",  new Cliente());

        Iterator its = ts.entrySet().iterator();

        while(its.hasNext()){
            System.out.println(its.next());
        }
    }


}
