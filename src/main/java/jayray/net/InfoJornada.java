package jayray.net;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jayray.net.bd.JornadaDb;
import jayray.net.bd.Program;
import jayray.net.data.Jornada;
import jayray.net.data.Programa;

@Path("/jornada")
public class InfoJornada {
	
	@GET
    @Path("/allJornadas")
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Jornada> getProgama() throws Exception {
    try {
    	JornadaDb jor = new JornadaDb();
	    return jor.getAllJornadas();
	} catch (Exception e) {
		throw e;
	}
	}
	
	@GET
    @Path("/getjornada")
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Jornada> getProgama(@QueryParam("programa") int idPrograma) throws Exception {
    try {
    	JornadaDb jor = new JornadaDb();
	    return jor.getJornadas(idPrograma);
	} catch (Exception e) {
		throw e;
	}
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/newJornada")
	public String create(Jornada jornada) throws Exception{
        
		JornadaDb jornad = new JornadaDb();
		jornad.insertJornada(jornada);
		return "ok";
        
    }
	
	@DELETE
    @Path("/deletejornada")
	@Produces(MediaType.TEXT_PLAIN)
    public String deleteJornada(@QueryParam("id") int idJornada) throws Exception {
    try {
    	
    	JornadaDb jornad = new JornadaDb();
		jornad.DeleteJornada(idJornada);
		return "ok";
	} catch (Exception e) {
		throw e;
	}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/updjornada")
	public String Update(Jornada jornada) throws Exception{
        
		JornadaDb jornad = new JornadaDb();
		jornad.UpdateJornada(jornada);
		return "ok";
        
    }
}
