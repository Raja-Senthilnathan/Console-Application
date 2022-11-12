package model;

public class UserDetails {
	
	private static int userId = 100;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String mailId;
	private String password;
	
	public UserDetails(String firstName, String lastName, long phoneNumber, String mailId, String password) {
		
		userId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.mailId = mailId;
		this.password = password;
		
	}

	public static int getUserId() {
		return userId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
