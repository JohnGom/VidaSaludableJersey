package jayray.net;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jayray.net.model.SecurityManager;
import jayray.net.data.User;

@Path("/WebService")
public class EchoResource {

	@GET
    @Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
    public User sayhello(@QueryParam("username") String username, @QueryParam("password") String password) {
        return getAllUsersList(username, password);
    }
	

	public User getAllUsersList(String username,String password)
	{
		try 
		{
			ArrayList<User> userList = null;
			SecurityManager securityManager= new SecurityManager();
			userList = securityManager.getAllUsersList();
			for (User userVO : userList) {
				if(userVO.getUsername().equals(username))
				{
					if(userVO.getPassword().equals(password))
					{
						return userVO;
					} 
				}
			}

		} catch (Exception e)
		{
			System.out.println("error" + e);
		}
		return null;
	}
}