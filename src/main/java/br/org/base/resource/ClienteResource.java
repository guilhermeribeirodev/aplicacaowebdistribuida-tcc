package br.org.base.resource;

import br.org.base.model.Cliente;
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
@Path("clientes")
public class ClienteResource implements Crud<Cliente>{


    static final JacksonDBCollection<Cliente, String> jacksonDB = JacksonDBCollection.wrap(Server.mongoDB.getCollection(Cliente.class.getSimpleName().toLowerCase()), Cliente.class, String.class);

    public ClienteResource() {

    }

    private static final Logger LOGGER = Logger.getLogger(ClienteResource.class.getName());


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente create(Cliente cliente) {


        WriteResult<Cliente, String> res = jacksonDB.insert(cliente);
        return (Cliente) res.getSavedObject();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente read(@PathParam("id") String id){




        return jacksonDB.findOneById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> readAll() {


        List<Cliente> lista = new ArrayList<Cliente>();
        DBCursor<Cliente> cursor = jacksonDB.find();

        while (cursor.hasNext()) {
            Cliente t = cursor.next();



            lista.add(t);
        }


        return lista;
    }

    @PUT
    @Path("{id}")
    public Cliente update(@PathParam("id") String id, Cliente cliente) {

        WriteResult<Cliente, String> res = jacksonDB.updateById(id,cliente);
        return (Cliente) res.getSavedObject();
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {

        WriteResult<Cliente, String> res = jacksonDB.removeById(id);

        System.out.println(res);
    }

}
