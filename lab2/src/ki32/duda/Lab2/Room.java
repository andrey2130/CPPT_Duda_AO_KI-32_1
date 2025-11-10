package ki32.duda.Lab2;

/**
 * Кімната в будинку.
 */
public class Room {
    private String name;
    private double areaSqm;
    private boolean renovated;

    /**
     * Порожня кімната.
     */
    public Room() {
        LoggerInFile.printLogToFile("Кімната створена.");
    }

    /**
     * Кімната з назвою і площею.
     *
     * @param name назва кімнати
     * @param areaSqm площа у м^2
     */
    public Room(String name, double areaSqm) {
        this.name = name;
        this.areaSqm = areaSqm;
        LoggerInFile.printLogToFile("Кімната створена: " + name + ", " + areaSqm + " кв.м.");
    }

    public String getName() {
        LoggerInFile.printLogToFile("Отримати назву кімнати: " + name + '.');
        return name;
    }

    public void setName(String name) {
        this.name = name;
        LoggerInFile.printLogToFile("Встановити назву кімнати: " + name + '.');
    }

    public double getAreaSqm() {
        LoggerInFile.printLogToFile("Отримати площу кімнати: " + areaSqm + '.');
        return areaSqm;
    }

    public void setAreaSqm(double areaSqm) {
        this.areaSqm = areaSqm;
        LoggerInFile.printLogToFile("Встановити площу кімнати: " + areaSqm + '.');
    }

    public boolean isRenovated() {
        LoggerInFile.printLogToFile("Чи є кімната реновацією: " + renovated + '.');
        return renovated;
    }

    public void setRenovated(boolean renovated) {
        this.renovated = renovated;
        LoggerInFile.printLogToFile("Встановити реновацію кімнати: " + renovated + '.');
    }
}


