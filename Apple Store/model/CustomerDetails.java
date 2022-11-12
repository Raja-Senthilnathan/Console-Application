package model;

public class CustomerDetails {
	
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private int pincode;
	private long phone_number;
	private String mail_id;
	private String password;
	
	public CustomerDetails(String first_name, String last_name, String address, String city, int pincode, long phone_number, String mail_id, String password){
		this.first_name=first_name;
		this.last_name=last_name;
		this.address=address;
		this.city=city;
		this.pincode=pincode;
		this.phone_number=phone_number;
		this.mail_id=mail_id;
		this.password=password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
