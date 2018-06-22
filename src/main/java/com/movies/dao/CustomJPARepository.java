package com.movies.dao;

import com.movies.beans.Indicateur;
import java.util.List;

public abstract interface CustomJPARepository
{
  public abstract List<Indicateur> getCategoriesData();
  
  public abstract List<Indicateur> getSessionsPerMonth();
  
  public abstract List<Indicateur> getSessionsPerYear();
  
  public abstract List<Indicateur> getSessionsPerDay();
}
