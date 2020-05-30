package ru.rgrabelnikov.swimprods.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rgrabelnikov.swimprods.service.Customer;
import ru.rgrabelnikov.swimprods.service.Manufacturer;

@Controller
@RequestMapping("/")
public class MainController {
  @Value("${spring.profiles.active:prod}")
  private String profile;

  @Autowired
  private Manufacturer manufacturer;
  @Autowired
  private Customer customer;

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
