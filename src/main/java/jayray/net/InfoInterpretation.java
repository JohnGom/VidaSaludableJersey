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
import jayray.net.bd.InterpretationDb;
import jayray.net.bd.JornadaDb;
import jayray.net.data.Client;
import jayray.net.data.DetalleInt;
import jayray.net.data.Pregunta;

@Path("/interpretation")
public class InfoInterpretation {
	
	@GET
    @Path("/getquestions")
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Pregunta> infoQuestions(@QueryParam("dimension") String dimension) throws Exception {
    try {
		InterpretationDb inter = new InterpretationDb();
	    return inter.questionsByDimension(dimension);
	} catch (Exception e) {
		throw e;
	}
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/detallesInter")
	public String assignEn(ArrayList<DetalleInt> detalles) throws Exception{
		InterpretationDb inter = new InterpretationDb();
		inter.insertDetail(detalles);
		return "ok";
    }
}
