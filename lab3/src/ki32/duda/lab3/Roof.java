package ki32.duda.lab3;


/**
 * Клас Roof представляє дах будинку з певним матеріалом та кольором.
 */
public class Roof {
    private String material;
    private String color;

    /**
     * Конструктор для створення даху з вказаним матеріалом і кольором.
     *
     * @param material матеріал даху (наприклад, черепиця, метал).
     * @param color    колір даху (наприклад, червоний, зелений).
     */
    public Roof(String material, String color) {
        this.material = material;
        this.color = color;
    }

    /**
     * Повертає матеріал даху.
     *
     * @return матеріал даху.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Встановлює новий матеріал даху.
     *
     * @param material новий матеріал даху.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Повертає колір даху.
     *
     * @return колір даху.
     */
    public String getColor() {
        return color;
    }

    /**
     * Встановлює новий колір даху.
     *
     * @param color новий колір даху.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Повертає рядкове представлення об'єкта Roof.
     *
     * @return рядок, що представляє дах з його характеристиками.
     */
    @Override
    public String toString() {
        return "Roof{" +
                "material='" + material + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
