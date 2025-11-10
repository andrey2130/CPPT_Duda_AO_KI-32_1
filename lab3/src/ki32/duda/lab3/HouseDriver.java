package ki32.duda.lab3;

import java.io.IOException;

/**
 * Клас HouseDriver є драйвером для демонстрації роботи класу House.
 * Виконує основні операції з будинком, такі як відкриття/закриття вікон і дверей,
 * зміна характеристик даху, огляд будинку тощо.
 */
public class HouseDriver {

    /**
     * Метод main є точкою входу в програму. Він демонструє основну функціональність класу House.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
          OfficeCenter officeCenter = new OfficeCenter(5, 20, true);

            // Демонстрація методів
            officeCenter.inspectHouse();
            officeCenter.rent();
            officeCenter.setNumberOfOffices(25);
            officeCenter.changeWindowType("Панорамний");
            officeCenter.repaintRoof("Сірий");
            officeCenter.inspectHouse();
            officeCenter.vacate();

            // Закриття логера
            officeCenter.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл.
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}