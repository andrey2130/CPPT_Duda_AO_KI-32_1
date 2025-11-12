package duda.ki32.lab6;

/**
 * Параметризований клас PencilCase представляє пенал для зберігання предметів.
 * @param <T> тип предметів, що зберігаються (має розширювати Item)
 */
class PencilCase<T extends Item> {
    private T[] items;
    private int size;
    private int capacity;
    

    /**
     * Конструктор для створення пеналу заданої місткості.
     * @param capacity максимальна кількість предметів
     */
    @SuppressWarnings("unchecked")
    public PencilCase(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Item[capacity];
        this.size = 0;

    }

    /**
     * Додає предмет до пеналу.
     * @param item предмет для додавання
     * @return true, якщо предмет успішно додано, false якщо пенал заповнений
     * @throws IllegalArgumentException якщо item є null
     */
    public boolean addItem(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Неможливо додати null предмет!");
        }
        if (size >= capacity) {
            System.out.println("Пенал заповнений! Неможливо додати: " + item.getName());
            return false;
        }

        if(item.getWeight() < 0 || item.getPrice() < 0) {
            System.out.println("Вага або ціна не може бути нижчою за 0");
            return false;
        }
            
        items[size++] = item;
        System.out.println("Додано: " + item);
        return true;
    }

    /**
     * Видаляє предмет з пеналу за індексом.
     * @param index індекс предмету для видалення
     * @return видалений предмет або null, якщо індекс некоректний
     */
    public T removeItem(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Некоректний індекс!");
            return null;
        }
        T removedItem = items[index];
        // Зсув елементів вліво
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        items[--size] = null;
        System.out.println("Видалено: " + removedItem);
        return removedItem;
    }

    /**
     * Знаходить мінімальний предмет за ціною (парний варіант).
     * @return предмет з мінімальною ціною або null, якщо пенал порожній
     */
    public T findMinItem() {
        if (size == 0) {
            System.out.println("Пенал порожній!");
            return null;
        }
        T minItem = items[0];
        for (int i = 1; i < size; i++) {
            if (items[i].compareTo(minItem) < 0) {
                minItem = items[i];
            }
        }
        return minItem;
    }

    /**
     * Обчислює загальну вагу всіх предметів у пеналі.
     * @return загальна вага в грамах
     */
    public double getTotalWeight() {
        double totalWeight = 0;
        for (int i = 0; i < size; i++) {
            totalWeight += items[i].getWeight();
        }
        return totalWeight;
    }

    /**
     * Обчислює загальну вартість всіх предметів у пеналі.
     * @return загальна вартість в гривнях
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < size; i++) {
            totalPrice += items[i].getPrice();
        }
        return totalPrice;
    }

    /**
     * Виводить інформацію про всі предмети в пеналі.
     */
    public void displayItems() {
        if (size == 0) {
            System.out.println("Пенал порожній.");
            return;
        }
        System.out.println("\n=== Вміст пеналу ===");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + items[i]);
        }
        System.out.println("====================");
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}