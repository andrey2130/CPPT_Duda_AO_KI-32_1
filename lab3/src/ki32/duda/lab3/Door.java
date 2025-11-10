package ki32.duda.lab3;

/**
 * Клас Door представляє двері будинку з певними характеристиками, такими як тип дверей, тип скла та стан (відкрито/закрито).
 */
public class Door {
    private String type;
    private String glassType;
    private boolean isOpen;

    /**
     * Конструктор для створення дверей з вказаним типом і станом.
     *
     * @param type   тип дверей (наприклад, розсувні, орні).
     * @param isOpen початковий стан дверей (true - відкриті, false - закриті).
     */
    public Door(String type, boolean isOpen) {
        this.type = type;
        this.isOpen = isOpen;
    }

    /**
     * Конструктор для створення дверей з вказаним типом, типом скла і станом.
     *
     * @param type      тип дверей (наприклад, розсувні, орні).
     * @param glassType тип скла дверей (наприклад, матове, прозоре).
     * @param isOpen    початковий стан дверей (true - відкриті, false - закриті).
     */
    public Door(String type, String glassType, boolean isOpen) {
        this.type = type;
        this.glassType = glassType;
        this.isOpen = isOpen;
    }

    /**
     * Метод для відкриття дверей.
     */
    public void open() {
        isOpen = true;
    }

    /**
     * Метод для закриття дверей.
     */
    public void close() {
        isOpen = false;
    }

    /**
     * Повертає тип дверей.
     *
     * @return тип дверей.
     */
    public String getType() {
        return type;
    }

    /**
     * Встановлює тип дверей.
     *
     * @param type новий тип дверей.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Повертає стан дверей.
     *
     * @return true, якщо двері відкриті, і false, якщо закриті.
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Встановлює стан дверей.
     *
     * @param open новий стан дверей (true - відкриті, false - закриті).
     */
    public void setOpen(boolean open) {
        isOpen = open;
    }

    /**
     * Повертає тип скла дверей.
     *
     * @return тип скла дверей.
     */
    public String getGlassType() {
        return glassType;
    }

    /**
     * Встановлює тип скла дверей.
     *
     * @param glassType новий тип скла дверей.
     */
    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    /**
     * Повертає рядкове представлення об'єкта Door.
     *
     * @return рядок, що представляє двері з їх характеристиками.
     */
    @Override
    public String toString() {
        return "Door{" +
                "type='" + type + '\'' +
                ", glassType='" + glassType + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }
}