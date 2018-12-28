package by.bntu.fitr.povt.maxpeep.repository;

import by.bntu.fitr.povt.maxpeep.model.entity.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {

    Film findFilmById(Long id);
    List<Film> findFilmsByDescriptionLike(String descriptionLike);
    List<Film> findFilmsByTitleLike(String titleLike);
    List<Film> findFilmsByGenreLike(String genreLike);
    List<Film> findFilmsByYear(Integer year);


}
