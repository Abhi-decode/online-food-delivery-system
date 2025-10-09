package com.tns.foodservicesystem.application;

import java.util.Map;
import java.util.List;
import java.util.Scanner;

import com.tns.fooddeliverysystem.entities.*;
import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;
import com.tns.fooddeliverysystem.entities.Restaurant;

import com.tns.fooddeliverysystem.services.FoodService;
import com.tns.fooddeliverysystem.services.OrderService;
import com.tns.fooddeliverysystem.services.CustomerService;
public class FoodDeliverySystem {
    private static FoodService foodService = new FoodService();
    private static OrderService orderService = new OrderService();
    private static CustomerService customerService = new CustomerService();

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int customerChoice, adminChoice;

        while (true)
        {
            System.out.println("Welcome to Food Delivery System, Choose an option below to get started!");
            System.out.println("\n-------------------------------------");
            System.out.println("\n1. Admin menu");
            System.out.println("2. Customer menu");
            System.out.println("3. Exit ");
            System.out.print("Choose an option : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: 
                    do {
                        System.out.println("\n-------------------------------------");
                        System.out.println("\nAdmin Menu:");
                        System.out.println("1. Add a resturant");
                        System.out.println("2. Add food item to restaurant");
                        System.out.println("3. Remove food item from restaurant");
                        System.out.println("4. View Restaurant and menus");
                        System.out.println("5. Add Delivery Person");
                        System.out.println("6. Assign Delivery Person to Order");
                        System.out.println("7. View Orders");
                        System.out.println("8. Exit");
                        System.out.print("Choose an option : ");
                        adminChoice = sc.nextInt();

                        switch (adminChoice) {
                            case 1:
                                addRestaurant(sc);
                                break;
                            case 2:
                                addFoodItemToRestaurant(sc);
                                break;
                            case 3:
                                removeFoodItemFromRestaurant(sc);
                                break;
                            case 4:
                                viewRestaurantAndMenus();
                                break;
                            case 5:
                                addDeliveryPerson(sc);
                                break;
                            case 6:
                                addDeliveryPersonToOrder(sc);
                                break;
                            case 7:
                                viewOrders();
                                break;
                            
                            case 8:
                                System.out.println("Exiting Admin Module");
                                break;
                        
                            default:
                                System.out.println("Invalid input, Enter a number between 1 - 8");
                        }


                    } while (adminChoice != 8);
                    
                    break;
                case 2:
                    do {
                        System.out.println("\n-------------------------------------");
                        System.out.println("\nCustomer Menu:");
                        System.out.println("1. Add customer");
                        System.out.println("2. View Food Items");
                        System.out.println("3. Add Food to Cart");
                        System.out.println("4. View Cart");
                        System.out.println("5. Place Order");
                        System.out.println("6. View Orders");
                        System.out.println("7. Exit");
                        System.out.print("Choose an option : ");
                        customerChoice = sc.nextInt();

                        switch (customerChoice) {
                            case 1:
                                addCustomer(sc);
                                break;
                            case 2:
                                viewRestaurantAndMenus();
                                break;
                            case 3:
                                addToCart(sc);
                                break;
                            case 4:
                                viewCart(sc);
                                break;
                            case 5:
                                placeOrder(sc);
                                break;
                            case 6:
                                viewOrders();
                                break;
                            case 7:
                                System.out.println("Exiting customer module...");
                                break;
                                
                            default:
                                System.out.println("Invalid choice");
                        }
                        
                    } 
                    while (customerChoice != 7);
                    break;

                case 3:
                    System.out.println("Thanks for using food delivery system!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addRestaurant(Scanner sc){
        System.out.print("Enter restaurant id: ");
        int restaurantId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter restaurant name: ");
        String restaurantName = sc.nextLine();

        Restaurant restaurant = new Restaurant(restaurantId, restaurantName);
        foodService.addRestaurant(restaurant);

        System.out.println("Restaurant added successfully");
    }

    private static void addFoodItemToRestaurant(Scanner sc)
    {
        System.out.print("Enter Restaurant id: ");
        int resId = sc.nextInt();

        System.out.print("Enter Food item id: ");
        int itemId = sc.nextInt();
        sc.nextLine(); //when you hit enter it'll take the newline and next code will not wait for the input, it takes newline as the input.

        System.out.print("Enter Food Item name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Food Item price: ");
        int price = sc.nextInt();

        FoodItem foodItem = new FoodItem(itemId, name, price);

        foodService.addFoodItemToRestaurant(resId, foodItem);
        System.out.println("Food item " + name + " is added to the restaurant with id "+resId);
    }

    private static void removeFoodItemFromRestaurant(Scanner sc){
        System.out.print("Enter Restaurant id: ");
        int resId = sc.nextInt();

        System.out.print("Enter Food Item id: ");
        int itemId = sc.nextInt();

        foodService.removeFoodItemFromRestaurant(itemId, resId);

        System.out.println("The Food Item with id : "+itemId + " removed successfully from restaurant with id : "+resId);
    }

    private static void viewOrders(){
        List<Order> orders = orderService.getOrders();

        if(orders.isEmpty()){
            System.out.println("\nNo Orders yet");
            return;
        }
        System.out.println("Orders:");
        for (Order order : orders){
            System.out.println(order);
        }
    }

    private static void viewRestaurantAndMenus(){
        System.out.println("Restaurants and Menus");
        for(Restaurant restaurant : foodService.getRestaurants()){
            System.out.println("-----------------------------------------------------");
            System.out.println("Restaurant : ");
            System.out.println("id : " + restaurant.getId() + " | name : "+restaurant.getName());

            List<FoodItem> menu = restaurant.getMenu();
            if (menu.isEmpty()){
                System.out.println("No food items yet");
                continue;
            }

            System.out.println("Menu :");
            for (FoodItem foodItem : restaurant.getMenu()){
                System.out.println("Food Item id : " + foodItem.getId() + " | name : " +foodItem.getName() + " | price: " + foodItem.getPrice());
            }
        }
    }

    private static void addDeliveryPerson(Scanner sc){
        System.out.print("Enter Delivery Person id : ");
        int personId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Delivery Person name : ");
        String personName = sc.nextLine();

        System.out.print("Enter Delivery Person Contact No : ");
        long personContactNo = sc.nextLong();

        DeliveryPerson deliveryPerson = new DeliveryPerson(personId, personName, personContactNo);

        orderService.addDeliveryPerson(deliveryPerson);
        System.out.println("Delivery Person "+ personName + " added successfully");
    }

    private static void addDeliveryPersonToOrder(Scanner sc){
        System.out.print("Enter Deliver Person Id: ");
        int personId = sc.nextInt();

        System.out.print("Enter Order Id: ");
        int orderId = sc.nextInt();

        if(orderService.assignDeliveryPersonToOrder(orderId, personId)){
            System.out.println("Delivery person with id : " + personId + " is assigned to the order with id " + orderId + " successfully");
        }
        else{
            System.out.println("Can't assign Deliver Person to Order, Please check the credentials");
        }
        
    }

    private static void addCustomer(Scanner sc){
        System.out.print("Enter User Id : ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Username : ");
        String userName =  sc.nextLine();

        System.out.print("Enter User Contact No  : ");
        long userContactNo =  sc.nextLong();

        Customer customer = new Customer(userId, userName, userContactNo);
        customerService.addCustomer(customer);

        System.out.println("User with name : " + userName + " created successfully");
    }

    private static void addToCart(Scanner sc){
        System.out.print("Enter customer id : ");
        int customerId = sc.nextInt();

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null){
            System.out.println("No customer is found with id : "+ customerId);
            return;
        }
        
        System.out.print("Enter Restaurant id : ");
        int resId = sc.nextInt();

        System.out.print("Enter Food Item id : ");
        int itemId = sc.nextInt();

        FoodItem foodItem = null;

        for(Restaurant restaurant : foodService.getRestaurants()){
            if (restaurant.getId() == resId){
                for(FoodItem item : restaurant.getMenu()){
                    if (item.getId() == itemId){
                        foodItem = item;
                    }
                }
            }
        }

        if (foodItem == null){
            System.out.println("Food Item with id : " + itemId + " is not found");
            return;
        }

        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();
        
        customer.getCart().addItem(foodItem, quantity);
        System.out.println("Food Item added to cart successfully");
    }

    private static void viewCart(Scanner sc){
        System.out.print("Enter Customer id : ");
        int customerId = sc.nextInt();
        
        Customer customer = customerService.getCustomer(customerId);

        if(customer == null){
            System.out.println("Customer with id : " + customerId + " is not found");
            return;
        }
        Map<FoodItem, Integer> items = customer.getCart().getItems();
        
        if (items.isEmpty()){
            System.out.println("Cart is Empty!");
            return;
        }
        
        double totalCost = 0.0;

        System.out.println("Cart : ");

        for(Map.Entry<FoodItem, Integer> entry : items.entrySet()){
            FoodItem foodItem = entry.getKey();
            int quantity = entry.getValue();
            double cost = foodItem.getPrice() * quantity;
            totalCost += cost;
            System.out.println("Food Item : " + foodItem.getName() + "| Cost : " + cost + "| Quantity : " + quantity);
        }
        System.out.println("Total cost Rs: " + totalCost);
    }

    private static void placeOrder(Scanner sc){
        System.out.print("Enter Customer Id: ");
        int customerId = sc.nextInt();
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null){
            System.out.println("Customer with id : "+customerId+ " is not found");
            return;
        }

        Order order = new Order(orderService.getOrders().size() + 1, customer);
        Map<FoodItem, Integer> cartItems = customer.getCart().getItems();

        if(cartItems.isEmpty()){
            System.out.println("No items in the cart");
            return;
        }

        for(Map.Entry<FoodItem, Integer> entry : cartItems.entrySet()){
            order.addItem(entry.getKey(), entry.getValue());
        }

        orderService.placeOrder(order);
        customer.getCart().getItems().clear();
        System.out.println("Order placed successfully, your Order id is : "+ order.getOrderId());

    }
}
