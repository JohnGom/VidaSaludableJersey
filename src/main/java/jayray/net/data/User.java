package jayray.net.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	private String type;
	private boolean state;
	
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
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
}

