package de.ait.servis;

import de.ait.models.Accept;
import de.ait.models.Order;
import de.ait.repositories.DriverProfileRepository;
import de.ait.repositories.OrderRepository;
import de.ait.repositories.AcceptRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class AcceptServiceImpl implements AcceptService {
    private OrderRepository orderRepository;
    private DriverProfileRepository driverProfileRepository;
    private AcceptRepository acceptRepository;

    public AcceptServiceImpl(OrderRepository orderRepository, DriverProfileRepository driverProfileRepository, AcceptRepository acceptRepository) {
        this.orderRepository = orderRepository;
        this.driverProfileRepository = driverProfileRepository;
        this.acceptRepository = acceptRepository;
    }
    public String makeOrder(Order id, String niceName) throws IOException {
        Accept accept = new Accept(id.getIdOrder(), id.getNameClient(),id.getRating(),
                niceName,id.getOrderPrice(),id.getOrderInKilometers());
        Accept acceptSaveTime = new Accept(id.getIdOrder(), id.getNameClient(),id.getRating(),
                niceName,id.getOrderPrice(),id.getOrderInKilometers(), LocalDateTime.now());
        acceptRepository.saveNewDriverAccept(acceptSaveTime);
        acceptRepository.updateAccept(accept);
        return "(Заказ:Id"+accept.getIdOrder()+". Имя клиента:"+accept.getNameClient()+
                ". Рейтинг:"+accept.getRating()+". Позывной водителя:"+niceName+". "+accept.getOrderPrice()+" евро. "
                + accept.getOrderInKilometers()+" км.)";
    }

    @Override
    public String makeOrderNewAddress(Order id, String address) throws IOException {
            Accept accept = new Accept(id.getIdOrder(), id.getNameClient(),id.getRating(),
                address,id.getOrderPrice(),id.getOrderInKilometers());
            Accept acceptSaveTime = new Accept(id.getIdOrder(), id.getNameClient(),id.getRating(),
                address,id.getOrderPrice(),id.getOrderInKilometers(), LocalDateTime.now());
            acceptRepository.saveNewDriverAccept(acceptSaveTime);
            acceptRepository.updateAccept(accept);
            return "(Заказ:№ "+accept.getIdOrder()+". Имя клиента:"+accept.getNameClient()+
                    ". Рейтинг:"+accept.getRating()+". Новый адресс: "+address+". "+accept.getOrderPrice()+" евро. "
                    + accept.getOrderInKilometers()+" км.)";
    }

}
