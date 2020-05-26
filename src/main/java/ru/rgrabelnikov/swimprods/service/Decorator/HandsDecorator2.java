package ru.rgrabelnikov.swimprods.service.Decorator;

import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;

public class HandsDecorator2 extends Decorator {
  public HandsDecorator2(SwimmingProduct swimmingProduct) { super(swimmingProduct); }

  @Override
  public String train() {
    return super.train() + "(Эффективность тренировки рук повышена в 2 раза)";
  }
  @Override
  public String getName() {
    return this.swimmingProduct.getName();
  }
  @Override
  public String getManufacturer() { return this.swimmingProduct.getManufacturer(); }
}
