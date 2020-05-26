package ru.rgrabelnikov.swimprods.service.Products;

public abstract class Paddles extends SwimmingEquipment {

  public Paddles() {}
  public Paddles(String name, int price, String[] colors, String manufacturer, String purpose, String form) {
    super(name, price, colors, manufacturer, purpose);
    this.form = form;
  }

  protected String form;
  public String getForm() { return form; }
  public void setForm(String form) { this.form = form; }

  @Override
  public void showInfo() {
    super.showInfo();
    System.out.println("Форма: " + this.form + "\n");
  }

}