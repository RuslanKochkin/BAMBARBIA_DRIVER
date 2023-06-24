package de.ait.models;
import java.time.LocalDateTime;
public class Accept extends Order{
    private LocalDateTime dateTime;
    private String dateTimeNow;

    public Accept(int idOrder, String nameClient, double rating, String address, double orderPrice, double orderInKilometers) {
        super(idOrder, nameClient, rating, address, orderPrice, orderInKilometers);

    }
    public Accept(int idOrder, String nameClient, double rating, String address, double orderPrice, double orderInKilometers, LocalDateTime dateTime) {
        super(idOrder, nameClient, rating, address, orderPrice, orderInKilometers);
        this.dateTime = dateTime;
    }

    public Accept(int idOrder, String nameClient, double rating, String address, double orderPrice, double orderInKilometers,  String dateTimeNow) {
        super(idOrder, nameClient, rating, address, orderPrice, orderInKilometers);
        this.dateTimeNow = dateTimeNow;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public String getDateTimeNow() {
        return dateTimeNow;
    }
    @Override
    public String toString() {
        return getIdOrder() +":" + getNameClient() +"."+ getRating() + "."+ getAddress()+ ". " + getOrderPrice() + "$: "+
                getOrderInKilometers() +". km " + getDateTimeNow();
    }
}
