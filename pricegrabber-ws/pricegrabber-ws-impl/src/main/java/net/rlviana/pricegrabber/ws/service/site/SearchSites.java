
package net.rlviana.pricegrabber.ws.service.site;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import net.rlviana.pricegrabber.domain.search.core.SiteSearchCriteria;


/**
 * <p>Clase Java para searchSite complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="searchSite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="criteria" type="{http://pricegrabber.rlviana.net/domain/search/core}site-search-criteria" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchSite", propOrder = {
    "criteria"
})
@XmlRootElement(name = "searchSites")
public class SearchSites
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected SiteSearchCriteria criteria;

    /**
     * Obtiene el valor de la propiedad criteria.
     * 
     * @return
     *     possible object is
     *     {@link SiteSearchCriteria }
     *     
     */
    public SiteSearchCriteria getCriteria() {
        return criteria;
    }

    /**
     * Define el valor de la propiedad criteria.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteSearchCriteria }
     *     
     */
    public void setCriteria(SiteSearchCriteria value) {
        this.criteria = value;
    }

}
