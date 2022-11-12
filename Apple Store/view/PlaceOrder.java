package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.OrderDetails;
import controller.ProductDetails;
import model.Products;

public class PlaceOrder {

	Scanner sc = new Scanner(System.in);
	ProductDetails product = new ProductDetails();
	OrderDetails orderDetail = new OrderDetails();
	OrderInfo orderInfo = new OrderInfo();
	Billing billing = new Billing();
	Map<Integer, Integer> orderedList = new HashMap<>();

	public void productCategory(int customer_id) {

		Map<Integer, String> map = new HashMap<>();
		map = product.productCategory();
		System.err.println("->Product Category");
		System.out.println("Choose the Category");
		for (int key : map.keySet()) {
			System.out.printf("%d)%s\n", key, map.get(key));
		}
		int category = sc.nextInt();
		products(customer_id, category);
	}

	public void products(int customer_id, int category) {

		List<Products> productsList = new ArrayList<>();
		productsList = product.productInfo(category);

		System.err.println("->Products");
		System.out.println("Place your order");
		int options = 0;
		System.out.printf("%d)%s\n", options++, "Back to Mainmenu");
		for (Products list : productsList) {
			System.out.printf("%d)%-19s%.2f\n", options++, list.getProduct_name(), list.getPrice());
		}
		int customerChoice = sc.nextInt();
		placeOrder(productsList, customer_id, customerChoice, category);
	}

	public void placeOrder(List<Products> productsList, int customer_id, int customerChoice, int category) {

		int product_id = 0;
		int quantity = 0;
		if (customerChoice == 0) {
			productCategory(customer_id);
		} else if (customerChoice <= productsList.size()) {
			for (int index = 0; index < productsList.size(); index++) {
				if (index == customerChoice - 1) {
					product_id = productsList.get(index).getProduct_id();
					System.out.println("Enter the Quantity");
					quantity = sc.nextInt();
					if (orderedList.containsKey(product_id))
						orderedList.put(product_id, quantity + orderedList.get(product_id));
					else
						orderedList.put(product_id, quantity);
					System.err.println("Your order is placed Successfully");
					options(customer_id, orderedList);
					break;
				}
			}
		} else {
			System.err.println("Invalid Input");
			products(customer_id, category);
		}
	}

	public void options(int customer_id, Map<Integer, Integer> orderedList) {

		System.out.println("0)Exit \n1)Place another order \n2)Show my Orders \n3)Cancel my Order \n4)Bill");
		int userChoice = sc.nextInt();

		switch (userChoice) {
		case 0:
			System.out.println("Thank You!!!");
			break;
		case 1:
			productCategory(customer_id);
			break;
		case 2:
			orderInfo.showOrder(customer_id, orderedList);
			break;
		case 3:
			orderInfo.cancellation(customer_id, orderedList);
			break;
		case 4:
			billing.bill(customer_id, orderedList);
			break;
		default:
			System.err.println("Invalid Input");
			options(customer_id, orderedList);
			break;

		}
	}
}
