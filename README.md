#Final-Project

<b><h2>Inventory</h2></b>
<ul>
  Inventory CSV file  
  Inventory Singleton: Controller for CRUD operations on Inventory CSV file
</ul>

<h3>Methods</h3>
<ul>
  Create (add item)
  Read
  Update
  Delete (remove item)
</ul> 
•	Superclass Product
o	Attributes:
	ProductID
	ProductName
	ProductPrice
	ProductStock
o	Methods:
	Getters and setters
	ToString
	isInStock()
o	Subclass:
	Methods:
•	Copy and parameterized constructors
	Audio Book
	Magazine
	DVD
	Book
•	Singleton for Transactions: 
o	Attributes:
	Cart array list
	Total
o	Methods:
	AddItem
•	Update Price
	RemoveItem
•	Update Price
	Checkout
•	Clear Cart
•	SelectBookClub
	PrintCart
•	ProductType Enum:
	Audio Book
	Magazine
	DVD
	Book
•	BookClubManager class:
o	Innerclass: Customer
	Email
	Name
	Store Credit
	Purchased []
o	Methods:
	UseCredit
	BookBought
	NewCustomer
	clearPurchased
	updateCreditthot
