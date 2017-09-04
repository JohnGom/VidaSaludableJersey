package jayray.net.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int id;
	private String username;
	private String password;
	private String type;
	
	@XmlElement
	public String getUsername() {
	return username;
	}
	public void setUsername(String username) {
	this.username = username;
	}
	@XmlElement
	public String getPassword() {
	return password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	@XmlElement
	public String getType() {
	return type;
	}
	public void setType(String type) {
	this.type = type;
	}
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

