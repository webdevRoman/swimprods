package ru.rgrabelnikov.swimprods.service;

import org.springframework.stereotype.Service;
import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Warehouse {
  private int maxProductsNumber;
  private AtomicInteger productsNumber;
  private ArrayList<SwimmingProduct> products;

  public Warehouse() {
    this.maxProductsNumber = 10;
    this.productsNumber = new AtomicInteger(0);
    this.products = new ArrayList<SwimmingProduct>();
  }

  public void add(SwimmingProduct product) {
    this.products.add(product);
    this.productsNumber.getAndIncrement();
  }
  public SwimmingProduct remove() {
    SwimmingProduct product = this.products.remove(0);
    this.productsNumber.getAndDecrement();
    return product;
  }

  public boolean hasSpace() {
    if (this.productsNumber.get() < this.maxProductsNumber)
      return true;
    else
      return false;
  }
  public boolean isEmpty() {
    if (this.productsNumber.get() <= 0)
      return true;
    else
      return false;
  }
}
