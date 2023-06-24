package de.ait.app;

import de.ait.models.Menu;
import de.ait.models.Order;
import de.ait.repositories.*;
import de.ait.servis.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        OrderRepository orderRepository = new OrderRepositoryTextFileImpl("OrderFile.txt");
        OrderService orderService = new OrderServiceImpl(orderRepository);
        DriverProfileRepository driverProfileRepository = new DriverProfileRepositoryFileImpl("CardFileOfDrivers.txt");
        DriverProfileService driverProfileService = new DriverProfileServiceImpl(driverProfileRepository);
        AcceptRepository acceptRepository = new AcceptRepositoryImpl("OrderFile.txt");
        AcceptService acceptService = new AcceptServiceImpl( orderRepository,  driverProfileRepository,  acceptRepository);
        DriverProfileRepository driverProfileRepository1 = new DriverProfileRepositoryFileImpl("Accept.txt");
        DriverProfileService driverProfileService1 = new DriverProfileServiceImpl(driverProfileRepository1);
        String nickname;
        while (true) {
            System.out.print("Введите Позывной: ");
            nickname = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();
            boolean passwordMatched = driverProfileService.checkPassword(nickname, password);
            if (!passwordMatched) {
                System.out.println("Пароль верный - Доступ разрешен.");
                System.out.println("\"BAMBARBIA DRIVER\" Приятной работы");
                break;
            } else {
                System.out.println("Пароль или имя неверные - Попробуйте еще раз.");
            }
        }
        while (true) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ignore) {
            }
            Menu.showMainMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> orderService.getOrder();
                case 2 -> orderService.NextOrder();
                case 3 -> orderService.MostExpensiveOrder();
                case 4-> {
                    System.out.println("Минимальный диапозон:");
                    scanner.nextLine();
                    int range = scanner.nextInt();
                    orderService.MinimumPrice(range);
                }
                case 5 -> {
                    System.out.println("Минимальный диапозон:");
                    scanner.nextLine();
                    int range = scanner.nextInt();
                    System.out.println("Максимальный диапозон:");
                    int range2 = scanner.nextInt();
                    orderService.PriceRange(range,range2);
                }

                case 6 -> {
                    while (true) {
                        System.out.println("Введите номер заказа:");
                        int receipt = scanner.nextInt();
                        if (!(receipt > orderService.getOrderList().size())){
                            Order idOrder = orderService.CheckId(receipt);
                            String print = acceptService.makeOrder(idOrder, nickname);
                            System.out.println("Адресс заказа: "+idOrder.getAddress());
                            System.out.println("Вами выполняется: "+print);
                            break;
                        }else {
                            System.out.println("Неверный номер заказа - попробуйте еще раз ");
                        }
                    }
                }
                case 7 -> {
                    System.out.println("Введите конечный адресс заказа:");
                    scanner.nextLine();
                    String address = scanner.nextLine();
                    System.out.println("Введите номер заказа:");
                    int receipt = scanner.nextInt();
                    Order idOrder = orderService.CheckId(receipt);
                    String print2 = acceptService.makeOrderNewAddress(idOrder, address);
                    System.out.println("Адресс успешно изменен:"+print2);
                }
                case 8-> driverProfileService1.printCompletedOrders();
                case 9-> {
                    System.out.println("Выход");
                    System.exit(0);
                }

                default -> System.out.println("Такой команды нет");
            }
        }
    }
}
