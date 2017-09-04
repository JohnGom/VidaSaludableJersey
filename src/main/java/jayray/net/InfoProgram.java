package jayray.net;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.ObjectMapper;

import jayray.net.bd.JornadaDb;
import jayray.net.bd.Program;
import jayray.net.data.Jornada;
import jayray.net.data.Programa;
import jayray.net.data.User;

@Path("/program")
public class InfoProgram {

	@GET
    @Path("/getprograms")
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Programa> getProgama(@QueryParam("encargado") int idEncargado) throws Exception {
    try {
		Program program = new Program();
	    return program.getPrograms(idEncargado);
	} catch (Exception e) {
		throw e;
	}
	}
	
	@GET
    @Path("/getallprograms")
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Programa> getProgama() throws Exception {
    try {
		Program program = new Program();
	    return program.getAllPrograms();
	} catch (Exception e) {
		throw e;
	}
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/newProgram")
	public String create(Programa programa) throws Exception{
        
		Program program = new Program();
		program.insertProgram(programa);
		return "ok";
        
    }
	
	@DELETE
    @Path("/deleteprogram")
	@Produces(MediaType.TEXT_PLAIN)
    public String deleteJornada(@QueryParam("id") int idPrograma) throws Exception {
    try {
    	
    	Program program = new Program();
    	program.DeletePrograma(idPrograma);
		return "ok";
	} catch (Exception e) {
		throw e;
	}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/updprograma")
	public String Update(Programa programa) throws Exception{
        
		Program program = new Program();
		program.updatePrograma(programa);
		return "ok";
        
    }
	
}


