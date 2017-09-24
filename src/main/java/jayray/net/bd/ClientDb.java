package jayray.net.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jayray.net.data.Client;
import jayray.net.data.User;

public class ClientDb {
	public Client ClientById(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
	    ArrayList<Client> clientList = new ArrayList<Client>();
		try {
		Client client = new Client();
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM participantes where identificacion=" + id);
		// ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			client.setId(rs.getInt("identificacion"));
			client.setTypeId(rs.getString("tipoId"));
			client.setEducation(rs.getString("nivelEducacion"));
			client.setFirstname(rs.getString("nombres"));
			client.setLastname(rs.getString("apellidos"));
			client.setBirthdate(rs.getDate("fechaNacimiento"));
			client.setGender(rs.getString("genero"));
			client.setStratus(rs.getInt("estrato"));
			client.setCivilStatus(rs.getString("estadocivil"));
			client.setEps(rs.getString("aseguradora"));
			client.setOccupation(rs.getString("ocupacion"));
			client.setReligion(rs.getString("religion"));
			clientList.add(client);
		}
		return client;
		} catch (Exception e) {
		throw e;
		}
		}
}
