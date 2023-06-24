package de.ait.servis;

import de.ait.models.Accept;
import de.ait.models.Order;
import de.ait.repositories.DriverProfileRepository;
import de.ait.repositories.OrderRepository;

import java.util.List;
import java.util.Map;

public class DriverProfileServiceImpl implements DriverProfileService {
    private DriverProfileRepository driverProfileRepository;

    public DriverProfileServiceImpl(DriverProfileRepository driverProfileRepository) {
        this.driverProfileRepository = driverProfileRepository;
    }


    @Override
    public boolean checkPassword(String username, String password) {
        Map<String, String> driverFile = driverProfileRepository.createPasswordMapFromFile();
        for (Map.Entry<String, String> entry : driverFile.entrySet()) {
            String username1 = entry.getKey();
            String password1 = entry.getValue();
            if (username1.equals(username) && password1.equals(password)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printCompletedOrders() {
        List<Order> orders = driverProfileRepository.TakeFromFile();
        for (int i = 0; i < orders.size(); i++) {
                System.out.println(orders.get(i).toString());
            }
        System.out.println();
        }
    }


