package com.movies.utils;

public class Constantes
{
  public static Double prixdeBaseBillet = Double.valueOf(15.0D);
  public static String CATEGORY_QUERY = "select f.categorie,COUNT(f.titre),AVG(f.duree),AVG(f.note) from Film f GROUP BY f.categorie";
  public static String SESSIONMONTH_QUERY = "select MONTH(f.date_visionnage),COUNT(f.titre) from Film f GROUP BY MONTH(f.date_visionnage)";
  public static String SESSIONYEAR_QUERY = "select YEAR(f.date_visionnage),COUNT(f.titre) from Film f GROUP BY YEAR(f.date_visionnage)";
  public static String SESSIONDAY_QUERY = "select dayofweek(f.date_visionnage),COUNT(f.titre) from Film f GROUP BY 1";
}


