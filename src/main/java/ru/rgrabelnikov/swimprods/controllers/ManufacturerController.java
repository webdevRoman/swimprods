package ru.rgrabelnikov.swimprods.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rgrabelnikov.swimprods.service.Manufacturer;
import ru.rgrabelnikov.swimprods.service.Warehouse;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {
  @Autowired
  private Warehouse warehouse;
  @Autowired
  private Manufacturer manufacturer;

  @PostMapping
  public String create() {
    if (this.warehouse.hasSpace()) {
      manufacturer.produce();
      return "success";
    } else {
      return "no space";
    }
  }
}
