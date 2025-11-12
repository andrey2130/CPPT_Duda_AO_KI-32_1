package duda.ki32.lab5;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введіть значення x: ");
            double x = scanner.nextDouble();

            double result = calculator.calculate(x);
            System.out.println("Результат: " + result);

            String textFilePath = "result.txt";
            calculator.writeResultToFile(result, textFilePath);
            System.out.println("Результат записано у текстовий файл: " + textFilePath);

            String binaryFilePath = "result.bin";
            calculator.writeResultToBinaryFile(result, binaryFilePath);
            System.out.println("Результат записано у двійковий файл: " + binaryFilePath);

            // Доданий рядок: одразу зчитуємо і виводимо бінарний файл
            double binaryResultPreview = calculator.readResultFromBinaryFile(binaryFilePath);
            System.out.println("Зміст бінарного файлу (як число): " + binaryResultPreview);

            double textResult = calculator.readResultFromFile(textFilePath);
            System.out.println("Результат, зчитаний з текстового файлу: " + textResult);

            double binaryResult = calculator.readResultFromBinaryFile(binaryFilePath);
            System.out.println("Результат, зчитаний з двійкового файлу: " + binaryResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка запису або читання файлу: " + e.getMessage());
        }
    }
}