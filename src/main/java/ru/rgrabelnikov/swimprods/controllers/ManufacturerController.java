package ru.rgrabelnikov.swimprods.controllers;

import org.springframework.web.bind.annotation.*;
import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {
  @PostMapping
  public String create(@RequestBody String message) {
    System.out.println(message);
    return "Hello world back!";
  }
}
