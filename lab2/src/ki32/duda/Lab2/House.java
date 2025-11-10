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
    private Address address;
    private Human owner;
    private final List<Room> rooms;

    //Constructors
    /**
     * Створює будинок без даних.
     */
    public House() {
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
        this.address = address;
        this.owner = owner;
        this.rooms = new ArrayList<>();
        LoggerInFile.printLogToFile("Будинок створений.");
    }

    /**
     * Повний конструктор з колекцією кімнат.
     */
    public House(Address address, Human owner, List<Room> rooms) {
        this.address = address;
        this.owner = owner;
        this.rooms = new ArrayList<>(rooms == null ? Collections.emptyList() : rooms);
        LoggerInFile.printLogToFile("Будинок створений (повний).");
    }

    /**
     * Копіювальний конструктор.
     */
    public House(House other) {
        this.address = new Address(other.address.getCity(), other.address.getStreet(), other.address.getBuildingNumber());
        this.owner = new Human(other.owner.getFirstName(), other.owner.getLastName());
        this.rooms = new ArrayList<>(other.rooms);
        LoggerInFile.printLogToFile("Будинок скопійований.");
    }

    //Getters
    public Address getAddress() {
        LoggerInFile.printLogToFile("Отримати адресу об'єкта.");
        return address;
    }

    public Human getOwner() {
        LoggerInFile.printLogToFile("Отримати власника об'єкта.");
        return owner;
    }

    public List<Room> listRooms() {
        LoggerInFile.printLogToFile("Список кімнат.");
        return Collections.unmodifiableList(rooms);
    }

    //Setters
    public void setAddress(Address address) {
        this.address = address;
        LoggerInFile.printLogToFile("Встановити адресу об'єкта.");
    }

    public void setOwner(Human owner) {
        this.owner = owner;
        LoggerInFile.printLogToFile("Встановити власника об'єкта.");
    }

    // Domain methods (10+)
    public int addRoom(Room room) {
        rooms.add(room);
        LoggerInFile.printLogToFile("Додати кімнати: " + (room == null ? "null" : room.getName()) + '.');
        return rooms.size();
    }

    public boolean removeRoomByName(String name) {
        boolean removed = rooms.removeIf(r -> Objects.equals(r.getName(), name));
        if (removed) {
            LoggerInFile.printLogToFile("Вилучити кімнати за назвою: " + name + '.');
        } else {
            LoggerInFile.printLogToFile("Кімната не знайдена для вилучення: " + name + '.');
        }
        return removed;
    }

    public Room findRoom(String name) {
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
        LoggerInFile.printLogToFile("Отримати кількість кімнат: " + rooms.size() + '.');
        return rooms.size();
    }

    public double getTotalArea() {
        double sum = 0.0;
        for (Room r : rooms) {
            sum += r.getAreaSqm();
        }
        LoggerInFile.printLogToFile("Отримати загальну площу: " + sum + '.');
        return sum;
    }

    public String describe() {
        String desc = "Будинок за адресою: " +
                (address == null ? "невідомо" : address.format()) +
                "; власник: " +
                (owner == null ? "невідомо" : owner.toString()) +
                "; кімнат: " + getRoomCount() +
                "; площа: " + getTotalArea() + " м²";
        LoggerInFile.printLogToFile("Опис будинку.");
        return desc;
    }

    @Override
    public String toString() {
        LoggerInFile.printLogToFile("Виклик toString з класу House.");
        return describe();
    }
}


