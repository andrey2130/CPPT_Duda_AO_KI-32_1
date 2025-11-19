from house import House, ResidentialHouse


def main():
    """
    Головна функція програми, яка демонструє використання класів House та ResidentialHouse.
    """
    
    # Демонстрація роботи з базовим класом House
    print("1. Створення об'єкта базового класу House:")
    print("-" * 60)
    house1 = House("вул. Свободи, 25", 150.5, 2)
    print(f"   {house1}")
    print(f"   Площа на один поверх: {house1.calculate_area_per_floor():.2f} м²")
    print()
    
    # Зміна властивостей базового класу
    print("2. Зміна властивостей будинку:")
    print("-" * 60)
    house1.set_area(180.0)
    house1.set_floors(3)
    print(f"   {house1}")
    print(f"   Площа на один поверх: {house1.calculate_area_per_floor():.2f} м²")
    print()
    
    # Демонстрація роботи з похідним класом ResidentialHouse
    print("3. Створення об'єкта похідного класу ResidentialHouse:")
    print("-" * 60)
    residential1 = ResidentialHouse(
        address="вул. Грушевського, 23",
        area=120.0,
        floors=1,
        rooms=4,
        residents=3
    )
    print(f"   {residential1}")
    print(f"   Площа на одну кімнату: {residential1.calculate_area_per_room():.2f} м²")
    print(f"   Площа на одного мешканця: {residential1.calculate_area_per_resident():.2f} м²")
    print(f"   Щільність населення: {residential1.get_resident_density():.2f} осіб/100м²")
    print()
    
    # Використання методів базового класу через похідний
    print("4. Використання методів базового класу через похідний:")
    print("-" * 60)
    print(f"   Адреса: {residential1.get_address()}")
    print(f"   Площа: {residential1.get_area()} м²")
    print(f"   Поверхів: {residential1.get_floors()}")
    print(f"   Площа на один поверх: {residential1.calculate_area_per_floor():.2f} м²")
    print()
    
    # Створення другого житлового будинку
    print("5. Створення другого житлового будинку:")
    print("-" * 60)
    residential2 = ResidentialHouse()
    residential2.set_address("проспект Свободи, 15")
    residential2.set_area(200.0)
    residential2.set_floors(2)
    residential2.set_rooms(5)
    residential2.set_residents(4)
    print(f"   {residential2}")
    print(f"   Площа на одну кімнату: {residential2.calculate_area_per_room():.2f} м²")
    print(f"   Площа на одного мешканця: {residential2.calculate_area_per_resident():.2f} м²")
    print(f"   Щільність населення: {residential2.get_resident_density():.2f} осіб/100м²")
    print()
    
    # Порівняння будинків
    print("6. Порівняння будинків:")
    print("-" * 60)
    print(f"   Будинок 1: {residential1.get_address()}, площа={residential1.get_area()} м²")
    print(f"   Будинок 2: {residential2.get_address()}, площа={residential2.get_area()} м²")
    if residential1.get_area() > residential2.get_area():
        print(f"   Будинок 1 більший за будинок 2")
    elif residential1.get_area() < residential2.get_area():
        print(f"   Будинок 2 більший за будинок 1")
    else:
        print(f"   Будинки мають однакову площу")
    print()
    
    # Використання repr()
    print("7. Формальне представлення об'єктів:")
    print("-" * 60)
    print(f"   repr(house1): {repr(house1)}")
    print(f"   repr(residential1): {repr(residential1)}")
    print()

if __name__ == "__main__":
    main()

