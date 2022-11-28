//Name: Taha Iqbal
//Student ID: 501112475
/*
 *  class Customer defines a registered customer. It keeps track of the customer's name and address. 
 *  A unique id is generated when when a new customer is created. 
 *  
 *  Implement the Comparable interface and compare two customers based on name.
 */
public class Customer implements Comparable<Customer>
{
	private String id;  
	private String name;
	private String shippingAddress;
	
	public Customer(String id)
	{
		this.id = id;
		this.name = "";
		this.shippingAddress = "";
	}
	
	public Customer(String id, String name, String address)
	{
		this.id = id;
		this.name = name;
		this.shippingAddress = address;
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getShippingAddress()
	{
		return shippingAddress;
	}
	
	public void setShippingAddress(String shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}
	
	public void print()
	{
		System.out.printf("\nName: %-20s ID: %3s Address: %-35s", name, id, shippingAddress);
	}
	
	public boolean equals(Object other)
	{
		Customer otherC = (Customer) other;
		return this.id.equals(otherC.getId());  //done
	}

	public int compareTo(Customer customer2){
		//In the following if-(else-if)-else structure, we are comparing the ASCII values of the first characters in the customer-names.
		//The ASCII values of earlier letters in the alphabet is less than the values of later letters.

		//if (ASCII of first value of first name > ASCII of first value of second name){ switch values}
		if ( (int)this.getName().charAt(0)> (int)customer2.getName().charAt(0) ){

			return 1;

			//if (ASCII of first value of first name == ASCII of first value of second name){ don't switch values}
		} else if ((int)this.getName().charAt(0)==(int)customer2.getName().charAt(0) ){

			return 0;

			//if (ASCII of first value of first name < ASCII of first value of second name){ don't switch values}
		} else {

			return -1;

		}

	}


	
}
