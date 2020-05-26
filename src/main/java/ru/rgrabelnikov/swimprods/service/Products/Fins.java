package ru.rgrabelnikov.swimprods.service.Products;

public abstract class Fins extends SwimmingEquipment {

  public Fins() {}
  public Fins(String name, int price, String[] colors, String manufacturer, String purpose, String size) {
    super(name, price, colors, manufacturer, purpose);
    this.size = size;
  }

  protected String size;
  public String getSize() { return size; }
  public void setSize(String size) { this.size = size; }

  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Размер: " + this.size + "\n");
  }

}