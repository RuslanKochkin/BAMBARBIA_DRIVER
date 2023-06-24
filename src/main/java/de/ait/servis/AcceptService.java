package de.ait.servis;

import de.ait.models.Order;

import java.io.IOException;

public interface AcceptService {

    String makeOrder(Order id, String niceName) throws IOException;
    String makeOrderNewAddress(Order id, String address) throws IOException;

}
