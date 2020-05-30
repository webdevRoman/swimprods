package ru.rgrabelnikov.swimprods.service;

import org.springframework.stereotype.Service;
import ru.rgrabelnikov.swimprods.service.Decorator.HandsDecorator2;
import ru.rgrabelnikov.swimprods.service.Decorator.HandsDecorator3;
import ru.rgrabelnikov.swimprods.service.Decorator.LegsDecorator2;
import ru.rgrabelnikov.swimprods.service.Decorator.LegsDecorator3;
import ru.rgrabelnikov.swimprods.service.Factory.BigFactory;
import ru.rgrabelnikov.swimprods.service.Factory.SmallFactory;
import ru.rgrabelnikov.swimprods.service.Products.*;

import static java.lang.Thread.sleep;

@Service
public class Manufacturer implements Runnable {
  private boolean isStarted;
  private int producedProductsNumber;
  private Warehouse warehouse;
  private boolean isProducing;

  public Manufacturer(Warehouse warehouse) {
    this.isStarted = false;
    this.producedProductsNumber = 0;
    this.warehouse = warehouse;
    this.isProducing = false;
  }

  public boolean isStarted() { return isStarted; }
  public void setStarted(boolean started) {isStarted = started; }

  public void produce() {
    this.isProducing = true;
  }

  @Override
  public void run() {
    try {
      this.isStarted = true;
      while (true)
        if (isProducing && this.warehouse.hasSpace()) {
          sleep(500);
          SwimmingProduct product = this.produceProduct();
          this.warehouse.add(product);
          this.warehouse.setNewProduct(product);
          System.out.println("[Произведен продукт: " + product.getName() + " (" + product.getManufacturer() + ")]");
//          System.out.println(product.getPrice());
          this.producedProductsNumber++;
          this.isProducing = false;
        }
    } catch (InterruptedException ex) {
      System.out.println("Manufacturer thread was interrupted:");
      System.out.println(ex.getMessage());
    }
  }
  //  Абстрактная фабрика используется при производстве лопаток (case 4) и ласт (case 6)
  private SwimmingProduct produceProduct() {
    int productType = ProductsData.RAND.nextInt(7);
    SwimmingProduct product;
    String[] prodColors = {ProductsData.COLORS[ProductsData.RAND.nextInt(9)]};
    int prodPrice = (ProductsData.RAND.nextInt(1000) + 1) * 10;
    String prodManufacturer = ProductsData.MANUFACTURERS[ProductsData.RAND.nextInt(4)];
    switch (productType) {
      case 0:
        product = new Swimsuit(ProductsData.SWIMSUIT_NAMES[ProductsData.RAND.nextInt(2)], prodPrice, prodColors, prodManufacturer, ProductsData.GENDERS[ProductsData.RAND.nextInt(2)], ProductsData.RAND.nextInt(20) + 30);
        break;
      case 1:
        product = new SwimGoggles(ProductsData.SWIMGOGGLES_NAMES[ProductsData.RAND.nextInt(2)], prodPrice, prodColors, prodManufacturer, ProductsData.GENDERS[ProductsData.RAND.nextInt(2)], ProductsData.GOGGLES_TYPES[ProductsData.RAND.nextInt(1)]);
        break;
      case 2:
        product = new SwimCap(ProductsData.SWIMCAP_NAMES[ProductsData.RAND.nextInt(2)], prodPrice, prodColors, prodManufacturer, ProductsData.GENDERS[ProductsData.RAND.nextInt(2)], ProductsData.CAP_MATERIALS[ProductsData.RAND.nextInt(1)]);
        break;
      case 3:
        product = new PullFloat(ProductsData.PULLFLOAT_NAMES[ProductsData.RAND.nextInt(2)], prodPrice, prodColors, prodManufacturer, "Тренировка рук", ProductsData.FORMS[ProductsData.RAND.nextInt(1)]);
        product = new HandsDecorator2((PullFloat) product);
        break;
      case 4:
        boolean paddlesSmall = ProductsData.RAND.nextBoolean();
        if (paddlesSmall) {
          SmallFactory sf = new SmallFactory();
          product = sf.producePaddles(ProductsData.PADDLES_NAMES[ProductsData.RAND.nextInt(2)], prodPrice, prodColors, prodManufacturer, "Тренировка рук", "Плоские");
          product = new HandsDecorator2((Paddles) product);
        } else {
          BigFactory bf = new BigFactory();
          product = bf.producePaddles(ProductsData.PADDLES_NAMES[ProductsData.RAND.nextInt(2)], prodPrice, prodColors, prodManufacturer, "Тренировка рук", "Под форму руки");
          product = new HandsDecorator3((Paddles) product);
        }
        break;
      case 5:
        product = new Kickboard(ProductsData.KICKBOARD_NAMES[ProductsData.RAND.nextInt(2)], prodPrice, prodColors, prodManufacturer, "Тренировка ног", ProductsData.FORMS[ProductsData.RAND.nextInt(1)]);
        product = new LegsDecorator2((Kickboard) product);
        break;
      case 6:
        boolean finsSmall = ProductsData.RAND.nextBoolean();
        if (finsSmall) {
          SmallFactory sf = new SmallFactory();
          product = sf.produceFins(ProductsData.FINS_NAMES[ProductsData.RAND.nextInt(2)], prodPrice, prodColors, prodManufacturer, "Тренировка ног", ProductsData.SIZES[ProductsData.RAND.nextInt(4)]);
          product = new LegsDecorator2((Fins) product);
        } else {
          BigFactory bf = new BigFactory();
          product = bf.produceFins(ProductsData.FINS_NAMES[ProductsData.RAND.nextInt(2)], prodPrice, prodColors, prodManufacturer, "Тренировка ног", ProductsData.SIZES[ProductsData.RAND.nextInt(4)]);
          product = new LegsDecorator3((Fins) product);
        }
        break;
      default:
        product = new SwimmingProduct("Продукт для занятий плаванием", prodPrice, prodColors, prodManufacturer);
        break;
    }
    return product;
  }
}
