package net.rlviana.pricegrabber.ws.service.exception;

import javax.xml.ws.WebFault;

/**
 * @author ramon
 * 
 */
@WebFault(name = "ServiceException", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/exception")
public class ServiceException extends Exception {

  /** * */
  private static final long serialVersionUID = -6647544772732631047L;
  private ServiceFault fault;

  /** * */
  public ServiceException() {
    // TODO Auto-generated constructor stub
  }

  /** * * @param fault */
  protected ServiceException(ServiceFault fault) {
    super(fault.getFaultString());
    this.fault = fault;
  }

  /** * * @param message * @param faultInfo */
  public ServiceException(String message, ServiceFault faultInfo) {
    super(message);
    this.fault = faultInfo;
  }

  /** * * @param message * @param faultInfo * @param cause */
  public ServiceException(String message, ServiceFault faultInfo, Throwable cause) {
    super(message, cause);
    this.fault = faultInfo;
  }

  /** * * @return */
  public ServiceFault getFaultInfo() {
    return fault;
  }

  /** * @param message */
  public ServiceException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

  /** * @param message */
  public ServiceException(String code, String message) {
    super(message);
    this.fault = new ServiceFault();
    this.fault.setFaultString(message);
    this.fault.setFaultCode(code);
  }

  /** * @param cause */
  public ServiceException(Throwable cause) {
    super(cause);
  }

  /**
   * // * @param message * @param cause
   */
  public ServiceException(String message, Throwable cause) {
    // super(message, cause); // TODO Auto-generated constructor stub
  }
}
