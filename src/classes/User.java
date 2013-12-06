package classes;
import org.apache.log4j.Logger;
/**
 * Класс пользователь
 * */
public class User {
	/**
	 * идентификатор
	 * */
	int id = 0;
	/**
	 * логин
	 * */
	String login = "";
	/**
	 * пароль
	 * */
	String password = "";
	/**
	 * идентификатор клиента
	 * */
	int client_id = 0;

	/**
	 * конструктор
	 * */
	public User(){
		super();
	}
	/**
	 * печать всех полей класса
	 * */
	public String print(){
		return String.format("id=%d category_id=%d  login=%s password=%s", 
				getId(), getClient_id(), getLogin(), getPassword()); 
	}
	/**
	 * сложный конструктор
	 * */
	public User(int id, String login, String password, int client_id) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.client_id = client_id;
	}
	/**
	 * вернуть идентификатор
	 * */
	public int getId() {
		return id;
	}
	/**
	 * задать идентификатор
	 * */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * вернуть логин
	 * */
	public String getLogin() {
		return login;
	}
	/**
	 * задать логин
	 * */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * вернуть пароль
	 * */
	public String getPassword() {
		return password;
	}
	/**
	 * задать пароль
	 * */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * вернуть идентификатор клиента
	 * */
	public int getClient_id() {
		return client_id;
	}
	/**
	 * задать идентификатор клиента
	 * */
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

}
