package de.ait.repositories;
import de.ait.models.Accept;
import java.io.IOException;


public interface AcceptRepository {
    void saveNewDriverAccept(Accept accept) throws IOException;
    public void updateAccept(Accept accept);
}
