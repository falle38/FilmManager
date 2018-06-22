package com.movies;

import com.movies.beans.Film;
import com.movies.dao.FilmRepository;
import java.io.PrintStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmManagerApplication
  implements CommandLineRunner
{
  @Autowired
  private FilmRepository filmRepository;
  
  public static void main(String[] args)
  {
    SpringApplication.run(FilmManagerApplication.class, args);
  }
  
  public void run(String... arg0)
    throws Exception
  {
    List<Film> films = this.filmRepository.findAll();
    for (Film f : films) {
      System.out.println("processing: " + f.getTitre() + " " + f.getLieu());
    }
  }
}
