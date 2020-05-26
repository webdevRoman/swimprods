package ru.rgrabelnikov.swimprods.service.Products;

public class SmallFins extends Fins {
  public SmallFins(String name, int price, String[] colors, String manufacturer, String purpose, String size) {
    super(name, price, colors, manufacturer, purpose, size);
  }
  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Короткие: Да" + "\n");
  }
}
