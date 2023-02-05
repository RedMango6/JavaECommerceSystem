
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// Simulation of a Simple E-Commerce System (like Amazon)

public class ECommerceUserInterface {
	public static void main(String[] args) {
		// Create the system
		ECommerceSystem amazon = new ECommerceSystem();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		// Process keyboard actions
		while (scanner.hasNextLine()) {
			String action = scanner.nextLine();

			if (action == null || action.equals("")) {
				System.out.print("\n>");
				continue;
			} else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;

			else if (action.equalsIgnoreCase("PRODS")) // List all products for sale
			{
				amazon.printAllProducts();
			} else if (action.equalsIgnoreCase("BOOKS")) // List all books for sale
			{
				amazon.printAllBooks();
			} else if (action.equalsIgnoreCase("CUSTS")) // List all registered customers
			{
				amazon.printCustomers();
			} else if (action.equalsIgnoreCase("ORDERS")) // List all current product orders
			{
				amazon.printAllOrders();
			} else if (action.equalsIgnoreCase("SHIPPED")) // List all orders that have been shipped
			{
				amazon.printAllShippedOrders();
			} else if (action.equalsIgnoreCase("NEWCUST")) // Create a new registered customer
			{
				String name = "";
				String address = "";

				System.out.print("Name: ");
				if (scanner.hasNextLine())
					name = scanner.nextLine();

				System.out.print("\nAddress: ");
				if (scanner.hasNextLine())
					address = scanner.nextLine();

				boolean success = amazon.createCustomer(name, address);
				if (!success) {
					System.out.println(amazon.getErrorMessage());
				}
			} else if (action.equalsIgnoreCase("SHIP")) // ship an order to a customer
			{
				String orderNumber = "";

				System.out.print("Order Number: ");
				// Get order number from scanner
				orderNumber = scanner.next();
				// Ship order to customer (see ECommerceSystem for the correct method to use
				amazon.shipOrder(orderNumber);
			} else if (action.equalsIgnoreCase("CUSTORDERS")) // List all the current orders and shipped orders for this
																// customer id
			{
				String customerId = "";

				System.out.print("Customer Id: ");
				// Get customer Id from scanner
				customerId = scanner.next();
				// Print all current orders and all shipped orders for this customer
				amazon.printOrderHistory(customerId);
			} else if (action.equalsIgnoreCase("ORDER")) // order a product for a certain customer
			{
				String productId = "";
				String customerId = "";

				System.out.print("Product Id: ");
				// Get product Id from scanner
				productId = scanner.next();
				System.out.print("\nCustomer Id: ");
				// Get customer Id from scanner
				customerId = scanner.next();
				// Order the product. Check for valid orderNumber string return and for error
				String s = amazon.orderProduct(productId, customerId, "");
				// message set in ECommerceSystem

				// Print Order Number string returned from method in ECommerceSystem
				if (s != null) {
					System.out.println("Order #" + s);
				}
			} else if (action.equalsIgnoreCase("ORDERBOOK")) // order a book for a customer, provide a format
																// (Paperback, Hardcover or EBook)
			{
				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: ");
				// get product id
				productId = scanner.next();
				System.out.print("\nCustomer Id: ");
				// get customer id
				customerId = scanner.next();
				System.out.print("\nFormat [Paperback Hardcover EBook]: ");
				// get book forma and store in options string
				options = scanner.next();
				// Order product. Check for error mesage set in ECommerceSystem
				String s = amazon.orderProduct(productId, customerId, options);
				// Print order number string if order number is not null
				if (s != null) {
					System.out.println("Order #" + s);
				}
			} else if (action.equalsIgnoreCase("ORDERSHOES")) // order shoes for a customer, provide size and color
			{
				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: ");
				// get product id
				productId = scanner.next();
				System.out.print("\nCustomer Id: ");
				// get customer id
				customerId = scanner.next();
				System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
				// get shoe size and store in options

				System.out.print("\nColor: \"Black\" \"Brown\": ");
				// get shoe color and append to options

				// order shoes
			}

			else if (action.equalsIgnoreCase("CANCEL")) // Cancel an existing order
			{
				String orderNumber = "";

				System.out.print("Order Number: ");
				// get order number from scanner
				orderNumber = scanner.next();
				// cancel order. Check for error
				amazon.cancelOrder(orderNumber);
			} else if (action.equalsIgnoreCase("SORTBYPRICE")) // sort products by price
			{
				amazon.sortByPrice();
			} else if (action.equalsIgnoreCase("SORTBYNAME")) // sort products by name (alphabetic)
			{
				amazon.sortByName();
			} else if (action.equalsIgnoreCase("SORTCUSTS")) // sort products by name (alphabetic)
			{
				amazon.sortCustomersByName();
			} else if (action.equalsIgnoreCase("BOOKSBYAUTHOR")) {
				String authorName = "";
				System.out.print("Author Name Is: ");
				authorName = scanner.nextLine();
				if (authorName != null && authorName.isEmpty() == false || authorName.isBlank() == false) {
					amazon.sortAuthorYear(authorName);
				}
			}

			System.out.print("\n>");
		}
	}
}
