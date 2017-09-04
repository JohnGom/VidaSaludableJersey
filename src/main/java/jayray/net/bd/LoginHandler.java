package jayray.net.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
 
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

public User userById(int id) throws Exception {
	DbConnection database= new DbConnection();
	Connection connection = database.getConnection();
    ArrayList<User> userList = new ArrayList<User>();
	try {
	// String uname = request.getParameter("uname");
	User uservo = new User();
	PreparedStatement ps = connection
	.prepareStatement("SELECT * FROM encargados where cedula=" + id);
	// ps.setString(1,uname);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	uservo.setId(rs.getInt("cedula"));
	uservo.setUsername(rs.getString("usuario"));
	uservo.setPassword(rs.getString("contrasena"));
	uservo.setType(rs.getString("tipo"));
	userList.add(uservo);
	}
	return uservo;
	} catch (Exception e) {
	throw e;
	}
	}
}
