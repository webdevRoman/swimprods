package ru.rgrabelnikov.swimprods.service.Products;

// Инвентарь для плавания
public class SwimmingEquipment extends SwimmingProduct {

  public SwimmingEquipment() {}
  public SwimmingEquipment(String name, int price, String[] colors, String manufacturer, String purpose) {
    super(name, price, manufacturer);
    this.colors = colors;
    this.purpose = purpose;
  }

  protected String[] colors;
  //  Назначение
  protected String purpose;

  public String[] getColors() { return colors; }
  public void setColors(String[] colors) { this.colors = colors; }
  public String getPurpose() { return purpose; }
  public void setPurpose(String purpose) { this.purpose = purpose; }

  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Цвета: " + String.join(", ", this.colors) + "\nНазначение: " + this.purpose);
  }

}