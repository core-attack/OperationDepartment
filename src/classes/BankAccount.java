package classes;

import java.util.Date;

public class BankAccount {
	int id = 0;
	int clientId = -1;
	int BankId = -1;
	float rest = 0;
	Date openningDate = new Date();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getBankId() {
		return BankId;
	}
	public void setBankId(int bankId) {
		BankId = bankId;
	}
	public float getRest() {
		return rest;
	}
	public void setRest(float rest) {
		this.rest = rest;
	}
	public Date getOpenningDate() {
		return openningDate;
	}
	public void setOpenningDate(Date openningDate) {
		this.openningDate = openningDate;
	}
	public BankAccount(int id, int clientId, int bankId, float rest,
			Date openningDate) {
		super();
		this.id = id;
		this.clientId = clientId;
		BankId = bankId;
		this.rest = rest;
		this.openningDate = openningDate;
	}
	
	
}
