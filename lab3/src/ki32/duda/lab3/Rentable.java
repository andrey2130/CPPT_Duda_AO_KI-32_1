package ki32.duda.lab3;


import java.io.IOException;

/**
 * Інтерфейс Rentable визначає методи для об'єктів, які можуть бути здані в оренду.
 */
public interface Rentable {
    /**
     * Метод для здачі об'єкта в оренду.
     *
     * @throws IOException якщо виникає помилка при записі в лог-файл
     */
    void rent() throws IOException;

    /**
     * Метод для звільнення об'єкта від оренди.
     *
     * @throws IOException якщо виникає помилка при записі в лог-файл
     */
    void vacate() throws IOException;
}