package com.movies.utils;

import com.movies.beans.Indicateur;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.stereotype.Service;

@Service
public class Converter
{
  public List<Indicateur> convertToMapLong(Map<String, Long> map)
  {
    List<Indicateur> res = new ArrayList();
    for (Map.Entry<String, Long> e : map.entrySet()) {
      res.add(new Indicateur(e.getKey(), e.getValue()));
    }
    return res;
  }
  
  public List<Indicateur> convertToMapDouble(Map<String, Double> map)
  {
    List<Indicateur> res = new ArrayList();
    for (Map.Entry<String, Double> e : map.entrySet()) {
      res.add(new Indicateur(e.getKey(), e.getValue()));
    }
    return res;
  }
  
  public List<Indicateur> convertToMapInt(Map<String, Integer> map)
  {
    List<Indicateur> res = new ArrayList();
    for (Map.Entry<String, Integer> e : map.entrySet()) {
      res.add(new Indicateur(e.getKey(), e.getValue()));
    }
    return res;
  }
}

