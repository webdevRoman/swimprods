package ru.rgrabelnikov.swimprods.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {
  @GetMapping
  public String showInfo() {
    return "Hello World!";
  }
}
