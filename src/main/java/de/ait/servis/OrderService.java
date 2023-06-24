package de.ait.servis;

import de.ait.models.Order;

import java.util.List;

public interface OrderService {
//    void printAllOrder1(List<Order> orders);
    Order CheckId(int order);
    void PriceRange(int price1, int price2);
    void NextOrder();
    void MostExpensiveOrder();
    void MinimumPrice(int price);
    List<Order> getOrderList();
    void getOrder();

}
