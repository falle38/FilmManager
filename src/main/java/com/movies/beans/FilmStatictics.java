package com.movies.beans;

import java.util.List;

public class FilmStatictics
{
  private int nbTotalFilms;
  private int dureeTotaleFilms;
  private Double moyenneNotes;
  private Double moyenneDuree;
  private List<Indicateur> donneesParCategorie;
  private List<Indicateur> seancesParCinema;
  private List<Indicateur> seancesParJour;
  private List<Indicateur> seancesParMois;
  private List<Indicateur> seancesParAnnees;
  
  public int getNbTotalFilms()
  {
    return this.nbTotalFilms;
  }
  
  public void setNbTotalFilms(int nbTotalFilms)
  {
    this.nbTotalFilms = nbTotalFilms;
  }
  
  public int getDureeTotaleFilms()
  {
    return this.dureeTotaleFilms;
  }
  
  public void setDureeTotaleFilms(int dureeTotaleFilms)
  {
    this.dureeTotaleFilms = dureeTotaleFilms;
  }
  
  public Double getMoyenneNotes()
  {
    return this.moyenneNotes;
  }
  
  public void setMoyenneNotes(Double moyenneNotes)
  {
    this.moyenneNotes = moyenneNotes;
  }
  
  public Double getMoyenneDuree()
  {
    return this.moyenneDuree;
  }
  
  public void setMoyenneDuree(Double moyenneDuree)
  {
    this.moyenneDuree = moyenneDuree;
  }
  
  public List<Indicateur> getSeancesParMois()
  {
    return this.seancesParMois;
  }
  
  public void setSeancesParMois(List<Indicateur> seancesParMois)
  {
    this.seancesParMois = seancesParMois;
  }
  
  public List<Indicateur> getSeancesParCinema()
  {
    return this.seancesParCinema;
  }
  
  public void setSeancesParCinema(List<Indicateur> seancesParCinema)
  {
    this.seancesParCinema = seancesParCinema;
  }
  
  public List<Indicateur> getSeancesParJour()
  {
    return this.seancesParJour;
  }
  
  public void setSeancesParJour(List<Indicateur> seancesParJour)
  {
    this.seancesParJour = seancesParJour;
  }
  
  public List<Indicateur> getDonneesParCategorie()
  {
    return this.donneesParCategorie;
  }
  
  public void setDonneesParCategorie(List<Indicateur> donneesParCategorie)
  {
    this.donneesParCategorie = donneesParCategorie;
  }
  
  public List<Indicateur> getSeancesParAnnees()
  {
    return this.seancesParAnnees;
  }
  
  public void setSeancesParAnnees(List<Indicateur> seancesParAnnees)
  {
    this.seancesParAnnees = seancesParAnnees;
  }
}
