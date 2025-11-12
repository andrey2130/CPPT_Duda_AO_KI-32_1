# main.py
# Головний модуль програми

from lab7_matrix import generate_jagged_matrix, print_matrix

def main():
    try:
        # Введення розміру квадратної матриці
        n = int(input("Введіть розмір квадратної матриці (n): "))
        if n <= 0:
            print("❌ Розмір має бути додатнім числом!")
            return
        
        # Введення символу-заповнювача
        symbol = input("Введіть символ-заповнювач: ")
        if len(symbol) != 1:
            print("❌ Треба ввести рівно один символ!")
            return
        
        # Генерація зубчастого списку (права нижня частина)
        matrix = generate_jagged_matrix(n, symbol)
        
        # Вивід результату
        print("\nЗубчастий список (права нижня заштрихована частина):")
        print_matrix(matrix)

    except ValueError:
        print("❌ Помилка: введено не число!")

if __name__ == "__main__":
    main()
