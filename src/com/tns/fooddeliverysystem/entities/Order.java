package com.tns.fooddeliverysystem.entities;

import java.util.HashMap;
import java.util.Map;

public class Order {
	private int orderId;
	private Customer customer;
	private Map<FoodItem, Integer> items;
	private String status;
	private DeliveryPerson deliveryPerson;
	
	public Order(int orderId, Customer customer) {
		this.orderId = orderId;
		this.customer = customer;
		this.items = new HashMap<>();
		this.status = "Pending";
		};
	
	public void addItem(FoodItem foodItem, int quantity) {
		items.put(foodItem, quantity);
	}
	
//	setters
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setDeliveryPerson(DeliveryPerson person) {
		this.deliveryPerson = person;
	}
	
	// public void setDeliverAddress(String address) {
	// 	this.deliveryAddress = address;
	// }
	
//	getters
	
	public int getOrderId() {
		return this.orderId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public String getStatus() {
		return status;
	}
	
	public Map<FoodItem, Integer> getItems() {
		return items;
	}
	
	public DeliveryPerson getDeliveryPerson() {
		return deliveryPerson;
	}
	
	// public String getDeliveryAddress() {
	// 	return deliveryAddress;
	// }
	
	@Override
	public String toString() {
		StringBuilder itemDetails = new StringBuilder();
    	double total = 0;

    	for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
        	FoodItem item = entry.getKey();
        	int quantity = entry.getValue();
        	double subtotal = item.getPrice() * quantity;
        	total += subtotal;

        		itemDetails.append(item.getName())
                   .append(" (₹").append(item.getPrice()).append(" × ")
                   .append(quantity).append(" = ₹").append(subtotal)
                   .append("), ");
    }

    // remove the trailing comma and space
    	if (itemDetails.length() > 0)
        itemDetails.setLength(itemDetails.length() - 2);

    	return "Order [ID: " + orderId +
           		", Customer: " + customer.getUsername() +
				", Items: [" + itemDetails +
				"], Total: ₹" + total +
				", Delivery Person: " + 
				(deliveryPerson != null ? deliveryPerson.getName() : "Not Assigned") +
				", Status: " + status + "]";
	}
	
}
