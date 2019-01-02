package by.bntu.fitr.povt.maxpeep.service;

import by.bntu.fitr.povt.maxpeep.model.entity.Film;
import by.bntu.fitr.povt.maxpeep.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public Film findFilmById(Long id){
        return filmRepository.findFilmById(id);
    }

    public List<Film> findFilmsByDescriptionLike(String descriptionLike){
        return filmRepository.findFilmsByDescriptionLike(descriptionLike);
    }

    public List<Film> findFilmsByTitleLike(String titleLike){
        return filmRepository.findFilmsByTitleLike(titleLike);
    }

    public List<Film> findFilmsByGenreLike(String genreLike){
        return filmRepository.findFilmsByGenreLike(genreLike);
    }

    public List<Film> findFilmsByYear(Integer year){
        return filmRepository.findFilmsByYear(year);
    }



}
