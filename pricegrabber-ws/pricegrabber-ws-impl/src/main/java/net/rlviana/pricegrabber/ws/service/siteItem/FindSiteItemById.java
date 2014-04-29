
package net.rlviana.pricegrabber.ws.service.siteItem;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para findSiteItemById complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="findSiteItemById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="siteItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findSiteItemById", propOrder = {
    "siteItemId"
})
@XmlRootElement(name = "findSiteItemById")
public class FindSiteItemById
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Long siteItemId;

    /**
     * Obtiene el valor de la propiedad siteItemId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSiteItemId() {
        return siteItemId;
    }

    /**
     * Define el valor de la propiedad siteItemId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSiteItemId(Long value) {
        this.siteItemId = value;
    }

}
