package ru.rgrabelnikov.swimprods.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rgrabelnikov.swimprods.repo.SwimmingProductRepo;
import ru.rgrabelnikov.swimprods.service.Customer;
import ru.rgrabelnikov.swimprods.service.Manufacturer;
import ru.rgrabelnikov.swimprods.service.Warehouse;

@Controller
@RequestMapping("/")
public class MainController {
  @Value("${spring.profiles.active:prod}")
  private String profile;

  private final SwimmingProductRepo swimmingProductRepo;

  private final Manufacturer manufacturer;
  private final Customer customer;
  private final Warehouse warehouse;
//  @Autowired
//  private Manufacturer manufacturer;
//  @Autowired
//  private Customer customer;
//  @Autowired
//  private Warehouse warehouse;

  @Autowired
  public MainController(SwimmingProductRepo swimmingProductRepo, Manufacturer manufacturer, Customer customer, Warehouse warehouse) {
    this.swimmingProductRepo = swimmingProductRepo;
    this.manufacturer = manufacturer;
    this.customer = customer;
    this.warehouse = warehouse;

    this.warehouse.setProducts(this.swimmingProductRepo.findAll());
  }

  @GetMapping
  public String main(Model model) {
    model.addAttribute("isDevMode", "dev".equals(profile));

    if (!manufacturer.isStarted()) {
      Thread manufacturerThread = new Thread(manufacturer);
      manufacturerThread.start();
    }
    if (!customer.isStarted()) {
      Thread customerThread = new Thread(customer);
      customerThread.start();
    }

    return "index";
  }
}
