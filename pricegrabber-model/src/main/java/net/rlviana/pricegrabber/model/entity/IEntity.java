package net.rlviana.pricegrabber.model.entity;

import java.io.Serializable;

/**
 * Base interface for entities. <br/>
 * Also contains contants for size of fields in database
 * 
 * @param <T> Key type
 * @author ramon
 */
public interface IEntity<T extends Serializable> extends Serializable {

  int SHORTNAME_LENGHT = 25;
  int NAME_LENGHT = 50;
  int LONGNAME_LENGHT = 80;
  int SHORTDESCRIPTION_LENGHT = 50;
  int DESCRIPTION_LENGHT = 80;
  int LONGDESCRIPTION_LENGHT = 1024;
  int URL_LENGHT = 50;
  int CODE_2_LENGHT = 2;
  int CODE_3_LENGHT = 3;
  int CODE_8_LENGHT = 8;
  int CODE_20_LENGHT = 20;

  /**
   * @return entity identifier
   */
  T getId();

  /**
   * Assigns entity identifier
   * 
   * @param id
   */
  void setId(final T id);
}
