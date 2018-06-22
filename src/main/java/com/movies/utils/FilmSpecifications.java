package com.movies.utils;

import com.movies.beans.Film;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class FilmSpecifications
  implements Specification<Film>
{
  private SearchCriteria criteria;
  
  public FilmSpecifications(SearchCriteria criteria)
  {
    this.criteria = criteria;
  }
  
  public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
  {
    Date dateLimit = null;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    if (this.criteria.getOperation().equalsIgnoreCase(">"))
    {
      if (root.get(this.criteria.getKey()).getJavaType() == Date.class)
      {
        try
        {
          dateLimit = dateFormat.parse(this.criteria.getValue().toString());
        }
        catch (ParseException e)
        {
          e.printStackTrace();
        }
        return criteriaBuilder.and(new Predicate[] {
          criteriaBuilder.greaterThan(root.get("dateVisionnage"), dateLimit) });
      }
      return criteriaBuilder.greaterThanOrEqualTo(
      
        root.get(this.criteria.getKey()), this.criteria.getValue().toString());
    }
    if (this.criteria.getOperation().equalsIgnoreCase("<"))
    {
      if (root.get(this.criteria.getKey()).getJavaType() == Date.class)
      {
        try
        {
          dateLimit = dateFormat.parse(this.criteria.getValue().toString());
        }
        catch (ParseException e)
        {
          e.printStackTrace();
        }
        return criteriaBuilder.and(new Predicate[] {
          criteriaBuilder.lessThan(root.get("dateVisionnage"), dateLimit) });
      }
      return criteriaBuilder.lessThanOrEqualTo(
        root.get(this.criteria.getKey()), this.criteria.getValue().toString());
    }
    if (this.criteria.getOperation().equalsIgnoreCase(":"))
    {
      if (root.get(this.criteria.getKey()).getJavaType() == String.class) {
        return criteriaBuilder.like(
          root.get(this.criteria.getKey()), "%" + this.criteria.getValue() + "%");
      }
      return criteriaBuilder.equal(root.get(this.criteria.getKey()), this.criteria.getValue());
    }
    return null;
  }
}
