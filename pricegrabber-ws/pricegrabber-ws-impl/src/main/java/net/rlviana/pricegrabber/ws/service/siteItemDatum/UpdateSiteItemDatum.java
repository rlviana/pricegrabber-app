
package net.rlviana.pricegrabber.ws.service.siteItemDatum;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum;


/**
 * <p>Clase Java para updateSiteItemDatum complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="updateSiteItemDatum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="siteItemDatum" type="{http://pricegrabber.rlviana.net/domain/entity/core}site-item-datum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateSiteItemDatum", propOrder = {
    "siteItemDatum"
})
@XmlRootElement(name = "updateSiteItemDatum")
public class UpdateSiteItemDatum
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected SiteItemDatum siteItemDatum;

    /**
     * Obtiene el valor de la propiedad siteItemDatum.
     * 
     * @return
     *     possible object is
     *     {@link SiteItemDatum }
     *     
     */
    public SiteItemDatum getSiteItemDatum() {
        return siteItemDatum;
    }

    /**
     * Define el valor de la propiedad siteItemDatum.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteItemDatum }
     *     
     */
    public void setSiteItemDatum(SiteItemDatum value) {
        this.siteItemDatum = value;
    }

}
