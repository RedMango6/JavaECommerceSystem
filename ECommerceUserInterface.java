//Name: Taha Iqbal
//Student ID: 501112475

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;


// Simulation of a Simple E-Commerce System (like Amazon)

public class ECommerceUserInterface
{
	public static void main(String[] args)
	{
		// Create the system
		ECommerceSystem amazon = new ECommerceSystem();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		
		// Process keyboard actions
		while (scanner.hasNextLine()) //hasNextLine() returns true if there is a next line of input in the scanner.
			// The various print statements in this class and other classes guarantee that there is always a new line when the user does not enter "QUIT"
		{

			String action = scanner.nextLine();
			
			if (action == null || action.equals("")) 
			{
				System.out.print("\n>");
				continue;
			}
			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))

				return; //We return nothing here so that the hasNextLine() method in the while-loop condition becomes false.

			else if (action.equalsIgnoreCase("PRODS"))	// List all products for sale //DONE
			{
				amazon.printAllProducts(); 
			}
			else if (action.equalsIgnoreCase("BOOKS"))	// List all books for sale //DONE
			{
				amazon.printAllBooks(); 
			}
			else if (action.equalsIgnoreCase("CUSTS")) 	// List all registered customers //DONE
			{
				amazon.printCustomers();	
			}
			else if (action.equalsIgnoreCase("ORDERS")) // List all current product orders
			{
				amazon.printAllOrders();	
			}
			else if (action.equalsIgnoreCase("SHIPPED"))	// List all orders that have been shipped
			{
				amazon.printAllShippedOrders();	
			}
			else if (action.equalsIgnoreCase("NEWCUST"))	// Create a new registered customer
			{

				String name = "";
				String address = "";
				
				System.out.print("Name: "); //prompting the user for the name

				//The following two lines will take input from the user and assighn it to the name variable that is declared above
				if (scanner.hasNextLine())
					name = scanner.nextLine();
				
				System.out.print("\nAddress: "); //prompting the user for the adress

				//The following two lines will take input from the user and assighn it to the name variable that is declared above
				if (scanner.hasNextLine())
					address = scanner.nextLine();

				//The createCustomer() method will return false if the name or address are invalid.
				// It returns true if the customer is created successfully
				boolean success = amazon.createCustomer(name, address);

				// if (either name or address are invalid)
				if (!success)
				{
					System.out.println(amazon.getErrorMessage()); //outputting error message that was set by the createCustomer() method.
				}



			}
			else if (action.equalsIgnoreCase("SHIP"))	// ship an order to a customer
			{



				String orderNumber = "";
        
				System.out.print("Order Number: "); //Prompting use for input


				// Get order number from scanner
				//The following two lines will take input from the user and assighn it to the orderNumber variable that is declared above
				if (scanner.hasNextLine()){
					orderNumber = scanner.nextLine();
				}

				// Ship order to customer (see ECommerceSystem for the correct method to use

				//If an order with the orderNumber value exists in the orders arraylist (which is the arraylist for unshipped orders),
				// then amazon.shipOrder(orderNumber) will return a reference to testOrderNumber. Otherwise, the method will return null.

				ProductOrder testOrderNumber= amazon.shipOrder(orderNumber);

				// if (order with orderNumber does not exist in orders arrayList)
				if (testOrderNumber==null){
					System.out.println(amazon.getErrorMessage());
				} else{
					testOrderNumber.print();
				}



			}
			else if (action.equalsIgnoreCase("CUSTORDERS")) // List all the current orders and shipped orders for this customer id
			{


				String customerId = "";

				System.out.print("Customer Id: ");//Prompting user for input

				// Get customer Id from scanner
				//The following two lines will take input from the user and assighn it to the customerId variable that is declared above
				if (scanner.hasNextLine()){
					customerId = scanner.nextLine();
				}

				// Print all current orders and all shipped orders for this customer
				//amazon.printOrderHistory(customerId) will return false if customer does not exist. It will return true if the customer exists and
				//the customerCreation process is completed.
				boolean historyBool=amazon.printOrderHistory(customerId);

				//if (customer does not exist)
				if (historyBool==false){
					amazon.getErrorMessage(); //output error message that is set in printOrderHistory()
				}



			}
			else if (action.equalsIgnoreCase("ORDER"))
				// order a product for a certain customer
			{


				String productId = "";
				String customerId = "";

				System.out.print("Product Id: "); //prompting user for input

			  // Get product Id from scanner
				//The following two lines will take input from the user and assighn it to the productId variable that is declared above
				if (scanner.hasNextLine()){
					productId = scanner.nextLine();
				}


				System.out.print("\nCustomer Id: "); //prompting user for input

			  // Get customer Id from scanner
				//The following two lines will take input from the user and assighn it to the customerId variable that is declared above
				if (scanner.hasNextLine()){
					customerId = scanner.nextLine();
				}


				// Order the product. Check for valid orderNumber string return and for error message set in ECommerceSystem

				//amazon.orderProduct(productId, customerId,"") will return null if the customer does not exist, product does not exist,
				//or productOptions is invalid. It will return a reference to the orderNumber if the customerCreation process is completed.

				String testOrderNumber= amazon.orderProduct(productId, customerId, "");

				//if (one of the parameters was not valid)
				if (testOrderNumber==null){

					System.out.println(amazon.getErrorMessage()); //incase testOrderNumber equals null, we print the errMsg using getErrorMessage()
				} else{
					System.out.println("Order #"+testOrderNumber); // outputting Order Number string returned from method in ECommerceSystem
				}



				
			}
			else if (action.equalsIgnoreCase("ORDERBOOK"))
				// order a book for a customer, provide a format (Paperback, Hardcover or EBook)
			{


				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: "); //Prompting user for productId

				// get product id
				//The following two lines will take input from the user and assighn it to the productId variable that is declared above
				if (scanner.hasNextLine()){
					productId = scanner.nextLine();
				}



				System.out.print("\nCustomer Id: "); //Prompting user for customerId

				// get customer id
				//The following two lines will take input from the user and assighn it to the customerId variable that is declared above
				if (scanner.hasNextLine()){
					customerId = scanner.nextLine();
				}



				System.out.print("\nFormat [Paperback Hardcover EBook]: "); //Prompting user for productOption

				// get book format and store in options string
				if (scanner.hasNextLine()){
					options= scanner.nextLine();
				}
				
				// Order product. Check for error message set in ECommerceSystem

				//amazon.orderProduct(productId, customerId,"") will return null if the customer does not exist, product does not exist,
				//or productOptions is invalid. It will return a reference to the orderNumber if the customerCreation process is completed.
				String testOrderNumber= amazon.orderProduct(productId, customerId, options);

				//if (one of the parameters was not valid)
				if (testOrderNumber==null){

					System.out.println(amazon.getErrorMessage());

				} else{

					System.out.println("Order #"+testOrderNumber);
				}



			}
			else if (action.equalsIgnoreCase("ORDERSHOES")) // order shoes for a customer, provide size and color 
			{


				String productId = "";
				String customerId = "";
				String options = "";
				String sizeOption= "";
				String colourOption= "";
				
				System.out.print("Product Id: ");
				// get product id
				if (scanner.hasNextLine()){
					productId = scanner.nextLine();
				}
				System.out.print("\nCustomer Id: ");
				// get customer id
				if (scanner.hasNextLine()){
					customerId = scanner.nextLine();
				}
				
				System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
				// get shoe size and store in options
				if (scanner.hasNextLine()){
					sizeOption = scanner.nextLine();
				}
				
				System.out.print("\nColor: \"Black\" \"Brown\": ");
				// get shoe color and append to options
				if (scanner.hasNextLine()){
					colourOption = scanner.nextLine();
				}
				
				//order shoes

				options= colourOption.trim().toUpperCase()+ " "+ sizeOption.trim();

				String testOrderNumber= amazon.orderProduct(productId, customerId, options);
				//if (one of the parameters was not valid)
				if (testOrderNumber==null){
					System.out.println(amazon.getErrorMessage());
				} else{
					System.out.println("Order #"+testOrderNumber);
				}



			}
			
			
			else if (action.equalsIgnoreCase("CANCEL")) // Cancel an existing order
			{


				String orderNumber = "";

				System.out.print("Order Number: ");
				// get order number from scanner
				if (scanner.hasNextLine()){
					orderNumber= scanner.nextLine();
				}
				// cancel order. Check for error
				boolean cancelBool= amazon.cancelOrder(orderNumber);
				if (!(cancelBool)){
					System.out.println(amazon.getErrorMessage());
				}



			}
			else if (action.equalsIgnoreCase("SORTBYPRICE")) // sort products by price
			{
				amazon.sortByPrice();
			}
			else if (action.equalsIgnoreCase("SORTBYNAME")) // sort products by name (alphabetic)
			{
				amazon.sortByName();
			}
			else if (action.equalsIgnoreCase("SORTCUSTS")) // sort products by name (alphabetic)
			{
				amazon.sortCustomersByName();
			}
			else if (action.equalsIgnoreCase("BOOKSBYAUTHOR")){ //BOOKS BY AUTHOR NOT COMPLETE

				String author="";
				if (scanner.hasNextLine()){
					author = scanner.nextLine();
				}

				boolean authorExistence= amazon.printBooksByAuthor(author);
			}
			System.out.print("\n>");
		}
	}
}
