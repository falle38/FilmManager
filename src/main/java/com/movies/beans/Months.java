package com.movies.beans;

public enum Months
{
  Janvier(1),  Fevrier(2),  Mars(3),  Avril(4),  Mai(5),  Juin(6),  Juillet(7),  Aout(8),  Septembre(9),  Octobre(10),  Novembre(11),  Decembre(12);
  
  private int value;
  
  private Months(int value)
  {
    this.value = value;
  }
  
  public int value()
  {
    return this.value;
  }
  
  public static Months fromIntToMonth(int dayValue)
  {
    Months[] arrayOfMonths;
    int j = (arrayOfMonths = values()).length;
    for (int i = 0; i < j; i++)
    {
      Months day = arrayOfMonths[i];
      if (day.value == dayValue) {
        return day;
      }
    }
    return null;
  }
}
