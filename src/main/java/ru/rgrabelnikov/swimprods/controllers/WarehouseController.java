package ru.rgrabelnikov.swimprods.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;
import ru.rgrabelnikov.swimprods.service.Warehouse;

import java.util.ArrayList;

@RestController
@RequestMapping("warehouse")
public class WarehouseController {
  @Autowired
  private Warehouse warehouse;

  @GetMapping()
  public ArrayList<SwimmingProduct> sendProducts() {
    return this.warehouse.getProducts();
  }

  @GetMapping("/produced")
  public SwimmingProduct checkNewProduct() {
    SwimmingProduct producedProduct = this.warehouse.getProducedProduct();
    this.warehouse.resetProducedProduct();
    return producedProduct;
  }
  @GetMapping("/consumed")
  public SwimmingProduct checkConsumedProduct() {
    SwimmingProduct consumedProduct = this.warehouse.getConsumedProduct();
    this.warehouse.resetConsumedProduct();
    return consumedProduct;
  }
}
