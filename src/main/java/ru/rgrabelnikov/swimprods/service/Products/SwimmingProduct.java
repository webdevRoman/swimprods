package ru.rgrabelnikov.swimprods.service.Products;

public class SwimmingProduct {

  public SwimmingProduct() {}
  public SwimmingProduct(String name, int price, String[] colors, String manufacturer) {
    this.name = name;
    this.price = price;
    this.colors = colors;
    this.manufacturer = manufacturer;
  }

  protected String name;
  protected int price;
  protected String[] colors;
  protected String manufacturer;

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getPrice() { return price; }
  public void setPrice(int price) { this.price = price; }
  public String[] getColors() { return colors; }
  public void setColors(String[] colors) { this.colors = colors; }
  public String getManufacturer() { return manufacturer; }
  public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

  public void showInfo() {
    System.out.println("Информация о товаре " + this.name + ":\nЦена: " + this.price + "\nПроизводитель: " + this.manufacturer + "\nЦвета: " + String.join(", ", this.colors));
  }

  public String train() {
    return "Тренируемся...";
  }

}