
package net.rlviana.pricegrabber.ws.service.siteItem;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import net.rlviana.pricegrabber.domain.entity.core.SiteItem;


/**
 * <p>Clase Java para updateSiteItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="updateSiteItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="siteItem" type="{http://pricegrabber.rlviana.net/domain/entity/core}site-item" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateSiteItem", propOrder = {
    "siteItem"
})
@XmlRootElement(name = "updateSiteItem")
public class UpdateSiteItem
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected SiteItem siteItem;

    /**
     * Obtiene el valor de la propiedad siteItem.
     * 
     * @return
     *     possible object is
     *     {@link SiteItem }
     *     
     */
    public SiteItem getSiteItem() {
        return siteItem;
    }

    /**
     * Define el valor de la propiedad siteItem.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteItem }
     *     
     */
    public void setSiteItem(SiteItem value) {
        this.siteItem = value;
    }

}
