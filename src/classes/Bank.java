package classes;

public class Bank {
	int id = 0;
	String key = "";
	String name = "";
	int bik = 0;
	String account = "";
	String place = "";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBik() {
		return bik;
	}
	public void setBik(int bik) {
		this.bik = bik;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Bank(int id, String key, String name, int bik, String account,
			String place) {
		super();
		this.id = id;
		this.key = key;
		this.name = name;
		this.bik = bik;
		this.account = account;
		this.place = place;
	}
	
	public Bank(){
		super();
	}
	
	public String toStringToDB(){
		return "insert into banks values(" + this.id + ", \'" + this.key + "\', \'" + this.name + "\', " + this.bik + ", \'" + this.account + "\', \'" + this.place + "\');"; 
	}
	
	public String toString(){
		return "id=" + this.id + ", key=" + this.key + ", name=" + this.name + ", bik=" + this.bik + ", account=" + this.account + ", place" + this.place; 
	}
	

}
