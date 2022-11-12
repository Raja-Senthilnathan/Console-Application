package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.OrderDetails;
import model.Products;

public class OrderInfo {

	OrderDetails orderDetails = new OrderDetails();
	Scanner sc = new Scanner(System.in);
	PlaceOrder place;

	public void showOrder(int customer_id, Map<Integer, Integer> orderedList) {

		place = new PlaceOrder();
		List<Products> show = orderDetails.order(orderedList);
		int quantity = 0;
		System.out.println("This is your Order");
		System.err.printf("%-19s%-5s%s\n", "Product", "QTY", "Price");
		for (Products list : show) {
			quantity = orderedList.get(list.getProduct_id());
			System.out.printf("%-19s%-5d%.2f\n", list.getProduct_name(), quantity, quantity * list.getPrice());
		}
		System.out.println("---------------------------------");
		place.options(customer_id, orderedList);

	}

	public void cancellation(int customer_id, Map<Integer, Integer> orderedList) {

		System.out.println("Choose the cancellation Option");
		System.out.println("------------------------------");
		System.out.println("0)Back to Mainmenu \n1)Cancel the Product \n2)Change the Quantity \n3)Cancel the Order");
		int cancelOptions = sc.nextInt();
		List<Products> cancel = orderDetails.order(orderedList);
		int index = 1;
		for (Products list : cancel) {
			System.out.printf("%d)%-19s%-5d\n", index++, list.getProduct_name(), orderedList.get(list.getProduct_id()));
		}
		cancelOptions(customer_id, orderedList, cancelOptions);
	}

	public void cancelOptions(int customer_id, Map<Integer, Integer> orderedList, int cancelOptions) {

		place = new PlaceOrder();
		switch (cancelOptions) {
		case 0:
			place.options(customer_id, orderedList);
			break;
		case 1:
			cancelProduct(customer_id, orderedList);
			break;
		case 2:
			changeQuantity(customer_id, orderedList);
			break;
		case 3:
			cancelOrder(customer_id, orderedList);
			break;
		default:
			System.err.println("Invalid Input");
			cancelOptions(customer_id, orderedList, cancelOptions);
		}

	}

	private void cancelProduct(int customer_id, Map<Integer, Integer> orderedList) {

		place = new PlaceOrder();
		System.out.println("Choose the Product");
		int cancellation = sc.nextInt();
		int product_id = 0;
		for (int id : orderedList.keySet()) {
			if (product_id == cancellation - 1) {
				product_id = id;
				break;
			}
			product_id++;
		}
		orderedList.remove(product_id);
		System.err.println("Successfully cancelled your Product");
		place.options(customer_id, orderedList);
	}

	private void changeQuantity(int customer_id, Map<Integer, Integer> orderedList) {

		place = new PlaceOrder();
		System.out.println("Choose the Product");
		int cancellation = sc.nextInt();
		System.out.println("Enter the Quantity");
		int quantity = sc.nextInt();
		int product_id = 0;
		for (int id : orderedList.keySet()) {
			if (product_id == cancellation - 1) {
				product_id = id;
				break;
			}
			product_id++;
		}
		orderedList.put(product_id, quantity);
		System.err.println("Successfully change the Quantity");
		place.options(customer_id, orderedList);

	}

	private void cancelOrder(int customer_id, Map<Integer, Integer> orderedList) {

		place = new PlaceOrder();
		orderedList.clear();
		System.err.println("Successfully Cancelled your Order");
		place.options(customer_id, orderedList);

	}

}
