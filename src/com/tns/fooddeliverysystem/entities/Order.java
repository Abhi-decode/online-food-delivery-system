package com.tns.fooddeliverysystem.entities;

import java.util.Map;

public class Order {
	private int orderId;
	private Customer customer;
	private Map<FoodItem, Integer> items;
	private String status;
	private DeliveryPerson deliveryPerson;
	private String deliveryAddress;
	
	public Order(int orderId, Customer customer) {
		this.orderId = orderId;
		this.customer = customer;
	}
	
	public void addItem(int quantity, FoodItem item) {
		items.put(item, quantity);
	}
	
//	setters
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setDeliveryPerson(DeliveryPerson person) {
		this.deliveryPerson = person;
	}
	
	public void setDeliverAddress(String address) {
		this.deliveryAddress = address;
	}
	
//	getters
	
	public int getOrderId() {
		return this.orderId;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public Map<FoodItem, Integer> getItems() {
		return this.items;
	}
	
	public DeliveryPerson getDeliveryPerson() {
		return this.deliveryPerson;
	}
	
	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}
	
	@Override
	public String toString() {
		return "Order : [ orderId :" + orderId + " customer : "+ customer.getUsername() + "items : " + items +
				" deliveryPerson : " + deliveryPerson + " deliveryAddress : "+ deliveryAddress + " status : "+status+" ]";  
	}
	
}
