package com.tns.fooddeliverysystem.services;

import java.util.List;

import com.tns.fooddeliverysystem.entities.*;

import java.util.ArrayList;

public class OrderService {
    private List<Order> ordersList = new ArrayList<>();
    private List<DeliveryPerson> deliveryPersons = new ArrayList<>();

    public void placeOrder(Order order){
        ordersList.add(order);
    }

    public List<Order> getOrders(){
        return ordersList;
    }

    public void addDeliveryPerson(DeliveryPerson person){
        deliveryPersons.add(person);
    }

    public List<DeliveryPerson> getDeliveryPersons(){
        return deliveryPersons;
    }

    public boolean assignDeliveryPersonToOrder(int orderId, int deliveryPersonId){
        for (Order order : ordersList){
            if (orderId == order.getOrderId()){
                for (DeliveryPerson person : deliveryPersons){
                    if (deliveryPersonId == person.getDeliveryPersonId()){
                        order.setDeliveryPerson(person);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
