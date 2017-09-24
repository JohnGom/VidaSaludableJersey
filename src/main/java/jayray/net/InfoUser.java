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

import jayray.net.bd.Program;
import jayray.net.bd.UserDb;
import jayray.net.data.Programa;
import jayray.net.data.User;

@Path("/user")
public class InfoUser {
	@GET
    @Path("/getallUsers")
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getAllUser() throws Exception {
    try {
		UserDb user = new UserDb();
	    return user.getAllUsers();
	} catch (Exception e) {
		throw e;
	}
	}
	
	@GET
	@Path("/getinterviewers")
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUsersEncues() throws Exception {
    try {
		UserDb user = new UserDb();
	    return user.getUsersEncuestador();
	} catch (Exception e) {
		throw e;
	}
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/createUser")
	public String create(User user) throws Exception{
        
		UserDb userd = new UserDb();
		userd.insertUser(user);
		return "ok";
        
    }
	
	@DELETE
    @Path("/deleteUser")
	@Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@QueryParam("id") int idPrograma) throws Exception {
    try {
    	
    	UserDb userd = new UserDb();
    	userd.DeleteUser(idPrograma);
		return "ok";
	} catch (Exception e) {
		throw e;
	}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/updUser")
	public String Update(User user) throws Exception{
        
		UserDb userd = new UserDb();
		userd.updateUser(user);
		return "ok";
        
    }
}
