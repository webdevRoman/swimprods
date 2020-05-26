package ru.rgrabelnikov.swimprods.service.Products;

public class SwimGoggles extends Swimwear {

  public SwimGoggles() {}
  public SwimGoggles(String name, int price, String[] colors, String manufacturer, String gender, String type) {
    super(name, price, colors, manufacturer, gender);
    this.type = type;
  }

  //  Тип (стартовые, тренировочные)
  private String type;

  public String getType() { return type; }
  public void setType(String type) { this.type = type; }

  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Тип: " + this.type + "\n");
  }

}