package classes;

public class BankAccountSecondOrder {
	int id = 0;
	String number = "";
	String name;
	String activity = "";
	int bfs_code = 0;
	String acc1_number= "";
	
	public BankAccountSecondOrder() {
		super();
	}

	public BankAccountSecondOrder(int id, String number, String name,
			String activity, int bfs_code, String acc1_number) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.activity = activity;
		this.bfs_code = bfs_code;
		this.acc1_number = acc1_number;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getAcc1_number() {
		return acc1_number;
	}

	public void setAcc1_number(String acc1_number) {
		this.acc1_number = acc1_number;
	}

	public String toStringToDB(){
		return "insert into bank_accounts_second_order values(" + this.id + ", " + this.number + ", \'" + this.name + "\', \'" + this.activity + "\', " + this.bfs_code +  ", \'" + this.acc1_number + "\');"; 
	}
	
	public String toString(){
		return "id=" + this.id + ", number=" + this.number + ", name=" + this.name + ", activity=" + this.activity + ", bfs_code=" + this.bfs_code + ", acc1_number=" + this.acc1_number; 
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


