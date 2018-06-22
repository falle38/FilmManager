package com.movies.beans;

import com.movies.utils.Constantes;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Film
  implements Serializable
{
  @Id
  @GeneratedValue
  private Integer id;
  private Double note;
  private Double prix;
  private String titre;
  private String categorie;
  @Temporal(TemporalType.DATE)
  private Date dateVisionnage;
  private String lieu;
  private int duree;
  
  public Film() {}
  
  public Film(Double note, String titre, String categorie, Date dateVisionnage, String lieu, int duree)
  {
    this.note = note;
    this.prix = Constantes.prixdeBaseBillet;
    this.titre = titre;
    this.categorie = categorie;
    this.dateVisionnage = dateVisionnage;
    this.lieu = lieu;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public Double getNote()
  {
    return this.note;
  }
  
  public void setNote(Double note)
  {
    this.note = note;
  }
  
  public Double getPrix()
  {
    return this.prix;
  }
  
  public void setPrix(Double prix)
  {
    this.prix = prix;
  }
  
  public String getTitre()
  {
    return this.titre;
  }
  
  public void setTitre(String titre)
  {
    this.titre = titre;
  }
  
  public String getCategorie()
  {
    return this.categorie;
  }
  
  public void setCategorie(String categorie)
  {
    this.categorie = categorie;
  }
  
  public Date getDateVisionnage()
  {
    return this.dateVisionnage;
  }
  
  public void setDateVisionnage(Date dateVisionnage)
  {
    this.dateVisionnage = dateVisionnage;
  }
  
  public String getLieu()
  {
    return this.lieu;
  }
  
  public void setLieu(String lieu)
  {
    this.lieu = lieu;
  }
  
  public String toString()
  {
    return 
      "Film [id=" + this.id + ", note=" + this.note + ", prix=" + this.prix + ", titre=" + this.titre + ", categorie=" + this.categorie + ", dateVisionnage=" + this.dateVisionnage + ", lieu=" + this.lieu + "]";
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + (this.categorie == null ? 0 : this.categorie.hashCode());
    result = 31 * result + (this.dateVisionnage == null ? 0 : this.dateVisionnage.hashCode());
    result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
    result = 31 * result + (this.lieu == null ? 0 : this.lieu.hashCode());
    result = 31 * result + (this.note == null ? 0 : this.note.hashCode());
    result = 31 * result + (this.prix == null ? 0 : this.prix.hashCode());
    result = 31 * result + (this.titre == null ? 0 : this.titre.hashCode());
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Film other = (Film)obj;
    if (this.categorie == null)
    {
      if (other.categorie != null) {
        return false;
      }
    }
    else if (!this.categorie.equals(other.categorie)) {
      return false;
    }
    if (this.dateVisionnage == null)
    {
      if (other.dateVisionnage != null) {
        return false;
      }
    }
    else if (!this.dateVisionnage.equals(other.dateVisionnage)) {
      return false;
    }
    if (this.id == null)
    {
      if (other.id != null) {
        return false;
      }
    }
    else if (!this.id.equals(other.id)) {
      return false;
    }
    if (this.lieu == null)
    {
      if (other.lieu != null) {
        return false;
      }
    }
    else if (!this.lieu.equals(other.lieu)) {
      return false;
    }
    if (this.note == null)
    {
      if (other.note != null) {
        return false;
      }
    }
    else if (!this.note.equals(other.note)) {
      return false;
    }
    if (this.prix == null)
    {
      if (other.prix != null) {
        return false;
      }
    }
    else if (!this.prix.equals(other.prix)) {
      return false;
    }
    if (this.titre == null)
    {
      if (other.titre != null) {
        return false;
      }
    }
    else if (!this.titre.equals(other.titre)) {
      return false;
    }
    return true;
  }
  
  public int getDuree()
  {
    return this.duree;
  }
  
  public void setDuree(int duree)
  {
    this.duree = duree;
  }
}

