import math
from lab8_calculator import (
    calculate_expression,
    write_text_file,
    read_text_file,
    write_binary_file,
    read_binary_file,
    generate_results
)


def main():
    print("=" * 60)
    print("Програма обчислення y = tg(x)/ctg(x)")
    print("=" * 60)
    
    # Введення даних
    try:
        start = float(input("Введіть початкове значення x: "))
        end = float(input("Введіть кінцеве значення x: "))
        step = float(input("Введіть крок зміни x: "))
        
        if step <= 0:
            print("❌ Крок має бути додатнім числом!")
            return
        
        # Генеруємо значення x
        x_values = []
        current = start
        while current <= end:
            x_values.append(current)
            current += step
        
        if not x_values:
            print("❌ Не вдалося згенерувати значення x!")
            return
        
        print(f"\n📊 Буде обчислено {len(x_values)} значень")
        
        # Обчислюємо результати
        results = generate_results(x_values)
        
        # Виводимо результати на екран
        print("\n" + "=" * 60)
        print("Результати обчислень:")
        print("=" * 60)
        print(f"{'x (радіани)':<20} {'y':<20}")
        print("-" * 60)
        
        for x, y in results[:10]:  # Показуємо перші 10 результатів
            if math.isnan(y):
                print(f"{x:<20.6f} {'NaN':<20}")
            elif math.isinf(y):
                print(f"{x:<20.6f} {'Inf':<20}")
            else:
                print(f"{x:<20.6f} {y:<20.6f}")
        
        if len(results) > 10:
            print(f"... та ще {len(results) - 10} результатів")
        
        # Запис у текстовий файл
        text_filename = "result.txt"
        write_text_file(text_filename, results)
        
        # Запис у двійковий файл
        binary_filename = "result.bin"
        write_binary_file(binary_filename, results)
        
        # Читання з текстового файлу
        print("Читання з текстового файлу:")
        print("=" * 60)
        text_results = read_text_file(text_filename)
        if text_results:
            print(f"Перші 3 записи: {text_results[:3]}")
        
        # Читання з двійкового файлу
        print("Читання з двійкового файлу:")
        print("=" * 60)
        binary_results = read_binary_file(binary_filename)
        if binary_results:
            print(f"Перші 3 записи: {binary_results[:3]}")
        
        # Перевірка коректності
        if text_results and binary_results:
            if len(text_results) == len(binary_results):
                print("\n✅ Кількість записів у файлах співпадає!")
            else:
                print("\n⚠️ Кількість записів у файлах не співпадає!")
        
        print("Програма завершена успішно!")

        
    except ValueError:
        print("❌ Помилка: введено некоректне число!")
    except Exception as e:
        print(f"❌ Помилка: {e}")


if __name__ == "__main__":
    main()