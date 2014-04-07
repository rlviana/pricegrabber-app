package net.rlviana.pricegrabber.domain.response;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Abstract response.
 * 
 * @author ramon
 */
@XmlTransient
public abstract class AbstractResponse implements IResponse {

  /**
   * 
   * Constructor
   */
  protected AbstractResponse() {
    // Does nothing
  }

}
