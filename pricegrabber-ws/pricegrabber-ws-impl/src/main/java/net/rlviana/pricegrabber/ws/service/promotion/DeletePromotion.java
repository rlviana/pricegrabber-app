
package net.rlviana.pricegrabber.ws.service.promotion;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para deletePromotion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="deletePromotion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="promotionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deletePromotion", propOrder = {
    "promotionId"
})
@XmlRootElement(name = "deletePromotion")
public class DeletePromotion
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Long promotionId;

    /**
     * Obtiene el valor de la propiedad promotionId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPromotionId() {
        return promotionId;
    }

    /**
     * Define el valor de la propiedad promotionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPromotionId(Long value) {
        this.promotionId = value;
    }

}
