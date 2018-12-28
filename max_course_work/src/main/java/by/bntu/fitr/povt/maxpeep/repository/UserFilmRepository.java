package by.bntu.fitr.povt.maxpeep.repository;

import by.bntu.fitr.povt.maxpeep.model.entity.Film;
import by.bntu.fitr.povt.maxpeep.model.entity.User;
import by.bntu.fitr.povt.maxpeep.model.entity.UserFilm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserFilmRepository extends CrudRepository<UserFilm, Long> {

    List<UserFilm> findUserFilmsByUser(User user);

    UserFilm findUserFilmByFilmAndUser(Film film, User user);

    List<UserFilm> findUserFilmsByFilm(Film film);

}
