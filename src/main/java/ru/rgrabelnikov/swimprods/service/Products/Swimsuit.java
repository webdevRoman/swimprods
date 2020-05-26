package ru.rgrabelnikov.swimprods.service.Products;

// Купальник
public class Swimsuit extends Swimwear {

  public Swimsuit() {}
  public Swimsuit(String name, int price, String[] colors, String manufacturer, String gender, int size) {
    super(name, price, colors, manufacturer, gender);
    this.size = size;
  }

  private int size;

  public int getSize() { return size; }
  public void setSize(int size) { this.size = size; }

  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Размер: " + this.size + "\n");
  }

}