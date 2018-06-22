package com.movies.controllers;

import com.movies.beans.Film;
import com.movies.beans.FilmStatictics;
import com.movies.services.FilmServices;
import com.movies.utils.Utilitaire;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"MOVIEAPI"})
@CrossOrigin({"*"})
public class FilmController
{
  @Autowired
  private FilmServices filmServices;
  
  @PostMapping({"/save-movie"})
  public Film creerFilm(@RequestBody Film f)
  {
    return this.filmServices.createMovie(f);
  }
  
  @DeleteMapping(path={"/delete-movie/{id}"})
  public Optional<Film> supprimerFilm(@PathVariable Integer id)
  {
    return this.filmServices.deleteMovie(id);
  }
  
  @GetMapping(path={"/movies"})
  public List<Film> listerFilms()
  {
    return this.filmServices.findAllMovies();
  }
  
  @GetMapping(path={"/movie-details/{id}"})
  public Optional<Film> trouverFilmParId(@PathVariable Integer id)
  {
    return this.filmServices.findMovieById(id);
  }
  
  @PutMapping(path={"/update-movie"})
  public Film mettreAjourFilm(@RequestBody Film f)
  {
    return this.filmServices.updateMovie(f.getId(), f);
  }
  
  @GetMapping(path={"/movies-avg"})
  public Double calculerMoyenneNoteFilms()
  {
    return Utilitaire.calculerMoyenneGenerale(listerFilms());
  }
  
  @GetMapping(path={"/movies-search"})
  public List<Film> search(@RequestParam("params") String searchParams)
  {
    return this.filmServices.searchMovieswithCriteria(searchParams);
  }
  
  @GetMapping(path={"/film-statitics"})
  public FilmStatictics getStats()
  {
    return this.filmServices.retrieveStatitics();
  }
}
