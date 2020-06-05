package ru.rgrabelnikov.swimprods.service;

import org.springframework.stereotype.Service;
import ru.rgrabelnikov.swimprods.repo.SwimmingProductRepo;
import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Warehouse {
  private int maxProductsNumber;
  private AtomicInteger productsNumber;
  private List<SwimmingProduct> products;
  private SwimmingProduct producedProduct;
  private SwimmingProduct consumedProduct;

  private final SwimmingProductRepo swimmingProductRepo;

  public Warehouse(SwimmingProductRepo swimmingProductRepo) {
    this.swimmingProductRepo = swimmingProductRepo;
    this.maxProductsNumber = 15;
    this.productsNumber = new AtomicInteger(0);
  }

  public void add(SwimmingProduct product) {
    this.products.add(product);
    swimmingProductRepo.save(new SwimmingProduct(product.getName(), product.getPrice(), product.getManufacturer()));
    this.productsNumber.getAndIncrement();
  }
  public SwimmingProduct remove() {
    SwimmingProduct product = this.products.remove(0);
    swimmingProductRepo.deleteById(product.getId());
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

  public SwimmingProduct getProducedProduct() { return producedProduct; }
  public void setProducedProduct(SwimmingProduct producedProduct) { this.producedProduct = producedProduct; }
  public void resetProducedProduct() { this.producedProduct = null; }

  public SwimmingProduct getConsumedProduct() { return consumedProduct; }
  public void setConsumedProduct(SwimmingProduct consumedProduct) { this.consumedProduct = consumedProduct; }
  public void resetConsumedProduct() { this.consumedProduct = null; }

  public void setProducts(List<SwimmingProduct> products) {
    this.products = products;
    this.productsNumber.set(products.size());
  }
  public List<SwimmingProduct> getProducts() { return products; }
}
