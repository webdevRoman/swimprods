package ru.rgrabelnikov.swimprods.service.Products;

// Инвентарь для плавания
public class SwimmingEquipment extends SwimmingProduct {

  public SwimmingEquipment() {}
  public SwimmingEquipment(String name, int price, String[] colors, String manufacturer, String purpose) {
    super(name, price, colors, manufacturer);
    this.purpose = purpose;
  }

  //  Назначение
  protected String purpose;

  public String getPurpose() { return purpose; }
  public void setPurpose(String purpose) { this.purpose = purpose; }

  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Назначение: " + this.purpose);
  }

}