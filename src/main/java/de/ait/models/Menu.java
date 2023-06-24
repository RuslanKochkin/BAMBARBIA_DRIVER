package de.ait.models;

public abstract class Menu {
    private final static String MAIN_MENU_TEXT = """
            1: Показать Все Заказы:
            2: Показать ближайщий заказ:
            3: Показать Заказ с наибольшей стоимостью:
            4: Показать заказы не дешевле чем ...:
            5: Сортировать по цене от ... и до ...:
            6: Взять заказ:
            7: Изменить конечный адресс поездки:
            8: Посмотреть отчет о проделанных заказах:
            9: Завершить работу:""";
    public static void showMainMenu() {
        System.out.println(MAIN_MENU_TEXT);
    }
}
