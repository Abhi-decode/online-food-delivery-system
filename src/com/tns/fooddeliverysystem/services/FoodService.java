package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.*;

import java.util.ArrayList;
import java.util.List;

public class FoodService {
	private List<Restaurant> restaurants = new ArrayList<>();
	
	public void addRestaurant(Restaurant restaurant) {
		restaurants.add(restaurant);
	}
	
	public List<Restaurant> getRestaurants(){
		return restaurants;
	}
	
	public List<FoodItem> getAllFoodItems(Restaurant restaurant) {
		List<FoodItem> foodItems = new ArrayList<>();
		
		for(Restaurant res : restaurants) {
			foodItems.addAll(res.getMenu());
		}
		return foodItems;
	}

}
