package com.movies.beans;

public class Acteur
{
  private Integer idActeur;
  private String nom;
  private String prenom;
  private Sex sexe;
  
  public Integer getIdActeur()
  {
    return this.idActeur;
  }
  
  public void setIdActeur(Integer idActeur)
  {
    this.idActeur = idActeur;
  }
  
  public String getNom()
  {
    return this.nom;
  }
  
  public void setNom(String nom)
  {
    this.nom = nom;
  }
  
  public String getPrenom()
  {
    return this.prenom;
  }
  
  public void setPrenom(String prenom)
  {
    this.prenom = prenom;
  }
  
  public Sex getSexe()
  {
    return this.sexe;
  }
  
  public void setSexe(Sex sexe)
  {
    this.sexe = sexe;
  }
}
