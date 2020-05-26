package ru.rgrabelnikov.swimprods.service.Decorator;

import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;

public class Decorator extends SwimmingProduct {
  protected SwimmingProduct swimmingProduct;
  public Decorator(SwimmingProduct swimmingProduct) {
    this.swimmingProduct = swimmingProduct;
  }

  @Override
  public String train() {
    return this.swimmingProduct.train();
  }
  @Override
  public String getName() {
    return this.swimmingProduct.getName();
  }
  @Override
  public String getManufacturer() { return this.swimmingProduct.getManufacturer(); }
}