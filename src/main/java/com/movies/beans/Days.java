package com.movies.beans;

public enum Days
{
  Lundi(1),  Mardi(2),  Mercredi(3),  Jeudi(4),  Vendredi(5),  Samedi(6),  Dimanche(7);
  
  private int value;
  
  private Days(int value)
  {
    this.value = value;
  }
  
  public int value()
  {
    return this.value;
  }
  
  public static Days fromIntToDay(int dayValue)
  {
    Days[] arrayOfDays;
    int j = (arrayOfDays = values()).length;
    for (int i = 0; i < j; i++)
    {
      Days day = arrayOfDays[i];
      if (day.value == dayValue) {
        return day;
      }
    }
    return null;
  }
}
