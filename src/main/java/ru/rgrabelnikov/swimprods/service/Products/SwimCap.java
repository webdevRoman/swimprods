package ru.rgrabelnikov.swimprods.service.Products;

public class SwimCap extends Swimwear {

  public SwimCap() {}
  public SwimCap(String name, int price, String[] colors, String manufacturer, String gender, String material) {
    super(name, price, colors, manufacturer, gender);
    this.material = material;
  }

  private String material;

  public String getMaterial() { return material; }
  public void setMaterial(String material) { this.material = material; }

  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Материал: " + this.material + "\n");
  }

}