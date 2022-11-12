package model;

public class DBQueries {
	
	private String new_user = "INSERT INTO customer(first_name, last_name, address, city, pincode, phone_number, mail_id, password) VALUES (?,?,?,?,?,?,?,?)";
	private String login_verification = "SELECT customer_id, password FROM customer WHERE customer_id=?";
	private String product_category = "SELECT * FROM product_category";
	private String product_info = "SELECT product_id, product_name, unit_price FROM product WHERE category_id=?";
    private String show_order = "SELECT product_id, product_name, unit_price FROM product WHERE product_id=?";
	
	public void setNew_user(String new_user) {
		this.new_user = new_user;
	}

	public String getNew_user() {
		return new_user;
	}

	public String getLogin_verification() {
		return login_verification;
	}

	public void setLogin_verification(String login_verification) {
		this.login_verification = login_verification;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	public String getShow_order() {
		return show_order;
	}

	public void setShow_order(String show_order) {
		this.show_order = show_order;
	}
	
}
