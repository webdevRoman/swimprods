package ru.rgrabelnikov.swimprods.service.Factory;

import ru.rgrabelnikov.swimprods.service.Products.Fins;
import ru.rgrabelnikov.swimprods.service.Products.Paddles;
import ru.rgrabelnikov.swimprods.service.Products.SmallFins;
import ru.rgrabelnikov.swimprods.service.Products.SmallPaddles;

public class SmallFactory implements AbstractFactory {
  @Override
  public Paddles producePaddles(String name, int price, String[] colors, String manufacturer, String purpose, String form) {
    return new SmallPaddles(name, price, colors, manufacturer, purpose, form);
  }
  @Override
  public Fins produceFins(String name, int price, String[] colors, String manufacturer, String purpose, String size) {
    return new SmallFins(name, price, colors, manufacturer, purpose, size);
  }
}
