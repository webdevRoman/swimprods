package ru.rgrabelnikov.swimprods.service;

import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;

import static java.lang.Thread.sleep;

public class Customer implements Runnable {
  private int consumedProductsNumber;
  private Warehouse warehouse;

  public Customer(Warehouse warehouse) {
    this.consumedProductsNumber = 0;
    this.warehouse = warehouse;
  }
  @Override
  public void run() {
    try {
//      while (this.consumedProductsNumber < this.productsNumber) {
        if (!this.warehouse.isEmpty()) {
          sleep(1000);
          SwimmingProduct product = this.warehouse.remove();
          System.out.println("[Потреблен продукт: " + product.getName() + " (" + product.getManufacturer() + ")]: " + product.train());
          this.consumedProductsNumber++;
        }
//      }
    } catch (InterruptedException ex) {
      System.out.println("Customer thread was interrupted:");
      System.out.println(ex.getMessage());
    }
  }
}
