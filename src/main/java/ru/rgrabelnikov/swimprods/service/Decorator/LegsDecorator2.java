package ru.rgrabelnikov.swimprods.service.Decorator;

import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;

public class LegsDecorator2 extends Decorator {
  public LegsDecorator2(SwimmingProduct swimmingProduct) { super(swimmingProduct); }

  @Override
  public String train() {
    return super.train() + "(Эффективность тренировки ног повышена в 2 раза)";
  }
  @Override
  public String getName() {
    return this.swimmingProduct.getName();
  }
  @Override
  public String getManufacturer() { return this.swimmingProduct.getManufacturer(); }
}
