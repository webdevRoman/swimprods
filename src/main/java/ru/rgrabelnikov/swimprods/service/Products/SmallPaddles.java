package ru.rgrabelnikov.swimprods.service.Products;

public class SmallPaddles extends Paddles {
  public SmallPaddles(String name, int price, String[] colors, String manufacturer, String purpose, String form) {
    super(name, price, colors, manufacturer, purpose, form);
  }
  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Маленькие: Да" + "\n");
  }
}
