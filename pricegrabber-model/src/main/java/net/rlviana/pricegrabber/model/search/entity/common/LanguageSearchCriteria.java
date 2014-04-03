/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.search.entity.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.rlviana.pricegrabber.model.entity.common.Language;
import net.rlviana.pricegrabber.model.entity.common.Language_;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

/**
 * Search criteria for Language entites
 * 
 * @author ramon
 */
public class LanguageSearchCriteria extends AbstractSearchCriteria<Language, String> {

  private String id = null;
  private String idLike = null;
  private String cod = null;
  private String codLike = null;
  private String name = null;
  private String nameLike = null;

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.search.AbstractSearchCriteria#getEntityClass()
   */
  @Override
  public Class<Language> getEntityClass() {
    return Language.class;
  }

  @Override
  protected List<Expression<Language>> getGrouping(final CriteriaBuilder builder, final Root<Language> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Predicate> getHaving(final CriteriaBuilder builder, final Root<Language> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Predicate> getRestrictions(final CriteriaBuilder builder, final Root<Language> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Order> getOrdering(final CriteriaBuilder builder, final Root<Language> root) {
    List<Order> orderBy = new ArrayList<Order>();
    orderBy.add(builder.desc(root.get(Language_.id)));
    return orderBy;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * @return the idLike
   */
  public String getIdLike() {
    return idLike;
  }

  /**
   * @param idLike the idLike to set
   */
  public void setIdLike(final String idLike) {
    this.idLike = idLike;
  }

  /**
   * @return the cod
   */
  public String getCod() {
    return cod;
  }

  /**
   * @param cod the cod to set
   */
  public void setCod(final String cod) {
    this.cod = cod;
  }

  /**
   * @return the codLike
   */
  public String getCodLike() {
    return codLike;
  }

  /**
   * @param codLike the codLike to set
   */
  public void setCodLike(final String codLike) {
    this.codLike = codLike;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * @return the nameLike
   */
  public String getNameLike() {
    return nameLike;
  }

  /**
   * @param nameLike the nameLike to set
   */
  public void setNameLike(final String nameLike) {
    this.nameLike = nameLike;
  }

}
