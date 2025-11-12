package duda.ki32.lab6;

public class Lab6Driver {
    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота 6: Пенал ===\n");

        try {
            // Створення пеналу для ручок
            PencilCase<Pen> penCase = new PencilCase<>(5);
            System.out.println("--- Пенал для ручок ---");

                penCase.addItem(new Pen("Parker", 15.5, 250.00, "синій"));
                penCase.addItem(new Pen("BIC", 8.0, 12.50, "чорний"));
                penCase.addItem(new Pen("Pilot", 12.0, 85.00, "червоний"));

            
            penCase.displayItems();

            // Створення пеналу для олівців
            PencilCase<Pencil> pencilCase = new PencilCase<>(5);
            System.out.println("\n--- Пенал для олівців ---");
            try {
                pencilCase.addItem(new Pencil("Faber-Castell", 6.5, 45.00, "HB"));
                pencilCase.addItem(new Pencil("Koh-i-Noor", 7.0, 38.00, "2B"));
                pencilCase.addItem(new Pencil("Staedtler", 6.8, 52.00, "H"));
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка додавання: " + e.getMessage());
            }
            pencilCase.displayItems();

            // Створення загального пеналу для різних предметів
            PencilCase<Item> mixedCase = new PencilCase<>(10);
            System.out.println("\n--- Змішаний пенал ---");
            try {
                mixedCase.addItem(new Pen("Schneider", 10.0, 65.00, "зелений"));
                mixedCase.addItem(new Pencil("Lyra", 7.5, 28.00, "B"));
                mixedCase.addItem(new Pen("Zebra", 9.5, 95.00, "синій"));
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка додавання: " + e.getMessage());
            }
            mixedCase.displayItems();

            // Пошук мінімального елемента
            System.out.println("\n--- Пошук найдешевшого предмету ---");
            Pen minPen = penCase.findMinItem();
            if (minPen != null) {
                System.out.println("Найдешевша ручка: " + minPen);
            }

            Pencil minPencil = pencilCase.findMinItem();
            if (minPencil != null) {
                System.out.println("Найдешевший олівець: " + minPencil);
            }

            Item minItem = mixedCase.findMinItem();
            if (minItem != null) {
                System.out.println("Найдешевший предмет у змішаному пеналі: " + minItem);
            }

            // Виведення статистики
            System.out.println("\n--- Статистика ---");
            System.out.printf("Загальна вага ручок: %.1f г\n", penCase.getTotalWeight());
            System.out.printf("Загальна вартість ручок: %.2f грн\n", penCase.getTotalPrice());
            System.out.printf("Загальна вага олівців: %.1f г\n", pencilCase.getTotalWeight());
            System.out.printf("Загальна вартість олівців: %.2f грн\n", pencilCase.getTotalPrice());

            // Видалення елемента
            System.out.println("\n--- Видалення елемента ---");
            try {
                penCase.removeItem(1);
            } catch (Exception e) {
                System.out.println("Помилка видалення: " + e.getMessage());
            }
            penCase.displayItems();
          
            // NullPointerException
        } catch (Exception e) {
            System.err.println("Критична помилка програми: " + e.getMessage());
            e.printStackTrace();
        }


    }
}