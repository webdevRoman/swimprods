package ru.rgrabelnikov.swimprods.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rgrabelnikov.swimprods.service.Customer;
import ru.rgrabelnikov.swimprods.service.Manufacturer;
import ru.rgrabelnikov.swimprods.service.Warehouse;

@RestController
@RequestMapping("customer")
public class CustomerController {
  @Autowired
  private Warehouse warehouse;
  @Autowired
  private Customer customer;

  @PostMapping
  public String consume() {
    if (!this.warehouse.isEmpty()) {
      customer.consume();
      return "success";
    } else {
      return "empty";
    }
  }
}
