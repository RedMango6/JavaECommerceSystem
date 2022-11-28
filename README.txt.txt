To run my miniature ecommerce system, you must download all my .java files into one directory on you local machine.

Then, run the ECommerceUserInterface.java file by executing the following two commands subsequently:
	1. javac ECommerceUserInterface.java
	2. java ECommerceUserInterface

My ecommerce system has many functions.

CUSTS: lists all the customers that are registered in the system.
PRODS: list all the products in the system.
BOOKS: list all the projects in the system of the type BOOK.
ORDERS: list all the unshipped orders.
SHIPPED: list all the shipped orders.
NEWCUST: Prompts for Name and Address. Creates a new registered customer for the system
ORDER: Prompts for the Product ID and Customer ID. Creates a new unshipped order. Each order is associated with a specific product and customer.
ORDERBOOK: Prompts for the Product ID, Customer ID and the Format [Paperback Hardcover EBook] of the book that is being ordered. 
The entered Product ID must be that of a book. (Try 706).
SHIP: Prompts for for Order Number. All unshipped orders have an Order Number. Enter the Order Number to ship the order.
CANCEL: Prompts for the Order Number of an unshipped order. The order is deleted.
CUSTORDERS: Prompts for Customer ID. Will show all the shipped and unshipped orders for a certain customer.
SORTBYPRICE: Sorts all products by ascending price and displays them.
SORTBYNAME: Sorts all products by name.


