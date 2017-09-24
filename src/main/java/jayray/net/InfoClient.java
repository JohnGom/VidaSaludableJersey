package jayray.net;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jayray.net.bd.ClientDb;
import jayray.net.bd.Program;
import jayray.net.data.Client;
import jayray.net.data.Programa;

@Path("/client")
public class InfoClient {

	@GET
    @Path("/getClient")
	@Produces(MediaType.APPLICATION_JSON)
    public Client infoClient(@QueryParam("id") int id) throws Exception {
    try {
		ClientDb client = new ClientDb();
	    return client.ClientById(id);
	} catch (Exception e) {
		throw e;
	}
	}
}
