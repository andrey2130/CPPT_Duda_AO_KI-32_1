package ki32.duda.Lab2;

/**
 * Адреса будинку.
 */
public class Address {
    private String city;
    private String street;
    private String buildingNumber;

    /**
     * Створює порожню адресу.
     */
    public Address() {
    }

    /**
     * Створює адресу з основними полями.
     *
     * @param city місто
     * @param street вулиця
     * @param buildingNumber номер будинку
     */
    public Address(String city, String street, String buildingNumber) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        LoggerInFile.printLogToFile("Встановити місто: " + city + '.');
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
        LoggerInFile.printLogToFile("Встановити вулицю: " + street + '.');
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        LoggerInFile.printLogToFile("Встановити номер будинку: " + buildingNumber + '.');
    }

    /**
     * @return текстове представлення адреси
     */
    public String format() {
        LoggerInFile.printLogToFile("Форматувати адресу.");
        return city + ", " + street + " " + buildingNumber;
    }
}


