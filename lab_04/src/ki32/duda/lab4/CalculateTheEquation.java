package ki32.duda.lab4;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас для обчислення виразу y = tg(x) / ctg(x)
 * 
 * <p>Реалізує обчислення математичного виразу y = tan(x) / cot(x) = tan²(x).
 * Виконує перевірку на невизначеність функцій тангенс та котангенс.
 * 
 * @author Дуда
 * @version 1.0
 */
public class CalculateTheEquation implements CalculateTheEquationInterface {
    
    /**
     * Обчислює значення виразу y = tg(x) / ctg(x) для заданого значення x
     * 
     * <p>Математично: y = tan(x) / cot(x) = tan(x) / (1/tan(x)) = tan²(x)
     * 
     * @param variable значення x для обчислення (в радіанах)
     * @return результат обчислення y = tan²(x)
     * @throws ArithmeticException якщо tg(x) або ctg(x) невизначені
     */
    @Override
    public double doCalculation(double variable) {
        try {
            double tanValue = Math.tan(variable);
            
            // Перевірка на невизначеність tg(x) (коли x = π/2 + πk)
            if (Double.isInfinite(tanValue) || Double.isNaN(tanValue)) {
                throw new ArithmeticException("tg(x) невизначений для x = " + variable);
            }
            
            // Перевірка на нуль tan(x) (коли x = πk, тоді ctg(x) невизначений)
            if (Math.abs(tanValue) < 1e-10) {
                throw new ArithmeticException("tg(x) ≈ 0, ctg(x) невизначений для x = " + variable);
            }
            
            // y = tan²(x)
            return tanValue * tanValue;
            
        } catch (ArithmeticException e) {
            System.out.println("Арифметична помилка: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Обчислює значення виразу y = tg(x) / ctg(x) з введенням значення x з клавіатури
     * 
     * <p>Зчитує значення x від користувача та обчислює y = tan²(x).
     * При виникненні помилки повертає 0.
     * 
     * @return результат обчислення y = tan²(x), або 0 у випадку помилки
     */
    @Override
    public double doCalculationWithInputInside() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            System.out.print("Введіть значення x (в радіанах): ");
            double value = inputScanner.nextDouble();
            
            double tanValue = Math.tan(value);
            
            // Перевірка на невизначеність tg(x)
            if (Double.isInfinite(tanValue) || Double.isNaN(tanValue)) {
                throw new ArithmeticException("tg(x) невизначений для x = " + value);
            }
            
            // Перевірка на нуль tan(x) (коли ctg(x) невизначений)
            if (Math.abs(tanValue) < 1e-10) {
                throw new ArithmeticException("tg(x) ≈ 0, ctg(x) невизначений для x = " + value);
            }
            
            // y = tan²(x)
            return tanValue * tanValue;

        } catch (ArithmeticException e) {
            System.out.println("Арифметична помилка: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Помилка вводу: некоректне значення.");
        }
        return 0;
    }
}