package by.bntu.fitr.povt.maxpeep.service;

import by.bntu.fitr.povt.maxpeep.model.entity.Film;
import by.bntu.fitr.povt.maxpeep.model.entity.User;
import by.bntu.fitr.povt.maxpeep.model.entity.UserFilm;
import by.bntu.fitr.povt.maxpeep.repository.UserFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFilmService {

    @Autowired
    private UserFilmRepository userFilmRepository;

    public List<UserFilm> findUserFilmsByUser(User user){
        return userFilmRepository.findUserFilmsByUser(user);
    }

    public UserFilm findUserFilmByFilmAndUser(Film film, User user){
        return userFilmRepository.findUserFilmByFilmAndUser(film, user);
    }

    public List<UserFilm> findUserFilmsByFilm(Film film){
        return userFilmRepository.findUserFilmsByFilm(film);
    }


}
