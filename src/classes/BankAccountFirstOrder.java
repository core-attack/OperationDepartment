package classes;

public class BankAccountFirstOrder {
	int id = 0;
	String number = "";
	String name;
	int bfs_code = 0;
	
	public String toStringToDB(){
		return "insert into bank_accounts_first_order values(" + this.id + ", " + this.number + ", \'" + this.name + "\', " + this.bfs_code + ");"; 
	}
	
	public String toString(){
		return "id=" + this.id + ", number=" + this.number + ", name=" + this.name + ", bfs_code=" + this.bfs_code; 
	}
	
	public BankAccountFirstOrder() {
		super();
	}
	public BankAccountFirstOrder(int id, String number, String name, int bfs_code) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.bfs_code = bfs_code;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBfs_code() {
		return bfs_code;
	}
	public void setBfs_code(int bfs_code) {
		this.bfs_code = bfs_code;
	}
	

}
