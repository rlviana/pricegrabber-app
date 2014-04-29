
package net.rlviana.pricegrabber.ws.service.siteItemDatum;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import net.rlviana.pricegrabber.domain.search.core.SiteItemDatumSearchCriteria;


/**
 * <p>Clase Java para listSiteItemData complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listSiteItemData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="criteria" type="{http://pricegrabber.rlviana.net/domain/search/core}site-item-datum-search-criteria" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listSiteItemData", propOrder = {
    "criteria"
})
@XmlRootElement(name = "listSiteItemData")
public class ListSiteItemData
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected SiteItemDatumSearchCriteria criteria;

    /**
     * Obtiene el valor de la propiedad criteria.
     * 
     * @return
     *     possible object is
     *     {@link SiteItemDatumSearchCriteria }
     *     
     */
    public SiteItemDatumSearchCriteria getCriteria() {
        return criteria;
    }

    /**
     * Define el valor de la propiedad criteria.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteItemDatumSearchCriteria }
     *     
     */
    public void setCriteria(SiteItemDatumSearchCriteria value) {
        this.criteria = value;
    }

}
