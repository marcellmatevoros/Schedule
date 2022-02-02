
public class Event implements Comparable<Event> {
	private String name;
	private String address;
	private String fecha;
	
	public Event() {
	}
	
	public Event(String name, String address, String fecha) {
		this.name = name;
		this.address = address;
		this.fecha = fecha;
	}
	
	public int compareTo(Event o) {
		return this.name.compareTo(o.name);
	}
	
	public String toString() {
		return "Name: " + name + ", Address: " + address + ", Fecha: " + fecha;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getName() {
		return name;
	}
}
