package com.movies.services;

import com.movies.beans.Film;
import com.movies.beans.FilmStatictics;
import java.util.List;
import java.util.Optional;

public abstract interface FilmServices
{
  public abstract Film createMovie(Film paramFilm);
  
  public abstract Optional<Film> deleteMovie(Integer paramInteger);
  
  public abstract List<Film> findAllMovies();
  
  public abstract Optional<Film> findMovieById(Integer paramInteger);
  
  public abstract Film updateMovie(Integer paramInteger, Film paramFilm);
  
  public abstract List<Film> searchMovieswithCriteria(String paramString);
  
  public abstract FilmStatictics retrieveStatitics();
}
