package ru.rgrabelnikov.swimprods.service.Products;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class SwimmingProduct {

  public SwimmingProduct() {}
  public SwimmingProduct(String name, int price, String manufacturer) {
    this.name = name;
    this.price = price;
    this.manufacturer = manufacturer;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long id;
  protected String name;
  protected int price;
  protected String manufacturer;

  public Long getId() { return id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getPrice() { return price; }
  public void setPrice(int price) { this.price = price; }
  public String getManufacturer() { return manufacturer; }
  public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

  public void showInfo() {
    System.out.println("Информация о товаре " + this.name + ":\nЦена: " + this.price + "\nПроизводитель: " + this.manufacturer);
  }

  public String train() {
    return "Тренируемся...";
  }

}