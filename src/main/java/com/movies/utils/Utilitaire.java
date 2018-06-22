package com.movies.utils;

import java.util.ArrayList;
import com.movies.beans.FilmStatictics;
import java.util.stream.Collectors;
import java.util.Map;
import com.movies.beans.Indicateur;
import com.movies.beans.Film;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Utilitaire
{
    private static Converter converter;
    
    static {
        Utilitaire.converter = new Converter();
    }
    
    private static List<Indicateur> calculerNbFilmsParCinema(final List<Film> flist) {
        final Map<String, Long> result = flist.stream().collect(Collectors.groupingBy(Film::getLieu, Collectors.counting()));
        return (List<Indicateur>)Utilitaire.converter.convertToMapLong((Map)result);
    }
    
    private List<Indicateur> calculerNbFilmsParCategorie(final List<Film> flist) {
        final Map<String, Long> result = flist.stream().collect(Collectors.groupingBy(Film::getCategorie, Collectors.counting()));
        return (List<Indicateur>)Utilitaire.converter.convertToMapLong((Map)result);
    }
    
    private List<Indicateur> calculerDureeFilmsParCategorie(final List<Film> flist) {
        final Map<String, Integer> result = flist.stream().collect(Collectors.groupingBy(Film::getCategorie, Collectors.summingInt(f -> f.getDuree())));
        return (List<Indicateur>)Utilitaire.converter.convertToMapInt((Map)result);
    }
    
    private List<Indicateur> calculerMoyenneFilmsParCategorie(final List<Film> flist) {
        final Map<String, Double> result = flist.stream().collect(Collectors.groupingBy(Film::getCategorie, Collectors.averagingDouble(f -> f.getNote())));
        return (List<Indicateur>)Utilitaire.converter.convertToMapDouble((Map)result);
    }
    
    public static Double calculerMoyenneGenerale(final List<Film> filmList) {
        return filmList.stream().collect(Collectors.averagingDouble(f -> f.getNote()));
    }
    
    private static Double calculerMoyenneDureeGenerale(final List<Film> filmList) {
        return filmList.stream().collect(Collectors.averagingDouble(f -> f.getDuree()));
    }
    
    private static int calculerDureeTotale(final List<Film> filmList) {
        return filmList.stream().mapToInt(f -> f.getDuree()).sum();
    }
    
    private Double calculerMoyenneCategorie(final List<Film> filmList, final String categorie) {
        return filmList.stream().filter(f -> f.getCategorie().equals(categorie)).collect(Collectors.averagingDouble(f -> f.getNote()));
    }
    
    private List<Film> listerFilmParCategorie(final List<Film> filmList, final String categorie) {
        return filmList.stream().sorted((f1, f2) -> f1.getTitre().compareToIgnoreCase(f2.getTitre())).filter(f -> f.getCategorie().equals(categorie)).collect(Collectors.toList());
    }
    
    public static String manageCaracValues(final Object o, final String caracToReplace, final String replacingCarac) {
        final String s = o.toString();
        if (s.contains(caracToReplace)) {
            s.replace(caracToReplace, replacingCarac);
        }
        return s;
    }
    
    public static FilmStatictics retrieveStatsfromMovie(final FilmStatictics fs, final List<Film> fList) {
        fs.setNbTotalFilms(fList.size());
        fs.setDureeTotaleFilms(calculerDureeTotale(fList));
        fs.setMoyenneDuree(calculerMoyenneDureeGenerale(fList));
        fs.setMoyenneNotes(calculerMoyenneGenerale(fList));
        fs.setSeancesParCinema(calculerNbFilmsParCinema(fList));
        return fs;
    }
    
    public static List<Object> buildValues(final Object[] values) {
        final List<Object> res = new ArrayList<Object>();
        if (values != null && values.length > 1) {
            for (int i = 1; i < values.length; ++i) {
                res.add(values[i]);
            }
        }
        return res;
    }
}