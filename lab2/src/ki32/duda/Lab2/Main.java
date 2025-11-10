package ki32.duda.Lab2;

/**
 * Клас-драйвер для демонстрації роботи пакету {@code ki32.duda.Lab3}.
 */
public class Main {
    public static void main(String[] args) {
        House house = new House(
                new Address("Львів", "Антоновича", "121"),
                new Human("Андрій", "Дуда")
        );

        house.addRoom(new Room("Вітальня", 50.0));
        house.addRoom(new Room("Кухня", 12.0));
        house.addRoom(new Room("Спальня", 12.0));

        house.renovateRoom("Кухня");
        for (String part : house.describe().split(",\\s*")) {
            System.out.println(part);
        }

        house.removeRoomByName("Спальня");
        System.out.println("Після змін:");
        System.out.println("кімнат = " + house.getRoomCount());
        System.out.println("площа = " + house.getTotalArea());
    }
}


