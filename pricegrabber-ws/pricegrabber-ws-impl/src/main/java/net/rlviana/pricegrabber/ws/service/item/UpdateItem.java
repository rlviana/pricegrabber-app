package net.rlviana.pricegrabber.ws.service.item;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import net.rlviana.pricegrabber.domain.entity.core.Item;

/**
 * 
 * <pre>
 * &lt;complexType name="updateItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{http://pricegrabber.rlviana.net/domain/entity/core}item" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateItem", propOrder = {
    "item"
})
@XmlRootElement(name = "updateItem")
public class UpdateItem
    implements Serializable
{

  private final static long serialVersionUID = 1L;
  protected Item item;

  /**
   * Obtiene el valor de la propiedad item.
   * 
   * @return
   *         possible object is {@link Item }
   * 
   */
  public Item getItem() {
    return item;
  }

  /**
   * Define el valor de la propiedad item.
   * 
   * @param value
   *          allowed object is {@link Item }
   * 
   */
  public void setItem(Item value) {
    this.item = value;
  }

}
