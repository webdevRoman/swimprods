package ru.rgrabelnikov.swimprods.service.Products;

public class BigFins extends Fins {
  public BigFins(String name, int price, String[] colors, String manufacturer, String purpose, String size) {
    super(name, price, colors, manufacturer, purpose, size);
  }
  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Короткие: Нет" + "\n");
  }
}
