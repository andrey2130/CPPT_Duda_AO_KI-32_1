package duda.ki32.lab6;

/**
 * Клас Pen представляє ручку.
 * Розширює базовий клас Item додаючи колір чорнила.
 */
class Pen extends Item {
    private String inkColor;

    /**
     * Конструктор для створення ручки.
     * @param name назва ручки
     * @param weight вага в грамах
     * @param price ціна в гривнях
     * @param inkColor колір чорнила
     */
    public Pen(String name, double weight, double price, String inkColor) {
        super(name, weight, price);
        this.inkColor = inkColor;
    }

    public String getInkColor() {
        return inkColor;
    }

    @Override
    public String toString() {
        return super.toString() + ", колір: " + inkColor;
    }
}
