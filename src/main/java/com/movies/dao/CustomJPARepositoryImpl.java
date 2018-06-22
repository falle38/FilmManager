package com.movies.dao;

import com.movies.utils.Constantes;
import com.movies.beans.Days;
import com.movies.beans.Indicateur;
import com.movies.beans.Months;
import com.movies.utils.Utilitaire;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomJPARepositoryImpl
  implements CustomJPARepository
{
  @PersistenceContext
  EntityManager entityManager;
  
  public List<Indicateur> getCategoriesData()
  {
    return getIndicators(Constantes.CATEGORY_QUERY, null);
  }
  
  public List<Indicateur> getSessionsPerMonth()
  {
    return getIndicators(Constantes.SESSIONMONTH_QUERY, "MOIS");
  }
  
  public List<Indicateur> getSessionsPerYear()
  {
    return getIndicators(Constantes.SESSIONYEAR_QUERY, null);
  }
  
  public List<Indicateur> getSessionsPerDay()
  {
    return getIndicators(Constantes.SESSIONDAY_QUERY, "JOUR");
  }
  
  private List<Indicateur> getIndicators(String req, String conversionType)
  {
    List<Indicateur> indicators = new ArrayList();
    Query query = this.entityManager.createNativeQuery(req);
    List results = query.getResultList();
    for (Object result : results)
    {
      Object[] ligne = (Object[])result;
      indicators.add(new Indicateur(convertData(ligne[0].toString(), conversionType), Utilitaire.buildValues(ligne)));
    }
    return indicators;
  }
  
  private Object convertData(Object o, String type)
  {
    if (type != null)
    {
      switch (type)
      {
      case "JOUR": 
    	  return dayConversion(o);
      case "MOIS": 
          return monthConversion(o);
      default:
      throw new IllegalArgumentException(type + " is not a valid type of conversion");
      }
    }
    return o;
  }
  
  private String dayConversion(Object o)
  {
    String s = o.toString();
    return Days.fromIntToDay(Integer.valueOf(s).intValue()).toString();
  }
  
  private String monthConversion(Object o)
  {
    String s = o.toString();
    return Months.fromIntToMonth(Integer.valueOf(s).intValue()).toString();
  }
}
