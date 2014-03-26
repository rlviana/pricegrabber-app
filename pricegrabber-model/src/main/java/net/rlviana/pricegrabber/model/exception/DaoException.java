/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.exception;

/**
 * Superclass for data related exceptions
 * 
 * @author ramon
 */
public class DaoException extends Exception {

  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor
   * 
   * @param message
   */
  public DaoException(final String message) {
    super(message);
  }

  /**
   * Constructor
   * 
   * @param cause
   */
  public DaoException(final Throwable cause) {
    super(cause);
  }

  /**
   * Constructor
   * 
   * @param message
   * @param cause
   */
  public DaoException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructor
   * 
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public DaoException(final String message, final Throwable cause, final boolean enableSuppression,
      final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
