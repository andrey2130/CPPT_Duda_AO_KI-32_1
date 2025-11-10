package ki32.duda.lab3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            OfficeCenter officeCenter = new OfficeCenter(7, 35, true);

            officeCenter.inspectHouse();
            officeCenter.openDoor();
            officeCenter.openWindow();
            officeCenter.changeDoorGlass("Матовe");
            officeCenter.changeWindowType("Панорамний");
            officeCenter.repaintRoof("Сірий");
            officeCenter.rent();
            officeCenter.inspectHouse();
            officeCenter.vacate();
            officeCenter.closeDoor();
            officeCenter.closeWindow();

            officeCenter.closeLogger();
        } catch (IOException e) {
            throw new RuntimeException("Сталася помилка при роботі з файлом: " + e.getMessage(), e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Помилка виклику конструктора: " + e.getMessage(), e);
        }
    }
}