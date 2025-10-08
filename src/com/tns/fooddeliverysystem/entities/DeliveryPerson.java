package com.tns.fooddeliverysystem.entities;

public class DeliveryPerson {
	private int deliveryPersonId;
	private String name;
	private long contactNo;
	
	public DeliveryPerson(int deliveryPersonId, String name, long contactNo) {
		this.deliveryPersonId = deliveryPersonId;
		this.name = name;
		this.contactNo = contactNo;
	}
	
	public int getDeliveryPersonId() {
		return this.deliveryPersonId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getContactNo() {
		return this.contactNo;
	}
	
	@Override
	public String toString() {
		return "Delivery Person [id : " + deliveryPersonId + " name : " + name + "contact No : " + contactNo + "]";
	}
	
}
