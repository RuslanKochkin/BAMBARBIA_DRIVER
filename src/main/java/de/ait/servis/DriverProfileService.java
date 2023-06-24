package de.ait.servis;

public interface DriverProfileService {
    boolean checkPassword(String username, String password);
    void printCompletedOrders();
}
