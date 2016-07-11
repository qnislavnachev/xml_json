package com.clouway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)

public class Product {

  private Integer id;

  private String productName;

  private Double productPrice;

  public Product() {
  }


  public Product(Integer id, String productName, Double productPrice) {
    this.id = id;
    this.productName = productName;
    this.productPrice = productPrice;
  }

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", productName='" + productName + '\'' +
            ", productPrice=" + productPrice +
            '}';
  }
}
