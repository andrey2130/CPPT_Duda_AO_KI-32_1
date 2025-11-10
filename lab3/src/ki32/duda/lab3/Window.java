package ki32.duda.lab3;


/**
 * Клас Window представляє вікно будинку з певним типом та станом (відкрито/закрито).
 */
public class Window {
    private String type;
    private boolean isOpen;

    /**
     * Конструктор для створення вікна з вказаним типом і станом.
     *
     * @param type   тип вікна (наприклад, арочний, прямокутний).
     * @param isOpen початковий стан вікна (true - відкрите, false - закрите).
     */
    public Window(String type, boolean isOpen) {
        this.type = type;
        this.isOpen = isOpen;
    }

    /**
     * Метод для відкриття вікна.
     */
    public void open() {
        isOpen = true;
    }

    /**
     * Метод для закриття вікна.
     */
    public void close() {
        isOpen = false;
    }

    /**
     * Повертає тип вікна.
     *
     * @return тип вікна.
     */
    public String getType() {
        return type;
    }

    /**
     * Встановлює тип вікна.
     *
     * @param type новий тип вікна.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Повертає стан вікна.
     *
     * @return true, якщо вікно відкрите, і false, якщо закрите.
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Встановлює стан вікна.
     *
     * @param open новий стан вікна (true - відкрите, false - закрите).
     */
    public void setOpen(boolean open) {
        isOpen = open;
    }

    /**
     * Повертає рядкове представлення об'єкта Window.
     *
     * @return рядок, що представляє вікно з його характеристиками.
     */
    @Override
    public String toString() {
        return "Window{" +
                "type='" + type + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }
}