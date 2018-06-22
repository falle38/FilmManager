package com.movies.utils;

import com.movies.beans.Film;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class FilmsSpecificationsBuilder
{
  private final List<SearchCriteria> params;
  
  public FilmsSpecificationsBuilder()
  {
    this.params = new ArrayList();
  }
  
  public FilmsSpecificationsBuilder with(String key, String operation, Object value)
  {
    this.params.add(new SearchCriteria(key, operation, value));
    return this;
  }
  
  public Specification<Film> build()
  {
    if (this.params.size() == 0) {
      return null;
    }
    List<Specification<Film>> specs = new ArrayList();
    for (SearchCriteria param : this.params) {
      specs.add(new FilmSpecifications(param));
    }
    Specification<Film> result = (Specification)specs.get(0);
    for (int i = 1; i < specs.size(); i++) {
      result = Specification.where(result).and((Specification)specs.get(i));
    }
    return result;
  }
}
