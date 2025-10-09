# 🍴 Online Food Delivery System (TNS)

## 📘 Project Overview
The **Online Food Delivery System** is a **Core Java console-based application** developed as a **case study** to demonstrate **Object-Oriented Programming (OOP)** concepts such as **encapsulation, inheritance, polymorphism, and collections**.  
This project simulates a real-world food delivery platform where:
- Customers can browse restaurants, add food items to their cart, and place orders.  
- Delivery persons deliver the orders.  
- Admins (represented by services) can manage restaurants and food items.  

This project is designed and implemented using **Core Java**, without database integration (all data is handled through in-memory collections).

---

## 🧩 Objectives
- Apply **OOP principles** to model a real-world system.
- Demonstrate **relationships** like:
  - One-to-One (Customer ↔ Cart)
  - One-to-Many (Customer ↔ Orders)
  - Many-to-Many (Order ↔ FoodItem)
- Implement a structured **multi-package architecture**.
- Simulate end-to-end food ordering flow using **service classes** and a **main driver class**.

---

## 🏗️ Project Structure
OnlineFoodDeliverySystem/
│
├── src/
|       └── com/
│       |   └──tns/
|       |       |- fooddeliverysystem
|       |       |    └──entities/        # All entity classes (data models)
│       |       |    |  ├── Cart.java
│       |       |    |  ├── Customer.java
│       |       |    |  ├── DeliveryPerson.java
│       |       |    |  ├── FoodItem.java
│       |       |    |  ├── Order.java
│       |       |    |  ├── Restaurant.java
│       |       |    |  └── User.java
│       |       │    |
|       |       |    └── services/ # Service layer for logic handling                 
│       |       │           ├── CustomerService.java
│       |       │           ├── FoodService.java
│       |       │           └── OrderService.java
│       |       │
│       |       └── foodservicesystem/
|       |                    └── application/    
|       |                            └── FoodDeliverySystem.java        # Application entry point
│       └── module-info.java
|
└── .gitignore
└── README.md

---

## ⚙️ Technologies Used
- **Language:** Java (Core)
- **IDE:** Eclipse IDE for Java Developers
- **Java Collections:** List, Map, ArrayList, HashMap
- **Concepts:** Encapsulation, Inheritance, Polymorphism, Aggregation, Association

---

## 🧠 Key OOP Concepts Demonstrated

| Concept | Example in Project |
|----------|--------------------|
| **Encapsulation** | Private fields with getters/setters in all entities |
| **Inheritance** | `Customer` extends `User` |
| **Polymorphism** | Overridden `toString()` methods in all entities |
| **Association** | `Restaurant` ↔ `FoodItem`, `Order` ↔ `Customer` |
| **Aggregation** | `Cart` containing multiple `FoodItem` objects |
| **Composition** | Each `Customer` has exactly one `Cart` |

---

## 🧮 Features

### 👤 Customer
- Create a customer profile.
- Add or remove food items in the cart.
- Place orders with delivery details.

### 🍔 Restaurant
- Manage food items (add/remove).
- Provide menu listings to customers.

### 🚚 Delivery Person
- Assigned to orders for delivery.

### 🧾 Order Management
- Create and track orders.
- View order status.
- Update order delivery status (Admin/Service simulation).

---

## ▶️ Execution Steps (Eclipse)

1. **Open Eclipse** → *File* → *New → Java Project*  
   - Name: `OnlineFoodDeliverySystem`

2. **Create Packages**  
   - `tns.fooddelivery.entities`  
   - `tns.fooddelivery.service`  
   - `tns.fooddelivery.main`

3. **Copy All Classes** into their respective packages.

4. **Run the Application**  
   - Right-click on `Main.java` → *Run As → Java Application*

5. **Expected Output**
   - Restaurants with food items.
   - Customer cart contents.
   - Order details and delivery status.

---

## 🧾 Sample Output

Welcome to Food Delivery System, Choose an option below to get started!

-------------------------------------

1. Admin menu
2. Customer menu
3. Exit 
Choose an option : 1

-------------------------------------

Admin Menu:
1. Add a resturant
2. Add food item to restaurant
3. Remove food item from restaurant
4. View Restaurant and menus
5. Add Delivery Person
6. Assign Delivery Person to Order
7. View Orders
8. Exit
Choose an option : 1

Enter restaurant id: 101
Enter restaurant name: HariOmDhaba
Restaurant added successfully

-------------------------------------

Admin Menu:
1. Add a resturant
2. Add food item to restaurant
3. Remove food item from restaurant
4. View Restaurant and menus
5. Add Delivery Person
6. Assign Delivery Person to Order
7. View Orders
8. Exit
Choose an option : 1

Enter restaurant id: 102
Enter restaurant name: ExpressInn
Restaurant added successfully

-------------------------------------

Admin Menu:
1. Add a resturant
2. Add food item to restaurant
3. Remove food item from restaurant
4. View Restaurant and menus
5. Add Delivery Person
6. Assign Delivery Person to Order
7. View Orders
8. Exit
Choose an option : 2

Enter Restaurant id: 101
Enter Food item id: 1
Enter Food Item name: PanjabiThali
Enter Food Item price: 340
Food item PanjabiThali is added to the restaurant with id 101

-------------------------------------

Admin Menu:
1. Add a resturant
2. Add food item to restaurant
3. Remove food item from restaurant
4. View Restaurant and menus
5. Add Delivery Person
6. Assign Delivery Person to Order
7. View Orders
8. Exit
Choose an option : 2

Enter Restaurant id: 101
Enter Food item id: 2
Enter Food Item name: PavBhaji
Enter Food Item price: 140
Food item PavBhaji is added to the restaurant with id 101

-------------------------------------

Admin Menu:
1. Add a resturant
2. Add food item to restaurant
3. Remove food item from restaurant
4. View Restaurant and menus
5. Add Delivery Person
6. Assign Delivery Person to Order
7. View Orders
8. Exit
Choose an option : 4

Restaurants and Menus
-----------------------------------------------------
Restaurant : 
id : 101 | name : HariOmDhaba
Menu :
Food Item id : 1 | name : PanjabiThali | price: 340.0
Food Item id : 2 | name : PavBhaji | price: 140.0
-----------------------------------------------------
Restaurant : 
id : 102 | name : ExpressInn
No food items yet

-------------------------------------

Admin Menu:
1. Add a resturant
2. Add food item to restaurant
3. Remove food item from restaurant
4. View Restaurant and menus
5. Add Delivery Person
6. Assign Delivery Person to Order
7. View Orders
8. Exit
Choose an option : 8
Exiting Admin Module

-------------------------------------

1. Admin menu
2. Customer menu
3. Exit 
Choose an option : 2

-------------------------------------

Customer Menu:
1. Add customer
2. View Food Items
3. Add Food to Cart
4. View Cart
5. Place Order
6. View Orders
7. Exit
Choose an option : 1

Enter User Id : 1001
Enter Username : Alpana
Enter User Contact No  :  7720092235
User with name : Alpana created successfully

-------------------------------------

Customer Menu:
1. Add customer
2. View Food Items
3. Add Food to Cart
4. View Cart
5. Place Order
6. View Orders
7. Exit
Choose an option : 2

Restaurants and Menus
-----------------------------------------------------
Restaurant : 
id : 101 | name : HariOmDhaba
Menu :
Food Item id : 1 | name : PanjabiThali | price: 340.0
Food Item id : 2 | name : PavBhaji | price: 140.0
-----------------------------------------------------
Restaurant : 
id : 102 | name : ExpressInn
No food items yet

-------------------------------------

Customer Menu:
1. Add customer
2. View Food Items
3. Add Food to Cart
4. View Cart
5. Place Order
6. View Orders
7. Exit
Choose an option : 3

Enter customer id : 1001
Enter Restaurant id : 101
Enter Food Item id : 2
Enter Quantity : 2
Food Item added to cart successfully

-------------------------------------

Customer Menu:
1. Add customer
2. View Food Items
3. Add Food to Cart
4. View Cart
5. Place Order
6. View Orders
7. Exit
Choose an option : 4

Enter Customer id : 1001
Cart : 
Food Item : PavBhaji| Cost : 280.0| Quantity : 2
Total cost Rs: 280.0

-------------------------------------

Customer Menu:
1. Add customer
2. View Food Items
3. Add Food to Cart
4. View Cart
5. Place Order
6. View Orders
7. Exit
Choose an option : 5

Enter Customer Id: 1001
Order placed successfully, your Order id is : 1

-------------------------------------

Customer Menu:
1. Add customer
2. View Food Items
3. Add Food to Cart
4. View Cart
5. Place Order
6. View Orders
7. Exit
Choose an option : 6

Orders:
Order [ID: 1, Customer: Alpana, Items: [PavBhaji (₹140.0 × 2 = ₹280.0)], Total: ₹280.0, Delivery Person: Not Assigned, Status: Pending]

-------------------------------------

Customer Menu:
1. Add customer
2. View Food Items
3. Add Food to Cart
4. View Cart
5. Place Order
6. View Orders
7. Exit
Choose an option : 7
Exiting customer module...

---

## 🧩 Relationships Summary

| Relationship | Entities Involved | Description |
|---------------|------------------|--------------|
| **One-to-One** | Customer ↔ Cart | Each customer has one cart |
| **One-to-Many** | Customer ↔ Order | One customer can place multiple orders |
| **Many-to-Many** | Order ↔ FoodItem | An order can contain multiple food items |
| **Many-to-One** | Order ↔ DeliveryPerson | Each order assigned to one delivery person |
| **One-to-Many** | Restaurant ↔ FoodItem | Each restaurant can have multiple food items |

---

## 👨‍💻 Author
**Name:** Bharath S V  
**Organization:** TNS  
**Domain:** Information Science and Engineering  
**IDE:** Eclipse  
**Language:** Core Java

---

## 📜 License
This project is developed as part of an academic case study and is open for educational use and improvement.

---