package de.ait.repositories;

import de.ait.models.DriverProfile;
import de.ait.models.Order;

import java.util.List;
import java.util.Map;

public interface DriverProfileRepository {
    Map<String, String> createPasswordMapFromFile();

    List<Order> TakeFromFile();
}
