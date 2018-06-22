package com.movies.dao;

import com.movies.beans.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public abstract interface FilmRepository
  extends JpaRepository<Film, Integer>, JpaSpecificationExecutor<Film>, CustomJPARepository
{}
