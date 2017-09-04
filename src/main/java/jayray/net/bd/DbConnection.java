package jayray.net.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DbConnection {
 
public Connection getConnection() throws Exception
{
try
{
String connectionURL = "jdbc:mysql://localhost:3306/salud";
Connection connection = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "1234");
return connection;
}
catch (SQLException e)
{
throw e;
}
catch (Exception e)
{
throw e;
}
}
 
}
