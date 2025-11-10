package ki32.duda.lab3;
import java.io.IOException;

/**
 * Клас OfficeCenter розширює абстрактний клас House та реалізує інтерфейс Rentable.
 * Представляє офісний центр з додатковими характеристиками та функціональністю.
 */
public class OfficeCenter extends House implements Rentable{
    private int numberOfFloors;
    private int numberOfOffices;
    private boolean hasParking;
    private boolean isRented;

    /**
     * Конструктор для створення об'єкту OfficeCenter.
     *
     * @param numberOfFloors  кількість поверхів в офісному центрі
     * @param numberOfOffices кількість офісів
     * @param hasParking      наявність парковки
     * @throws IOException            якщо виникає помилка при роботі з лог-файлом
     * @throws NoSuchMethodException якщо виникає помилка при виклику конструктора суперкласу (залишено для сумісності)
     */
    public OfficeCenter(int numberOfFloors, int numberOfOffices, boolean hasParking) throws IOException, NoSuchMethodException {
        super();
        this.numberOfFloors = numberOfFloors;
        this.numberOfOffices = numberOfOffices;
        this.hasParking = hasParking;
        this.isRented = false;


        logger.log("Створено офісний центр: " + this.toString());
    }

    /**
     * Метод для отримання кількості поверхів.
     *
     * @return кількість поверхів
     */
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Метод для встановлення кількості поверхів.
     *
     * @param numberOfFloors нова кількість поверхів
     * @throws IOException якщо виникає помилка при записі в лог-файл
     */
    public void setNumberOfFloors(int numberOfFloors) throws IOException {
        this.numberOfFloors = numberOfFloors;
        logger.log("Змінено кількість поверхів: " + numberOfFloors);
    }

    /**
     * Метод для отримання кількості офісів.
     *
     * @return кількість офісів
     */
    public int getNumberOfOffices() {
        return numberOfOffices;
    }

    /**
     * Метод для встановлення кількості офісів.
     *
     * @param numberOfOffices нова кількість офісів
     * @throws IOException якщо виникає помилка при записі в лог-файл
     */
    public void setNumberOfOffices(int numberOfOffices) throws IOException {
        this.numberOfOffices = numberOfOffices;
        logger.log("Змінено кількість офісів: " + numberOfOffices);
    }

    /**
     * Метод для перевірки наявності парковки.
     *
     * @return true, якщо парковка є, false - якщо немає
     */
    public boolean hasParking() {
        return hasParking;
    }

    /**
     * Метод для встановлення наявності парковки.
     *
     * @param hasParking нове значення наявності парковки
     * @throws IOException якщо виникає помилка при записі в лог-файл
     */
    public void setHasParking(boolean hasParking) throws IOException {
        this.hasParking = hasParking;
        logger.log("Змінено наявність парковки: " + hasParking);
    }

    /**
     * Реалізація методу з інтерфейсу Rentable для здачі в оренду.
     *
     * @throws IOException якщо виникає помилка при записі в лог-файл
     */
    @Override
    public void rent() throws IOException {
        if (!isRented) {
            isRented = true;
            logger.log("Офісний центр здано в оренду");
        } else {
            logger.log("Офісний центр вже здано в оренду");
        }
    }

    /**
     * Реалізація методу з інтерфейсу Rentable для звільнення від оренди.
     *
     * @throws IOException якщо виникає помилка при записі в лог-файл
     */
    @Override
    public void vacate() throws IOException {
        if (isRented) {
            isRented = false;
            logger.log("Офісний центр звільнено від оренди");
        } else {
            logger.log("Офісний центр не був в оренді");
        }
    }


    /**
     * Перевизначений метод для огляду офісного центру.
     *
     * @throws IOException якщо виникає помилка при записі в лог-файл
     */
    @Override
    public void inspectHouse() throws IOException {
        String inspectionReport = String.format("Огляд офісного центру: \n Кількість поверхів: %d \n Кількість офісів: %d \n Наявність парковки: %s \n В оренді: %s",
                numberOfFloors, numberOfOffices, hasParking ? "Так" : "Ні", isRented ? "Так" : "Ні");
        logger.log(inspectionReport);
        System.out.println(inspectionReport);
    }
}
