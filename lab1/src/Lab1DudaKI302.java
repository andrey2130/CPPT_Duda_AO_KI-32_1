import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Програма формує зубчастий масив, який містить лише заштриховану нижньоправу
 * трикутну частину квадратної матриці та виводить результат у консоль і файл.
 * 
 * @author Андрій 
 * @version 1.0
 */


public class Lab1DudaKI302 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введіть розмір квадратної матриці: ");
            int n = in.nextInt();
            in.nextLine();

            if (n <= 0) {
                System.out.println("Помилка: розмір матриці має бути додатним цілим числом.");
                return;
            }

            System.out.print("Введіть символ-заповнювач: ");
            String filler = in.nextLine();

            if (filler == null || filler.length() != 1) {
                System.out.println("Помилка: введіть рівно один символ-заповнювач.");
                return;
            }

            char sym = filler.charAt(0);
            char[][] matrix = new char[n][n];

            try (PrintWriter fout = new PrintWriter("MyFile.txt")) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        boolean fill = i >= (n - 1 - j);
                        if (fill) {
                            matrix[i][j] = sym;
                            System.out.print(matrix[i][j] + " ");
                            fout.print(matrix[i][j] + " ");
                        } else {
                            System.out.print("  ");
                            fout.print("  ");
                        }
                    }
                    System.out.println();
                    fout.println();
                }
            } catch (Exception e) {
                System.out.println("Помилка: не вдалося записати у файл.");
                return;
            }

            System.out.println("Результат записано у MyFile.txt");
        } catch (InputMismatchException e) {
            System.out.println("Помилка: некоректне введення. Потрібне ціле число для розміру.");
        } catch (Exception e) {
            System.out.println("Помилка: неочікуваний збій.");
        }
    }
}