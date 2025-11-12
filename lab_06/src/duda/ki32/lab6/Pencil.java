package duda.ki32.lab6;

/**
 * Клас Pencil представляє олівець.
 * Розширює базовий клас Item додаючи твердість грифеля.
 */
class Pencil extends Item {
    private String hardness;

    /**
     * Конструктор для створення олівця.
     * @param name назва олівця
     * @param weight вага в грамах
     * @param price ціна в гривнях
     * @param hardness твердість грифеля (HB, 2B, тощо)
     */
    public Pencil(String name, double weight, double price, String hardness) {
        super(name, weight, price);
        this.hardness = hardness;
    }

    public String getHardness() {
        return hardness;
    }

    @Override
    public String toString() {
        return super.toString() + ", твердість: " + hardness;
    }
}
