package com.clouway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListOfObjects {
  public ListOfObjects() {
  }

  @XmlElement(name = "product")
  private List<Object> objects = new LinkedList<Object>();

  public void add(Object object) {
    objects.add(object);
  }

  public Object getObject(Integer i) {
    return objects.get(i);
  }

  @Override
  public String toString() {
    return "ListOfObjects{" +
            "objects=" + objects +
            '}';
  }
}
