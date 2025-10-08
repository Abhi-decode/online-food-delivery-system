package com.tns.fooddeliverysystem.services;

import java.util.List;
import java.util.ArrayList;

import com.tns.fooddeliverysystem.entities.*;

public class CustomerService {
	private List<Customer> customerList = new ArrayList<>();
	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public List<Customer> getAllCustomers(){
		return customerList;
	}
	
	public Customer getCustomer(int customerId) {
		return customerList.stream().filter(customer -> customer.getUserId() == customerId)
				.findFirst().orElse(null);
	}

}
