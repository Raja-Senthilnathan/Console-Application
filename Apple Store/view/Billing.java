package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.OrderDetails;
import model.Products;

public class Billing {
	
	OrderDetails orderDetails = new OrderDetails();
	Scanner sc = new Scanner(System.in);
	static int bill_No=101;

	public void bill(int customer_id, Map<Integer, Integer> orderedList) {
		
		List<Products> show = orderDetails.order(orderedList);
		int quantity = 0; 
		double total = 0;
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.now();
		System.out.println("--------------------------------------------");
		System.out.printf("%29s\n", "APPLE STORE");
		System.out.printf("%s%d%31s\n", "Bill.No:", bill_No++, dateformatter.format(date));
		System.out.println("--------------------------------------------");
		System.out.printf("%-5s%-19s%-11s%-13s\n", "QTY", "Product", "Price", "Total");
		System.out.println("--------------------------------------------");
		for (Products list : show) {
			quantity = orderedList.get(list.getProduct_id());
			total+=(quantity*list.getPrice());
			System.out.printf("%-5d%-19s%-11.2f%-13.2f\n", quantity, list.getProduct_name() ,list.getPrice(), quantity * list.getPrice());
		}
		double discount = total*0.10;
		total = total - discount;
		System.out.println("--------------------------------------------");
		System.out.printf("%33s%11.2f", "Discount 10%", discount);
		System.out.println();
		System.out.printf("%33s%11.2f", "Grand Total", total);
		System.out.println();
		System.out.println("--------------------------------------------");
		payment();
		
	}
	
	private void payment() {
		
		System.out.println("Choose the Payment Method");
		System.out.println("1)Cash On Delivery \n2)e-Payment");
		int payment = sc.nextInt();
		System.out.println("Your order is Successfully Placed");
		System.out.println("Your order is Delivered within 7 Days");
		
	}

}
