class House:
    """
    Базовий клас House реалізує основні властивості та методи будинку.
    
    Атрибути:
        address (str): Адреса будинку
        area (float): Площа будинку в квадратних метрах
        floors (int): Кількість поверхів будинку
    """
    
    def __init__(self, address: str = "", area: float = 0.0, floors: int = 1):
        """
        Конструктор класу House.
        
        Аргументи:
            address (str): Адреса будинку
            area (float): Площа будинку в квадратних метрах
            floors (int): Кількість поверхів будинку
        """
        self.address = address
        self.area = area
        self.floors = floors
    
    def get_address(self) -> str:
        """
        Повертає адресу будинку.
        
        Повертає:
            str: Адреса будинку
        """
        return self.address
    
    def get_area(self) -> float:
        """
        Повертає площу будинку.
        
        Повертає:
            float: Площа будинку в квадратних метрах
        """
        return self.area
    
    def get_floors(self) -> int:
        """
        Повертає кількість поверхів будинку.
        
        Повертає:
            int: Кількість поверхів
        """
        return self.floors
    
    def set_address(self, address: str) -> None:
        """
        Встановлює адресу будинку.
        
        Аргументи:
            address (str): Нова адреса будинку
        """
        self.address = address
    
    def set_area(self, area: float) -> None:
        """
        Встановлює площу будинку.
        
        Аргументи:
            area (float): Нова площа будинку в квадратних метрах
        """
        if area >= 0:
            self.area = area
        else:
            raise ValueError("Площа не може бути від'ємною")
    
    def set_floors(self, floors: int) -> None:
        """
        Встановлює кількість поверхів будинку.
        
        Аргументи:
            floors (int): Нова кількість поверхів
        """
        if floors > 0:
            self.floors = floors
        else:
            raise ValueError("Кількість поверхів повинна бути більше нуля")
    
    def calculate_area_per_floor(self) -> float:
        """
        Обчислює площу на один поверх.
        
        Повертає:
            float: Площа на один поверх в квадратних метрах
        """
        if self.floors > 0:
            return self.area / self.floors
        return 0.0
    
    def __str__(self) -> str:
        """
        Повертає рядкове представлення об'єкта House.
        
        Повертає:
            str: Рядкове представлення будинку
        """
        return (f"Будинок: адреса='{self.address}', "
                f"площа={self.area} м², поверхів={self.floors}")
    
    def __repr__(self) -> str:
        """
        Повертає формальне рядкове представлення об'єкта House.
        
        Повертає:
            str: Формальне представлення будинку
        """
        return f"House(address='{self.address}', area={self.area}, floors={self.floors})"

