import math
import struct


def calculate_expression(x):
    """
    Обчислює значення виразу y = tg(x)/ctg(x)
    
    Аргументи:
        x (float): значення аргументу x в радіанах
    
    Повертає:
        float: значення y = tg(x)/ctg(x)
        
    Примітка: tg(x)/ctg(x) = tan(x)/cot(x) = tan²(x)
    """
    try:
        # Обчислюємо tg(x)
        tan_x = math.tan(x)
        
        # Обчислюємо y = tg(x)/ctg(x) = tan(x) / (1/tan(x)) = tan²(x)
        # Але якщо tan(x) = 0, то ctg(x) = inf, і 0/inf = 0
        if tan_x == 0:
            return 0.0
        
        # Обчислюємо ctg(x) = 1/tan(x)
        cot_x = 1.0 / tan_x
        
        # Якщо ctg(x) = 0 (тобто tan(x) = inf), то результат inf
        if cot_x == 0:
            return float('inf')
        
        # Обчислюємо y = tg(x)/ctg(x)
        y = tan_x / cot_x
        
        return y
    except (ValueError, ZeroDivisionError):
        return float('nan')


def write_text_file(filename, results):
    """
    Записує результати обчислень у текстовий файл
    
    Аргументи:
        filename (str): ім'я файлу для запису
        results (list): список кортежів (x, y) з результатами обчислень
    """
    try:
        with open(filename, 'w', encoding='utf-8') as f:
            # Записуємо заголовок
            f.write("Результати обчислення y = tg(x)/ctg(x)\n")
            f.write("=" * 50 + "\n")
            f.write(f"{'x':<15} {'y':<15}\n")
            f.write("-" * 50 + "\n")
            
            # Записуємо дані
            for x, y in results:
                if math.isnan(y):
                    f.write(f"{x:<15.6f} {'NaN':<15}\n")
                elif math.isinf(y):
                    f.write(f"{x:<15.6f} {'Inf':<15}\n")
                else:
                    f.write(f"{x:<15.6f} {y:<15.6f}\n")
            
            f.write("=" * 50 + "\n")
        print(f"✅ Результати записано у текстовий файл: {filename}")
    except IOError as e:
        print(f"❌ Помилка запису у текстовий файл: {e}")


def read_text_file(filename):
    """
    Читає результати обчислень з текстового файлу
    
    Аргументи:
        filename (str): ім'я файлу для читання
    
    Повертає:
        list: список кортежів (x, y) з результатами
    """
    results = []
    try:
        with open(filename, 'r', encoding='utf-8') as f:
            lines = f.readlines()
            # Пропускаємо заголовки
            for line in lines:
                line = line.strip()
                # Пропускаємо порожні рядки та роздільники
                if not line or '=' in line or '-' in line or 'x' in line.lower():
                    continue
                
                # Парсимо дані
                parts = line.split()
                if len(parts) >= 2:
                    try:
                        x = float(parts[0])
                        y_str = parts[1]
                        if y_str == 'NaN':
                            y = float('nan')
                        elif y_str == 'Inf':
                            y = float('inf')
                        else:
                            y = float(y_str)
                        results.append((x, y))
                    except ValueError:
                        continue
        
        print(f"✅ Результати прочитано з текстового файлу: {filename}")
        print(f"   Прочитано {len(results)} записів")
        return results
    except IOError as e:
        print(f"❌ Помилка читання текстового файлу: {e}")
        return []


def write_binary_file(filename, results):
    """
    Записує результати обчислень у двійковий файл
    
    Аргументи:
        filename (str): ім'я файлу для запису
        results (list): список кортежів (x, y) з результатами обчислень
    
    Формат: кожен запис - два числа типу double (8 байт кожне)
    """
    try:
        with open(filename, 'wb') as f:
            # Записуємо кількість записів
            count = len(results)
            f.write(struct.pack('i', count))
            
            # Записуємо дані
            for x, y in results:
                # Використовуємо 'd' для double (8 байт)
                f.write(struct.pack('dd', x, y))
        
        print(f"✅ Результати записано у двійковий файл: {filename}")
        print(f"   Записано {count} записів")
    except IOError as e:
        print(f"❌ Помилка запису у двійковий файл: {e}")


def read_binary_file(filename):
    """
    Читає результати обчислень з двійкового файлу
    
    Аргументи:
        filename (str): ім'я файлу для читання
    
    Повертає:
        list: список кортежів (x, y) з результатами
    """
    results = []
    try:
        with open(filename, 'rb') as f:
            # Читаємо кількість записів
            count_data = f.read(4)  # int - 4 байти
            if len(count_data) < 4:
                print("❌ Помилка: файл занадто короткий")
                return []
            
            count = struct.unpack('i', count_data)[0]
            
            # Читаємо дані
            for _ in range(count):
                data = f.read(16)  # два double - 16 байт
                if len(data) < 16:
                    break
                
                x, y = struct.unpack('dd', data)
                results.append((x, y))
        
        print(f"✅ Результати прочитано з двійкового файлу: {filename}")
        print(f"   Прочитано {len(results)} записів")
        return results
    except IOError as e:
        print(f"❌ Помилка читання двійкового файлу: {e}")
        return []


def generate_results(x_values):
    """
    Генерує результати обчислень для заданих значень x
    
    Аргументи:
        x_values (list): список значень x
    
    Повертає:
        list: список кортежів (x, y) з результатами
    """
    results = []
    for x in x_values:
        y = calculate_expression(x)
        results.append((x, y))
    return results
