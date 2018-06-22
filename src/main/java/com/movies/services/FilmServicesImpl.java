package com.movies.services;

import com.movies.beans.Film;
import com.movies.beans.FilmStatictics;
import com.movies.dao.FilmRepository;
import com.movies.utils.FilmsSpecificationsBuilder;
import com.movies.utils.Utilitaire;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FilmServicesImpl
  implements FilmServices
{
  @Autowired
  private FilmRepository filmDao;
  
  public Film createMovie(Film f)
  {
    return (Film)this.filmDao.save(f);
  }
  
  public Optional<Film> deleteMovie(Integer id)
  {
    Optional<Film> movieToDelete = findMovieById(id);
    if (this.filmDao.existsById(id)) {
      this.filmDao.deleteById(id);
    }
    return movieToDelete;
  }
  
  public List<Film> findAllMovies()
  {
    return this.filmDao.findAll();
  }
  
  public Optional<Film> findMovieById(Integer id)
  {
    return this.filmDao.findById(id);
  }
  
  public Film updateMovie(Integer id, Film f)
  {
    f.setId(id);
    return (Film)this.filmDao.save(f);
  }
  
  public List<Film> searchMovieswithCriteria(String searchParams)
  {
    FilmsSpecificationsBuilder builder = new FilmsSpecificationsBuilder();
    Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
    Matcher matcher = pattern.matcher(searchParams + ",");
    while (matcher.find()) {
      builder.with(matcher.group(1), matcher.group(2), Utilitaire.manageCaracValues(matcher.group(3), "_", " "));
    }
    Specification<Film> spec = builder.build();
    return this.filmDao.findAll(spec);
  }
  
  public FilmStatictics retrieveStatitics()
  {
    FilmStatictics fstat = new FilmStatictics();
    fstat.setDonneesParCategorie(this.filmDao.getCategoriesData());
    fstat.setSeancesParMois(this.filmDao.getSessionsPerMonth());
    fstat.setSeancesParAnnees(this.filmDao.getSessionsPerYear());
    fstat.setSeancesParJour(this.filmDao.getSessionsPerDay());
    Utilitaire.retrieveStatsfromMovie(fstat, findAllMovies());
    return fstat;
  }
}
