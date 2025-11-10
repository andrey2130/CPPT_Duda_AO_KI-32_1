package ki32.duda.Lab2;

/**
 * Власник будинку.
 */
public class Human {
    private String firstName, lastName;

    //Constructors
    public Human() {
        LoggerInFile.printLogToFile("Власник створений.");
    }

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        LoggerInFile.printLogToFile("Власник створений.");
    }

    //Getters
    public String getFirstName() {
        LoggerInFile.printLogToFile("Отримати ім'я: " + firstName + '.');
        return firstName;
    }

    public String getLastName() {
        LoggerInFile.printLogToFile("Отримати прізвище: " + lastName + '.');
        return lastName;
    }

    //Setters
    public void setFirstName(String firstName) {
        LoggerInFile.printLogToFile("Встановити ім'я: " + firstName + '.');
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LoggerInFile.printLogToFile("Встановити прізвище: " + lastName + '.');
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        LoggerInFile.printLogToFile("Виклик toString з класу Human.");
        return lastName + " " + firstName;
    }
}


