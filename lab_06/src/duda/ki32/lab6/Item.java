package duda.ki32.lab6;

/**
* Клас Item представляє базовий предмет, що може зберігатися в пеналі.
* Має основні властивості: назву, вагу та ціну.
*/
class Item implements Comparable<Item> {
   private String name;
   private double weight;
   private double price;

   /**
    * Конструктор для створення предмету.
    * @param name назва предмету
    * @param weight вага предмету в грамах
    * @param price ціна предмету в гривнях
    */
   public Item(String name, double weight, double price) {
       this.name = name;
       this.weight = weight;
       this.price = price;
   }

   public String getName() {
       return name;
   }

   public double getWeight() {
       return weight;
   }

   public double getPrice() {
       return price;
   }

   @Override
   public int compareTo(Item other) {
       return Double.compare(this.price, other.price);
   }

   @Override
   public String toString() {
       return String.format("%s (вага: %.1fг, ціна: %.2f грн)", name, weight, price);
   }
}