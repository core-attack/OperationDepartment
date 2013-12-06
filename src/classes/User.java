package classes;
import org.apache.log4j.Logger;
/**
 * ����� ������������
 * */
public class User {
	/**
	 * �������������
	 * */
	int id = 0;
	/**
	 * �����
	 * */
	String login = "";
	/**
	 * ������
	 * */
	String password = "";
	/**
	 * ������������� �������
	 * */
	int client_id = 0;

	/**
	 * �����������
	 * */
	public User(){
		super();
	}
	/**
	 * ������ ���� ����� ������
	 * */
	public String print(){
		return String.format("id=%d category_id=%d  login=%s password=%s", 
				getId(), getClient_id(), getLogin(), getPassword()); 
	}
	/**
	 * ������� �����������
	 * */
	public User(int id, String login, String password, int client_id) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.client_id = client_id;
	}
	/**
	 * ������� �������������
	 * */
	public int getId() {
		return id;
	}
	/**
	 * ������ �������������
	 * */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ������� �����
	 * */
	public String getLogin() {
		return login;
	}
	/**
	 * ������ �����
	 * */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * ������� ������
	 * */
	public String getPassword() {
		return password;
	}
	/**
	 * ������ ������
	 * */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * ������� ������������� �������
	 * */
	public int getClient_id() {
		return client_id;
	}
	/**
	 * ������ ������������� �������
	 * */
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

}
