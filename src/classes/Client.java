package classes;

public class Client {
	int id = 0;
	String name = "";
	String phone = "";
	String address = "";
	int inn = 0;
	int kpp = 0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getInn() {
		return inn;
	}
	public void setInn(int inn) {
		this.inn = inn;
	}
	public int getKpp() {
		return kpp;
	}
	public void setKpp(int kpp) {
		this.kpp = kpp;
	}
	public Client(int id, String name, String phone, String address, int inn,
			int kpp) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.inn = inn;
		this.kpp = kpp;
	}
	

}
