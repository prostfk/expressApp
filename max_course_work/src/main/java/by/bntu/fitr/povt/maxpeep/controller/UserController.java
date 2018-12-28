package by.bntu.fitr.povt.maxpeep.controller;

import by.bntu.fitr.povt.maxpeep.model.entity.Film;
import by.bntu.fitr.povt.maxpeep.model.entity.User;
import by.bntu.fitr.povt.maxpeep.model.entity.UserFilm;
import by.bntu.fitr.povt.maxpeep.repository.FilmRepository;
import by.bntu.fitr.povt.maxpeep.repository.UserFilmRepository;
import by.bntu.fitr.povt.maxpeep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@Secured("ROLE_USER")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private UserFilmRepository userFilmRepository;

    @GetMapping(value = "/wishList")
    public ModelAndView myPage() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User byUsername = userRepository.findByUsername(name);
        return new ModelAndView("wishList", "films", userFilmRepository.findUserFilmsByUser(byUsername));
    }

    @PostMapping(value = "/addWish")
    public String addToMyPage(Long id) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Film filmById = filmRepository.findFilmById(id);
        User byUsername = userRepository.findByUsername(name);
        UserFilm userFilmByFilmAndUser = userFilmRepository.findUserFilmByFilmAndUser(filmById, byUsername);
        if (userFilmByFilmAndUser == null) {
            UserFilm save = userFilmRepository.save(new UserFilm(byUsername, filmById));
            if (save!=null){
                return "redirect:/wishList";
            }
        }
        return "redirect:/";
    }

    @GetMapping(value = "/deleteWish/{id}")
    public String deleteWish(@PathVariable Long id){
        Optional<UserFilm> byId = userFilmRepository.findById(id);
        byId.ifPresent(userFilm -> userFilmRepository.delete(userFilm));
        return "redirect:/wishList";
    }


}
