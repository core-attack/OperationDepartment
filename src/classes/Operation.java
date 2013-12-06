package classes;

public class Operation {
	int id = 0;
	String name = "";
	String _char = "";
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
	public String get_char() {
		return _char;
	}
	public void set_char(String _char) {
		this._char = _char;
	}
	public Operation(int id, String name, String _char) {
		super();
		this.id = id;
		this.name = name;
		this._char = _char;
	}
	public Operation(){}
	
	public String toStringToDB(){
		return "insert into operationstype values(" + this.id + ", \'" + this.name + "\', \'" + this._char + "\');"; 
	}
	
	public String toString(){
		return "id=" + this.id + ", name=" + this.name + ", char=" + this._char; 
	}

}
