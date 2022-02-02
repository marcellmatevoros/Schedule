
public class Contacto implements Comparable<Contacto> {
	private String name;
	private String phone;
	private String email;
	private String address;

	public Contacto() {
	}

	public Contacto(String name, String phone, String email, String address) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public String toString() {
		return "Name: " + name + ", Phone: " + phone + ", Email: " + email + ", Address: " + address;
	}

	public int compareTo(Contacto o) {
		return this.name.compareTo(o.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
