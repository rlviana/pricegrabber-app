package net.rlviana.pricegrabber.ws.service.item;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import net.rlviana.pricegrabber.domain.entity.core.Item;

@XmlRootElement(name = "createItem", namespace = "http://pricegrabber.rlviana.net/ws/service/item")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createItem", namespace = "http://pricegrabber.rlviana.net/ws/service/item")
public class CreateItem {

  @XmlElement(name = "item", namespace = "http://pricegrabber.rlviana.net/ws/service/item")
  private Item item;

  /**
   * 
   * @return
   *         returns Item
   */
  public Item getItem() {
    return this.item;
  }

  /**
   * 
   * @param item
   *          the value for the item property
   */
  public void setItem(Item item) {
    this.item = item;
  }

}
