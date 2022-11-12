package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.UserDetails;
import model.DataBase;
import model.FlightDetails;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to Kingfisher Airlines");
		System.out.println("------------------------------");
		HomePage homePage = new HomePage();
		homePage.signIn();

	}
	
	static {
		
		List<String> flight1Routes = new ArrayList<>(Arrays.asList("Chennai","Bengalure","Hydrabad","Kolkata"));
		List<String> flight2Routes = new ArrayList<>(Arrays.asList("Chennai","Bengalure","Hydrabad","Kolkata","Delhi"));
		List<String> flight3Routes = new ArrayList<>(Arrays.asList("Chennai","Bengalure","Hydrabad","Mumbai","Ahamadabath"));
		DataBase.flight.put(2345, new FlightDetails(2345, "Kolkata Airlines", "1.00", "11.00", flight1Routes, 10, 430.00));
		DataBase.flight.put(2346, new FlightDetails(2346, "Delhi Airlines", "23.00", "5.00", flight2Routes, 10, 530.00));
		DataBase.flight.put(2347, new FlightDetails(2347, "Ahamadabath Airlines", "10.00", "22.00", flight3Routes, 10, 330.00));
		DataBase.userInfo.put(101, new UserDetails("Raja", "S", 9626250616l, "raja007gvs@gmail.com", "0225"));
		
	}

}
