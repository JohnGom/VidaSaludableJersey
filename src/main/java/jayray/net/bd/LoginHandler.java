package jayray.net.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import jayray.net.data.Intervencion;
import jayray.net.data.User;
 
public class LoginHandler {
 
public ArrayList<User> getAllUsers(Connection connection) throws Exception {
ArrayList<User> userList = new ArrayList<User>();
try {
// String uname = request.getParameter("uname");
PreparedStatement ps = connection
.prepareStatement("SELECT * FROM encargados");
// ps.setString(1,uname);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
User uservo = new User();
uservo.setId(rs.getInt("cedula"));
uservo.setName(rs.getString("nombre"));
uservo.setUsername(rs.getString("usuario"));
uservo.setPassword(rs.getString("contrasena"));
uservo.setType(rs.getString("tipo"));
userList.add(uservo);
}
return userList;
} catch (Exception e) {
throw e;
}
}

public ArrayList<User> users(int id) throws Exception {
	DbConnection database= new DbConnection();
	Connection connection = database.getConnection();
    ArrayList<User> userList = new ArrayList<User>();
	try {
	// String uname = request.getParameter("uname");
	PreparedStatement ps = connection
	.prepareStatement("select en.* from encargados en  \r\n" + 
			"inner JOIN encargadosjornada ej ON ej.encargado=en.cedula\r\n" + 
			"WHERE ej.jornada=" + id);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
    User uservo = new User();
	uservo.setId(rs.getInt("cedula"));
	uservo.setName(rs.getString("nombre"));
	uservo.setUsername(rs.getString("usuario"));
	uservo.setPassword(rs.getString("contrasena"));
	uservo.setType(rs.getString("tipo"));
	userList.add(uservo);
	}
	return userList;
	} catch (Exception e) {
	throw e;
	}
	}


public ClientResponse sendSimpleMessage(Intervencion intervencion) {
	  Client client = Client.create();
	  client.addFilter(new HTTPBasicAuthFilter("api", "key-c0671463e8da3d91d8f010aa21dff49a"));
	  WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox98f018b327de4a4fa286cd3f643b014e.mailgun.org/messages");
	  MultivaluedMapImpl formData = new MultivaluedMapImpl();
	  formData.add("from", "Mailgun Sandbox <postmaster@sandbox98f018b327de4a4fa286cd3f643b014e.mailgun.org>");
	  formData.add("to", intervencion.getCorreo());
	  formData.add("subject", "Resultados de intervencion UNAC");
	  formData.add("text", "Resultado: " + intervencion.getResultado());
	  formData.add("text", "Observacion: " + intervencion.getObservacion());
	  for(int i=0; i<intervencion.getInterpretaciones().size(); i++ ) {
		  formData.add("text", intervencion.getInterpretaciones().get(i).getNombre()+ ": " + intervencion.getInterpretaciones().get(i).getResultado());
		  formData.add("text", "Recomendación : " + intervencion.getInterpretaciones().get(i).getRecomendacion());
	  }
	  	  return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class,
	      formData);
	}
}

