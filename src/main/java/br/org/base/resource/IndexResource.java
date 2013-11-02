package br.org.base.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 11/1/13
 * Time: 2:55 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/oo")
public class IndexResource {



    public IndexResource(){

    }



    @GET
    @Produces(MediaType.TEXT_HTML)
    public String alo(){

        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/webapp/index.html"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();

        return content;
    }
}
