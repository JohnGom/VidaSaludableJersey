package jayray.net.data;

import java.sql.Date;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jornada {
	private int id;
	private ArrayList<User> encargados;
	private int programa;
	private String name;
	private String city;
	private String department;
	private Date date;
	private String tipo;
	private String place;
	private String state;
	private Programa program;
	
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@XmlElement
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@XmlElement
	public Date getDate() {
		return date;
	}
	public void setDate(Date string) {
		this.date = string;
	}
	@XmlElement
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@XmlElement
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public int getPrograma() {
		return programa;
	}
	public void setPrograma(int programa) {
		this.programa = programa;
	}
	@XmlElement
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@XmlElement
	public ArrayList<User> getEncargados() {
		return encargados;
	}
	public void setEncargados(ArrayList<User> encargados) {
		this.encargados = encargados;
	}
	@XmlElement
	public Programa getProgram() {
		return program;
	}
	public void setProgram(Programa program) {
		this.program = program;
	}

}
