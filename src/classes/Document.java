package classes;

import java.util.Date;

public class Document {
	
	int id = 0;
	//счет 
	int bankAccountId = -1;
	//номер документа
	String number = "";
	//дата документа
	Date date = new Date();
	//сумма
	float sum = 0;
	//сумма в рублях
	float sumRub = 0;
	//назначение платежа
	String paymentAim = "";
	//вид документа
	String documentType = "";
	//вид платежа
	String paymentType = "";
	//валюта
	String currency = "";
	//счет получателя
	int addresseeBankAccount = -1;
	String name = "";
	//КПП
	int KPP = 0;
	//ИНН
	int TIN = 0;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public float getSumRub() {
		return sumRub;
	}
	public void setSumRub(float sumRub) {
		this.sumRub = sumRub;
	}
	public String getPaymentAim() {
		return paymentAim;
	}
	public void setPaymentAim(String paymentAim) {
		this.paymentAim = paymentAim;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCyrrency() {
		return currency;
	}
	public void setCyrrency(String currency) {
		currency = currency;
	}
	public int getAddresseeBankAccount() {
		return addresseeBankAccount;
	}
	public void setAddresseeBankAccount(int addresseeBankAccount) {
		this.addresseeBankAccount = addresseeBankAccount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKPP() {
		return KPP;
	}
	public void setKPP(int kPP) {
		KPP = kPP;
	}
	public int getTIN() {
		return TIN;
	}
	public void setTIN(int tIN) {
		TIN = tIN;
	}
	public Document(int id, int bankAccountId, String number, Date date,
			float sum, float sumRub, String paymentAim, String documentType,
			String paymentType, String currency, int addresseeBankAccount,
			String name, int kPP, int tIN) {
		super();
		this.id = id;
		this.bankAccountId = bankAccountId;
		this.number = number;
		this.date = date;
		this.sum = sum;
		this.sumRub = sumRub;
		this.paymentAim = paymentAim;
		this.documentType = documentType;
		this.paymentType = paymentType;
		this.currency = currency;
		this.addresseeBankAccount = addresseeBankAccount;
		this.name = name;
		KPP = kPP;
		TIN = tIN;
	}
	

}
