package ki32.duda.lab4;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Програма-драйвер для обчислення виразу y = tg(x) / ctg(x)
 * 
 * <p>Програма виконує обчислення для набору тестових значень та записує
 * результати у файл results.txt. Також підтримує введення значення з клавіатури.
 * 
 * @author Дуда
 * @version 1.0
 */
public class EquationsApp {
    /**
     * Головний метод програми
     * 
     * <p>Виконує обчислення виразу y = tg(x) / ctg(x) для тестових значень
     * та записує результати у файл results.txt. Обробляє виключення, що
     * можуть виникнути під час обчислень.
     * 
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        CalculateTheEquationInterface calc = new CalculateTheEquation();
        String outputFile = "results.txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            System.out.println("Обчислення y = tan(x) / cot(x)");
            writer.println("Результати обчислення y = tan(x) / cot(x)");
            
            
            double[] testValues = {100, 90, -1111, Math.PI / 4, Math.PI / 6};
            
            for (double x : testValues) {
                try {
                    double result = calc.doCalculation(x);
                    String line = String.format("x = %.6f, y = %.6f", x, result);
                    System.out.println(line);
                    writer.println(line);
                } catch (ArithmeticException e) {
                    String line = String.format("x = %.6f, помилка: %s", x, e.getMessage());
                    System.out.println(line);
                    writer.println(line);
                }
            }
            
            System.out.println("\nВведення значення з клавіатури:");
            writer.println("\nВведення значення з клавіатури:");
            try {
                double result = calc.doCalculationWithInputInside();
                String line = String.format("Результат: y = %.6f", result);
                System.out.println(line);
                writer.println(line);
            } catch (Exception e) {
                String line = "Помилка при обчисленні: " + e.getMessage();
                System.out.println(line);
                writer.println(line);
            }
            
            System.out.println("\nРезультати записано у файл: " + outputFile);
            
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}