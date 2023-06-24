package de.ait.repositories;

import de.ait.models.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryTextFileImpl implements OrderRepository {
    private String fileName;

    public OrderRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Order> findAll() {
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

                Order user = new Order( idOrder,nameClient, rating, address, orderPrice, orderInKilometers);
                users.add(user);

                line = bufferedReader.readLine();//Считываем следующюю строку
            }
        } catch (IOException e) {
            System.out.println("Ошибка при разборе строки заказа:" + e.getMessage());
        }
        return users;
    }
}

