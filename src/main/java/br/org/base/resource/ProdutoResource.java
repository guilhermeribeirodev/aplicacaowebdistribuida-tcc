package br.org.base.resource;

import br.org.base.model.Produto;
import br.org.base.server.Server;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.WriteResult;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 10/31/13
 * Time: 2:13 AM
 * To change this template use File | Settings | File Templates.
 */

@Singleton
@Path("produtos")
public class ProdutoResource implements Crud<Produto>{


    static final JacksonDBCollection<Produto, String> jacksonDB = JacksonDBCollection.wrap(Server.mongoDB.getCollection(Produto.class.getSimpleName().toLowerCase()), Produto.class, String.class);

    public ProdutoResource() {

    }

    private static final Logger LOGGER = Logger.getLogger(ProdutoResource.class.getName());


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Produto create(Produto produto) {


        WriteResult<Produto, String> res = jacksonDB.insert(produto);
        return (Produto) res.getSavedObject();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto read(@PathParam("id") String id){




        return jacksonDB.findOneById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> readAll() {


        List<Produto> lista = new ArrayList<Produto>();
        DBCursor<Produto> cursor = jacksonDB.find();

        while (cursor.hasNext()) {
            Produto t = cursor.next();



            lista.add(t);
        }


        return lista;
    }

    @PUT
    @Path("{id}")
    public Produto update(@PathParam("id") String id, Produto produto) {

        return new Produto();
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {

        WriteResult<Produto, String> res = jacksonDB.removeById(id);

        System.out.println(res);
    }

}
