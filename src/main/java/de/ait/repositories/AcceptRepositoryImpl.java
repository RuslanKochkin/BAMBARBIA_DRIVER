package de.ait.repositories;

import de.ait.models.Accept;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AcceptRepositoryImpl implements AcceptRepository {
    private String fileName;

    public AcceptRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveNewDriverAccept(Accept accept) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Accept.txt", true));
        bufferedWriter.write(accept.getIdOrder() + "|" + accept.getNameClient() + "|" + accept.getRating() + "|" +
                accept.getAddress() + "|" + accept.getOrderPrice() + "|" + accept.getOrderInKilometers()+"|"+accept.getDateTime());
        bufferedWriter.newLine();
        bufferedWriter.close();

    }
@Override
    public void updateAccept(Accept acceptNew) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Accept> accepts = reader.lines()
                    .map(line -> line.split("\\|"))//сдесь еще все обьекты
                    .map(array -> new Accept( // преобразовали массив в объект
                            Integer.parseInt(array[0]),
                            array[1],
                            Double.parseDouble(array[2]),
                            array[3],
                            Double.parseDouble(array[4]),
                            Double.parseDouble(array[5])
                    )).collect(Collectors.toCollection(ArrayList::new));
            for (int i = 0; i < accepts.size(); i++) {
                if (accepts.get(i).getId() == acceptNew.getId()) {
                    accepts.remove(i);
                }
            }
            accepts.add(acceptNew);
            reader.close();

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                        for (Accept accept: accepts) {
                            writer.write(accept.getIdOrder() + "|" + accept.getNameClient() + "|" + accept.getRating() + "|" + accept.getAddress() + "|" + accept.getOrderPrice() + "|" + accept.getOrderInKilometers());
                            writer.newLine();
                        }
                    }
                } catch (IOException e) {
                        throw new IllegalStateException("Ошибка при работе с файлом - " + e.getMessage());
            }
        }
    }



