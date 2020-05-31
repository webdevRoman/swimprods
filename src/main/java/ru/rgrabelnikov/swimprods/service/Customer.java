package ru.rgrabelnikov.swimprods.service;

import org.springframework.stereotype.Service;
import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;

import static java.lang.Thread.sleep;

@Service
public class Customer implements Runnable {
  private boolean isStarted;
  private int consumedProductsNumber;
  private Warehouse warehouse;
  private boolean isConsuming;

  public Customer(Warehouse warehouse) {
    this.isStarted = false;
    this.consumedProductsNumber = 0;
    this.warehouse = warehouse;
  }

  public boolean isStarted() { return isStarted; }

  public void consume() {
    this.isConsuming = true;
  }

  @Override
  public void run() {
    try {
      this.isStarted = true;
      while(true)
        if (isConsuming && !this.warehouse.isEmpty()) {
          sleep(1000);
          SwimmingProduct product = this.warehouse.remove();
          this.warehouse.setConsumedProduct(product);
//          System.out.println("[Потреблен продукт: " + product.getName() + " (" + product.getManufacturer() + ")]: " + product.train());
          this.consumedProductsNumber++;
          this.isConsuming = false;
        }
    } catch (InterruptedException ex) {
      System.out.println("Customer thread was interrupted:");
      System.out.println(ex.getMessage());
    }
  }
}
