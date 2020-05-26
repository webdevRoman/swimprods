package ru.rgrabelnikov.swimprods.service.Products;

public class BigPaddles extends Paddles {
  public BigPaddles(String name, int price, String[] colors, String manufacturer, String purpose, String form) {
    super(name, price, colors, manufacturer, purpose, form);
  }
  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Маленькие: Нет" + "\n");
  }
}
