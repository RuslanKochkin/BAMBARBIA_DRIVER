package de.ait.repositories;

import de.ait.models.DriverProfile;
import de.ait.models.Order;

import java.io.IOException;
import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
}
