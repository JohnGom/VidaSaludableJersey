package jayray.net.model;

import java.sql.Connection;
import java.util.ArrayList;
 
import jayray.net.data.User;
 
import jayray.net.bd.DbConnection;
 
import jayray.net.bd.LoginHandler;
 
public class SecurityManager {
 
public ArrayList<User> getAllUsersList()throws Exception {
ArrayList<User> userList = null;
try {
DbConnection database= new DbConnection();
Connection connection = database.getConnection();
LoginHandler loginHandler= new LoginHandler();
userList= loginHandler.getAllUsers(connection);
 
} catch (Exception e) {
throw e;
}
return userList;
}
 
}
