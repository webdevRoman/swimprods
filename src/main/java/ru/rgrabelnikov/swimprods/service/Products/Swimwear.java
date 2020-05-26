package ru.rgrabelnikov.swimprods.service.Products;

// Одежда для плавания
public class Swimwear extends SwimmingProduct {

  public Swimwear() {}
  public Swimwear(String name, int price, String[] colors, String manufacturer, String gender) {
    super(name, price, colors, manufacturer);
    this.gender = gender;
  }

  //  Пол
  protected String gender;

  public String getGender() { return gender; }
  public void setGender(String gender) { this.gender = gender; }

  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Пол: " + this.gender);
  }

}