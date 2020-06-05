package ru.rgrabelnikov.swimprods.service.Products;

// Одежда для плавания
public class Swimwear extends SwimmingProduct {

  public Swimwear() {}
  public Swimwear(String name, int price, String[] colors, String manufacturer, String gender) {
    super(name, price, manufacturer);
    this.colors = colors;
    this.gender = gender;
  }

  protected String[] colors;
  //  Пол
  protected String gender;

  public String[] getColors() { return colors; }
  public void setColors(String[] colors) { this.colors = colors; }
  public String getGender() { return gender; }
  public void setGender(String gender) { this.gender = gender; }

  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Цвета: " + String.join(", ", this.colors) + "\nПол: " + this.gender);
  }

}