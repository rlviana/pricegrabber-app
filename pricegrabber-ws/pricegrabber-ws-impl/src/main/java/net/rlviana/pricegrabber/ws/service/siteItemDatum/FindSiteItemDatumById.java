
package net.rlviana.pricegrabber.ws.service.siteItemDatum;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para findSiteItemDatumById complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="findSiteItemDatumById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="siteItemDatumId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findSiteItemDatumById", propOrder = {
    "siteItemDatumId"
})
@XmlRootElement(name = "findSiteItemDatumById")
public class FindSiteItemDatumById
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Long siteItemDatumId;

    /**
     * Obtiene el valor de la propiedad siteItemDatumId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSiteItemDatumId() {
        return siteItemDatumId;
    }

    /**
     * Define el valor de la propiedad siteItemDatumId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSiteItemDatumId(Long value) {
        this.siteItemDatumId = value;
    }

}
