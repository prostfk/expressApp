package by.bntu.fitr.povt.maxpeep.controller;

import by.bntu.fitr.povt.maxpeep.model.entity.Film;
import by.bntu.fitr.povt.maxpeep.model.entity.User;
import by.bntu.fitr.povt.maxpeep.model.entity.UserFilm;
import by.bntu.fitr.povt.maxpeep.repository.FilmRepository;
import by.bntu.fitr.povt.maxpeep.repository.UserFilmRepository;
import by.bntu.fitr.povt.maxpeep.repository.UserRepository;
import by.bntu.fitr.povt.maxpeep.util.FileUtil;
import by.bntu.fitr.povt.maxpeep.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFilmRepository userFilmRepository;

    @GetMapping(value = "")
    public ModelAndView getIndexAdmin() {
        return new ModelAndView("adminIndex", "users", userRepository.findAll());
    }

    @PostMapping(value = "/changeUserStatus")
    public String changeUserStatus(Long id){
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()){
            User user = byId.get();
            user.setBlocked(!user.isBlocked());
            userRepository.save(user);
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/films")
    public ModelAndView getFilms(){
        return new ModelAndView("adminFilms", "films", filmRepository.findAll());
    }

    @PostMapping(value = "/deleteFilm")
    public String deleteFilm(Long id){
        Film filmById = filmRepository.findFilmById(id);
        List<UserFilm> userFilmsByFilm = userFilmRepository.findUserFilmsByFilm(filmById);
        if (filmById != null){
            userFilmRepository.deleteAll(userFilmsByFilm);
            filmRepository.delete(filmById);
        }
        return "redirect:/admin/films";

    }

    @GetMapping(value = "/addFilm")
    public String getAddFilm(){
        return "adminAddFilm";
    }

    @PostMapping(value = "/addFilm")
    public String postAddFilm(Film film, MultipartFile file){
        try {
            String s = FileUtil.saveFile(file);
            film.setPathToFile(s);
            if (ValidateUtil.validateFilm(film)){
                Film save = filmRepository.save(film);
                return "redirect:/film/" + save.getId();
            }
            return "redirect:/admin/adminAddFilm?error=CheckData";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error?message=" + e.getMessage();
        }
    }

    @GetMapping(value = "/editFilm/{id}")
    public ModelAndView getEditFilm(@PathVariable Long id){
        return new ModelAndView("adminEditFilm", "film", filmRepository.findFilmById(id));
    }

    @PostMapping(value = "/editFilm")
    public String postEditFilm(Film film){
        Optional<Film> byId = filmRepository.findById(film.getId());
        if (ValidateUtil.validateFilm(film) && film.getId() != null && byId.isPresent()){
            film.setPathToFile(byId.get().getPathToFile());
            filmRepository.save(film);
            return "redirect:/film/" + film.getId();
        }
        return "redirect:/error?message=checkData";
    }


}
