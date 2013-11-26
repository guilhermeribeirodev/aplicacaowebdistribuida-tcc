package br.org.base.resource;

import br.org.base.model.Venda;
import br.org.base.server.Server;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.WriteResult;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
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
@Path("vendas")
public class VendaResource implements Crud<Venda>{


    static final JacksonDBCollection<Venda, String> jacksonDB = JacksonDBCollection.wrap(Server.mongoDB.getCollection(Venda.class.getSimpleName().toLowerCase()), Venda.class, String.class);

    public VendaResource() {

    }

    private static final Logger LOGGER = Logger.getLogger(VendaResource.class.getName());


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Venda create(Venda venda) {


        WriteResult<Venda, String> res = jacksonDB.insert(venda);
        return (Venda) res.getSavedObject();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Venda read(@PathParam("id") String id){




        return jacksonDB.findOneById(id);
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Venda> readAll(@Context UriInfo ui) {


        List<Venda> lista = new ArrayList<Venda>();
        DBCursor<Venda> cursor = jacksonDB.find();

        while (cursor.hasNext()) {
            Venda t = cursor.next();



            lista.add(t);
        }


        return lista;
    }

    @PUT
    @Path("{id}")
    public Venda update(@PathParam("id") String id, Venda venda) {

        WriteResult<Venda, String> res = jacksonDB.updateById(id,venda);
        return (Venda) res.getSavedObject();
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {

        WriteResult<Venda, String> res = jacksonDB.removeById(id);

        System.out.println(res);
    }

}
