package model;

public class PassengerDetails {
	
	private static int pnrNo = 345543;
	private int flightNumber;
	private int userId;
	private String name;
	private byte age;
	private String gender;
	
	public PassengerDetails() {
	
		pnrNo++;
		
	}
	
	public PassengerDetails(int flightNumber, int userId, String name, byte age, String gender) {
		
		this.flightNumber = flightNumber;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.userId = userId;
		
	}

	public static int getPnrNo() {
		return pnrNo;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getUserId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

}
