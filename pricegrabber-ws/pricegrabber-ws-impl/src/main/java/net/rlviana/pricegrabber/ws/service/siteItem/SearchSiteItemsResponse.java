
package net.rlviana.pricegrabber.ws.service.siteItem;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import net.rlviana.pricegrabber.domain.response.core.SiteItemFindResponse;


/**
 * <p>Clase Java para searchSiteItemResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="searchSiteItemResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://pricegrabber.rlviana.net/domain/response/core}site-item-find-response" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchSiteItemResponse", propOrder = {
    "_return"
})
@XmlRootElement(name = "searchSiteItemsResponse")
public class SearchSiteItemsResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "return")
    protected SiteItemFindResponse _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link SiteItemFindResponse }
     *     
     */
    public SiteItemFindResponse getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteItemFindResponse }
     *     
     */
    public void setReturn(SiteItemFindResponse value) {
        this._return = value;
    }

}
