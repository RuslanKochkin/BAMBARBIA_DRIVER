package de.ait.servis;

import de.ait.models.Order;
import de.ait.repositories.OrderRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void getOrder() {
        List<Order> orders = orderRepository.findAll();
        List<Order> orderList = new ArrayList<>(orders);
        printAllOrder(orderList);
    }

    @Override
    public List<Order> getOrderList() {
        List<Order> orders = orderRepository.findAll();
        return new ArrayList<>(orders);
    }

    @Override
    public Order CheckId(int order) {//  метод поиска обьекта по Id
        List<Order> orders = orderRepository.findAll();
        for (Order value : orders) {
            if (value.getId() == order) {
                int idOrder = value.getId();
                String nameClient = value.getNameClient();
                double rating = value.getRating();
                String address = value.getAddress();
                double orderPrice = value.getOrderPrice();
                double orderInKilometers = value.getOrderInKilometers();
                return new Order(idOrder, nameClient, rating, address, orderPrice, orderInKilometers);
            }
        }
        return null;
    }

    @Override
    public void PriceRange(int price1, int price2) {
        List<Order> orders = orderRepository.findAll();
        List<Order> orderList = orders.stream().filter((a) -> a.getOrderPrice() > price1 && a.getOrderPrice() < price2)
                .collect(Collectors.toCollection(ArrayList::new));
        printAllOrder(orderList);
    }

    @Override
    public void NextOrder() {
        List<Order> orders = orderRepository.findAll();
        List<Order> orderList = Collections.singletonList(orders.stream()
                .min((a1, a2) -> (int) (a1.getOrderInKilometers() - a2.getOrderInKilometers()))
                .get());
        printAllOrder(orderList);
    }

    @Override
    public void MostExpensiveOrder() {
        List<Order> orders = orderRepository.findAll();
        List<Order> orderList = Collections.singletonList(orders.stream()
                .max((a1, a2) -> (int) (a1.getOrderPrice() - a2.getOrderPrice()))
                .get());
        printAllOrder(orderList);
    }

    @Override
    public void MinimumPrice(int price) {
        List<Order> orders = orderRepository.findAll();
        List<Order> orderMinimumPrice =
                orders
                        .stream()
                        .filter((a) -> a.getOrderPrice() > price)
                        .collect(Collectors.toList());
        printAllOrder(orderMinimumPrice);
    }
        public  void printAllOrder(List<Order> orders) {
            for (Order order : orders) {
                System.out.println(order);
            }
            System.out.println();
        }
    }







