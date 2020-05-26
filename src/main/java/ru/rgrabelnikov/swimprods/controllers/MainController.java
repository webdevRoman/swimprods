package ru.rgrabelnikov.swimprods.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rgrabelnikov.swimprods.service.Customer;
import ru.rgrabelnikov.swimprods.service.Manufacturer;
import ru.rgrabelnikov.swimprods.service.Warehouse;

@Controller
@RequestMapping("/")
public class MainController {
  @Value("${spring.profiles.active:prod}")
  private String profile;

  @GetMapping
  public String main(Model model) {
    model.addAttribute("isDevMode", "dev".equals(profile));

    int warehouseCapacity = 10;
    Warehouse warehouse = new Warehouse(warehouseCapacity);
    Thread manufacturer = new Thread(new Manufacturer(warehouse));
    Thread customer = new Thread(new Customer(warehouse));
//    manufacturer.start();
//    customer.start();

    return "index";
  }
}
