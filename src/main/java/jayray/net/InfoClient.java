package jayray.net;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jayray.net.bd.ClientDb;
import jayray.net.bd.JornadaDb;
import jayray.net.bd.Program;
import jayray.net.data.Client;
import jayray.net.data.Intervencion;
import jayray.net.data.Jornada;
import jayray.net.data.Programa;

@Path("/client")
public class InfoClient {

	@GET
    @Path("/getClient")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Client infoClient(@QueryParam("id") int id) throws Exception {
    try {
		ClientDb client = new ClientDb();
	    return client.ClientById(id);
	} catch (Exception e) {
		throw e;
	}
	}
	
	@GET
    @Path("/getinterventions")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public ArrayList<Intervencion> infoInter(@QueryParam("id") int id) throws Exception {
    try {
		ClientDb client = new ClientDb();
	    return client.IntervencionByJornada(id);
	} catch (Exception e) {
		throw e;
	}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	@Path("/saveparticipante")
	public String newClient(Client client) throws Exception{
        
		ClientDb cliente = new ClientDb();
		cliente.insertCliente(client);
		return "ok";
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	@Path("/saveintervencion")
	public int create(Intervencion intervencion) throws Exception{
        
		ClientDb client = new ClientDb();
		int id = client.insertIntervention(intervencion);
		return id;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	@Path("/updateintervencion")
	public String update(Intervencion intervencion) throws Exception{
        
		ClientDb client = new ClientDb();
		client.updateIntervention(intervencion);
		return "ok";
    }
}
