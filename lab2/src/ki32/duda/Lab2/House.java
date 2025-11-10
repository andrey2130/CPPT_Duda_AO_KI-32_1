package ki32.duda.Lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Будинок: містить адресу, власника та список кімнат.
 * Усі публічні методи ведуть журнал діяльності.
 */
public class House {
     // Адреса будинку
    private Address address;
     // Власник будинку
    private Human owner;
     // Список кімнат
    private final List<Room> rooms;

    //Constructors
    /**
     * Створює будинок без даних.
     */
    public House() {
         // Базові значення
        this.address = new Address();
        this.owner = new Human();
        this.rooms = new ArrayList<>();
        LoggerInFile.printLogToFile("Будинок створений.");
    }

    /**
     * Створює будинок з адресою та власником.
     *
     * @param address адреса
     * @param owner власник
     */
    public House(Address address, Human owner) {
         // Ініціалізація без кімнат
        this.address = address;
        this.owner = owner;
        this.rooms = new ArrayList<>();
        LoggerInFile.printLogToFile("Будинок створений.");
    }

    /**
     * Повний конструктор з колекцією кімнат.
     */
    public House(Address address, Human owner, List<Room> rooms) {
         // Повна ініціалізація
        this.address = address;
        this.owner = owner;
        this.rooms = new ArrayList<>(rooms == null ? Collections.emptyList() : rooms);
        LoggerInFile.printLogToFile("Будинок створений (повний).");
    }

    /**
     * Копіювальний конструктор.
     */
    public House(House other) {
         // Копіювання значень
        this.address = new Address(other.address.getCity(), other.address.getStreet(), other.address.getBuildingNumber());
        this.owner = new Human(other.owner.getFirstName(), other.owner.getLastName());
        this.rooms = new ArrayList<>(other.rooms);
        LoggerInFile.printLogToFile("Будинок скопійований.");
    }

    //Getters
    public Address getAddress() {
         // Повертає адресу
        LoggerInFile.printLogToFile("Отримати адресу об'єкта.");
        return address;
    }

    public Human getOwner() {
         // Повертає власника
        LoggerInFile.printLogToFile("Отримати власника об'єкта.");
        return owner;
    }

    public List<Room> listRooms() {
         // Нерозмінний список кімнат
        LoggerInFile.printLogToFile("Список кімнат.");
        return Collections.unmodifiableList(rooms);
    }

    //Setters
    public void setAddress(Address address) {
         // Встановлює адресу
        this.address = address;
        LoggerInFile.printLogToFile("Встановити адресу об'єкта.");
    }

    public void setOwner(Human owner) {
         // Встановлює власника
        this.owner = owner;
        LoggerInFile.printLogToFile("Встановити власника об'єкта.");
    }

    // Domain methods (10+)
    public int addRoom(Room room) {
         // Додає кімнату
        rooms.add(room);
        LoggerInFile.printLogToFile("Додати кімнати: " + (room == null ? "null" : room.getName()) + '.');
        return rooms.size();
    }

    public boolean removeRoomByName(String name) {
         // Видаляє кімнату за назвою
        boolean removed = rooms.removeIf(r -> Objects.equals(r.getName(), name));
        if (removed) {
            LoggerInFile.printLogToFile("Вилучити кімнати за назвою: " + name + '.');
        } else {
            LoggerInFile.printLogToFile("Кімната не знайдена для вилучення: " + name + '.');
        }
        return removed;
    }

    public Room findRoom(String name) {
         // Пошук кімнати за назвою
        for (Room r : rooms) {
            if (Objects.equals(r.getName(), name)) {
                LoggerInFile.printLogToFile("Знайти кімнати за назвою: " + name + " -> true.");
                return r;
            }
        }
        LoggerInFile.printLogToFile("Кімната не знайдена за назвою: " + name + " -> false.");
        return null;
    }

    public boolean renovateRoom(String name) {
         // Позначає кімнату як відремонтовану
        Room r = findRoom(name);
        if (r == null) {
            LoggerInFile.printLogToFile("Неможливо реновацію. Кімната не знайдена: " + name + '.');
            return false;
        }
        r.setRenovated(true);
        LoggerInFile.printLogToFile("Реновація кімнати: " + name + '.');
        return true;
    }

    public int getRoomCount() {
         // Кількість кімнат
        LoggerInFile.printLogToFile("Отримати кількість кімнат: " + rooms.size() + '.');
        return rooms.size();
    }

    public double getTotalArea() {
         // Загальна площа
        double sum = 0.0;
        for (Room r : rooms) {
            sum += r.getAreaSqm();
        }
        LoggerInFile.printLogToFile("Отримати загальну площу: " + sum + '.');
        return sum;
    }

    public String describe() {
         // Опис у стовпчик
         String desc = "Будинок:" +
                 "\nАдреса: " + (address == null ? "невідомо" : address.format()) +
                 "\nВласник: " + (owner == null ? "невідомо" : owner.toString()) +
                 "\nКімнат: " + getRoomCount() +
                 "\nПлоща: " + getTotalArea() + " м²";
        LoggerInFile.printLogToFile("Опис будинку.");
        return desc;
    }

    @Override
    public String toString() {
         // Текстове представлення
        LoggerInFile.printLogToFile("Виклик toString з класу House.");
        return describe();
    }
}


