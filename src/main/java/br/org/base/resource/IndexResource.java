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
@Path("/")
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
                contentBuilder.append("\n"+str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();

        //content.replace("<title>TCC","<title>TCC  xxxxxxx");

        return content.trim();
    }

    @Path("home")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String home(){



        return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" >\n" +
                "    <title>TCC --  plain</title>\n" +
                "\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"home/js/ext-4.0.1/resources/css/ext-all.css\" />\n" +
                "    <script type=\"text/javascript\" src=\"home/js/ext-4.0.1/ext-all-debug.js\"></script>\n" +
                "\n" +
                "\n" +
                "    <script type=\"text/javascript\">\n" +
                "        Ext.Loader.setPath({\n" +
                "            enabled: true,\n" +
                "\n" +
                "            'MyApp': '../js/MyApp'\n" +
                "        });\n" +
                "\n" +
                "        Ext.require(\"MyApp.models.Cliente\");\n" +
                "        Ext.require(\"MyApp.models.Produto\");\n" +
                "        Ext.require(\"MyApp.views.cliente.ClienteGridPanel\");\n" +
                "        Ext.require(\"MyApp.views.produto.ProdutoGridPanel\");\n" +
                "\n" +
                "\n" +
                "        Ext.onReady(function(){\n" +
                "\n" +
                "\n" +
                "\n" +
                "            var cliente = Ext.create('MyApp.models.Cliente')\n" +
                "\n" +
                "            cliente.set('nome','ksahdlasj')\n" +
                "\n" +
                "            cliente.set('criacao',new Date())\n" +
                "\n" +
                "            cliente.save();\n" +
                "\n" +
                "\n" +
                "            var produto = Ext.create('MyApp.models.Produto')\n" +
                "\n" +
                "            produto.set('nome','nome prod')\n" +
                "            produto.set('valor',2.56)\n" +
                "            produto.set('serie','16253176287')\n" +
                "\n" +
                "            produto.save()\n" +
                "\n" +
                "\n" +
                "\n" +
                "            //Ext.create('MyApp.views.cliente.ClienteGridPanel')\n" +
                "\n" +
                "\n" +
                "            //Ext.create('MyApp.views.cliente.ProdutoGridPanel')\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "            var win2 = Ext.create('widget.window', {\n" +
                "                height: 200,\n" +
                "                width: 400,\n" +
                "                x: 450,\n" +
                "                y: 450,\n" +
                "                title: 'Constraining Window, plain: true',\n" +
                "                closable: false,\n" +
                "                plain: true,\n" +
                "                layout: 'fit',\n" +
                "                items: [\n" +
                "                    Ext.create('MyApp.views.cliente.ClienteGridPanel')\n" +
                "                ]\n" +
                "            });\n" +
                "            win2.show();\n" +
                "\n" +
                "\n" +
                "            var win3 = Ext.create('widget.window', {\n" +
                "                height: 200,\n" +
                "                width: 400,\n" +
                "                x: 100,\n" +
                "                y: 100,\n" +
                "                title: 'dfsdfsdfsdf',\n" +
                "                closable: false,\n" +
                "                plain: true,\n" +
                "                layout: 'fit',\n" +
                "                items: [\n" +
                "                    Ext.create('MyApp.views.produto.ProdutoGridPanel')\n" +
                "                ]\n" +
                "            });\n" +
                "            win3.show();\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "        });\n" +
                "\n" +
                "\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}
