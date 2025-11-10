package ki32.duda.lab4;

public interface CalculateTheEquationInterface {
    /**
     * Обчислює значення виразу y = tg(x) / ctg(x) для заданого значення x
     * 
     * @param variable значення x для обчислення
     * @return результат обчислення y = tg(x) / ctg(x)
     * @throws ArithmeticException якщо tg(x) або ctg(x) невизначені
     */
    double doCalculation(double variable);
    
    /**
     * Обчислює значення виразу y = tg(x) / ctg(x) з введенням значення x з клавіатури
     * 
     * @return результат обчислення y = tg(x) / ctg(x), або 0 у випадку помилки
     */
    double doCalculationWithInputInside();
}