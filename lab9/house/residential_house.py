from .house import House


class ResidentialHouse(House):
    """
    Похідний клас ResidentialHouse розширює базовий клас House,
    додаючи властивості, специфічні для житлових будинків.
    
    Атрибути:
        rooms (int): Кількість кімнат у будинку
        residents (int): Кількість мешканців
    """
    
    def __init__(self, address: str = "", area: float = 0.0, floors: int = 1,
                 rooms: int = 0, residents: int = 0):
        """
        Конструктор класу ResidentialHouse.
        
        Аргументи:
            address (str): Адреса будинку
            area (float): Площа будинку в квадратних метрах
            floors (int): Кількість поверхів будинку
            rooms (int): Кількість кімнат у будинку
            residents (int): Кількість мешканців
        """
        super().__init__(address, area, floors)
        self.rooms = rooms
        self.residents = residents
    
    def get_rooms(self) -> int:
        """
        Повертає кількість кімнат у будинку.
        
        Повертає:
            int: Кількість кімнат
        """
        return self.rooms
    
    def get_residents(self) -> int:
        """
        Повертає кількість мешканців будинку.
        
        Повертає:
            int: Кількість мешканців
        """
        return self.residents
    
    def set_rooms(self, rooms: int) -> None:
        """
        Встановлює кількість кімнат у будинку.
        
        Аргументи:
            rooms (int): Нова кількість кімнат
        """
        if rooms >= 0:
            self.rooms = rooms
        else:
            raise ValueError("Кількість кімнат не може бути від'ємною")
    
    def set_residents(self, residents: int) -> None:
        """
        Встановлює кількість мешканців будинку.
        
        Аргументи:
            residents (int): Нова кількість мешканців
        """
        if residents >= 0:
            self.residents = residents
        else:
            raise ValueError("Кількість мешканців не може бути від'ємною")
    
    def calculate_area_per_room(self) -> float:
        """
        Обчислює площу на одну кімнату.
        
        Повертає:
            float: Площа на одну кімнату в квадратних метрах
        """
        if self.rooms > 0:
            return self.area / self.rooms
        return 0.0
    
    def calculate_area_per_resident(self) -> float:
        """
        Обчислює площу на одного мешканця.
        
        Повертає:
            float: Площа на одного мешканця в квадратних метрах
        """
        if self.residents > 0:
            return self.area / self.residents
        return 0.0
    
    def get_resident_density(self) -> float:
        """
        Обчислює щільність населення (кількість мешканців на 100 м²).
        
        Повертає:
            float: Щільність населення
        """
        if self.area > 0:
            return (self.residents / self.area) * 100
        return 0.0
    
    def __str__(self) -> str:
        """
        Повертає рядкове представлення об'єкта ResidentialHouse.
        
        Повертає:
            str: Рядкове представлення житлового будинку
        """
        return (f"Житловий будинок: адреса='{self.address}', "
                f"площа={self.area} м², поверхів={self.floors}, "
                f"кімнат={self.rooms}, мешканців={self.residents}")
    
    def __repr__(self) -> str:
        """
        Повертає формальне рядкове представлення об'єкта ResidentialHouse.
        
        Повертає:
            str: Формальне представлення житлового будинку
        """
        return (f"ResidentialHouse(address='{self.address}', area={self.area}, "
                f"floors={self.floors}, rooms={self.rooms}, residents={self.residents})")

