package de.ait.models;

import de.ait.servis.OrderService;

import java.util.List;

public class Order {
    private int idOrder;
    private String nameClient;
    private double rating;
    private String address;
    private double orderPrice;
    private double orderInKilometers;
    public Order(int idOrder,String nameClient, double rating,String address, double orderPrice, double orderInKilometers) {
        this.idOrder = idOrder;
        this.nameClient = nameClient;
        this.rating = rating;
        this.address = address;
        this.orderPrice = orderPrice;
        this.orderInKilometers = orderInKilometers;
    }
    public int getIdOrder() {
        return idOrder;
    }

    public int getId() {
        return idOrder;
    }

    public String getNameClient() {
        return nameClient;
    }

    public double getRating() {
        return rating;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public double getOrderInKilometers() {
        return orderInKilometers;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return  idOrder +":" + nameClient +"."+ rating + "."+ address+ ". " + orderPrice + "$: "+
                orderInKilometers +". km ";
    }
}
