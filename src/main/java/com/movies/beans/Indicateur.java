package com.movies.beans;

import java.util.ArrayList;
import java.util.List;

public class Indicateur
{
  Object name;
  List<Object> values = new ArrayList();
  
  public Indicateur(Object name, Object value)
  {
    this.name = name;
    this.values.add(value);
  }
  
  public Indicateur(Object name, List<Object> values)
  {
    this.name = name;
    this.values = values;
  }
  
  public Object getName()
  {
    return this.name;
  }
  
  public void setName(Object name)
  {
    this.name = name;
  }
  
  public List<Object> getValue()
  {
    return this.values;
  }
  
  public void setValue(List<Object> value)
  {
    this.values = value;
  }
  
  public String toString()
  {
    return "Indicateur [name=" + this.name + ", values=" + this.values + "]";
  }
}
