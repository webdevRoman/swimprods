package ru.rgrabelnikov.swimprods.service.Factory;

import ru.rgrabelnikov.swimprods.service.Products.Fins;
import ru.rgrabelnikov.swimprods.service.Products.Paddles;

public interface AbstractFactory {
  public Paddles producePaddles(String name, int price, String[] colors, String manufacturer, String purpose, String form);
  public Fins produceFins(String name, int price, String[] colors, String manufacturer, String purpose, String size);
}
