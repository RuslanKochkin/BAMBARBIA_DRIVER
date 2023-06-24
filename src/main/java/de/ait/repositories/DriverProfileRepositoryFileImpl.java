package de.ait.repositories;

import de.ait.models.Accept;
import de.ait.models.Order;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverProfileRepositoryFileImpl implements DriverProfileRepository {
    private String fileName;

    public DriverProfileRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Map<String, String> createPasswordMapFromFile() {
        Map<String, String> passwordMap = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    passwordMap.put(username, password);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
        return passwordMap;
    }
    @Override
    public List<Order> TakeFromFile() {
        //TODO: добавить правильную обработку ошибок и закрытие файлов
        List<Order> users = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] parsed = line.split("\\|");
                int idOrder = Integer.parseInt(parsed[0]);
                String nameClient = parsed[1];
                double rating = Double.parseDouble(parsed[2]);
                String address = parsed[3];
                double orderPrice = Double.parseDouble(parsed[4]);
                double orderInKilometers = Double.parseDouble(parsed[5]);
                String dateTime = parsed[6];
                Accept user =  new Accept (idOrder,nameClient, rating, address, orderPrice, orderInKilometers, dateTime);
                users.add(user);

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
        return users;
    }
}
