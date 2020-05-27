package ru.rgrabelnikov.swimprods.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rgrabelnikov.swimprods.service.Customer;
import ru.rgrabelnikov.swimprods.service.Manufacturer;
import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;
import ru.rgrabelnikov.swimprods.service.Warehouse;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {
  @Autowired
  private Manufacturer manufacturer;

  @PostMapping
  public String create() {
    manufacturer.produce();
    return "Producing a product!";
  }
}
