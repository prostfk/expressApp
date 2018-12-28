package by.bntu.fitr.povt.maxpeep.controller;

import by.bntu.fitr.povt.maxpeep.model.entity.Film;
import by.bntu.fitr.povt.maxpeep.model.entity.User;
import by.bntu.fitr.povt.maxpeep.repository.FilmRepository;
import by.bntu.fitr.povt.maxpeep.repository.UserRepository;
import by.bntu.fitr.povt.maxpeep.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/")
    public ModelAndView getIndex() {
        return new ModelAndView("index", "films", filmRepository.findAll());
    }

    @GetMapping(value = "/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String postRegistration(User user) {
        if (ValidateUtil.validateUser(user)) {
            User byUsername = userRepository.findByUsername(user.getUsername());
            if (byUsername == null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(user);
                return "auth";
            }
        }
        return "redirect:/registration?error=Bad data";
    }

    @GetMapping(value = "/auth")
    public String getAuth() {
        return "auth";
    }

    @GetMapping(value = "/search")
    public ModelAndView getSearch(@RequestParam String type, @RequestParam String value) {
        List<Film> films;
        switch (type) {
            case "title":
                films = filmRepository.findFilmsByTitleLike(String.format("%%%s%%", value));
                break;
            case "description":
                films = filmRepository.findFilmsByDescriptionLike(String.format("%%%s%%", value));
                break;
            case "year":
                films = filmRepository.findFilmsByYear(Integer.parseInt(value));
                break;
            default:
                films = filmRepository.findFilmsByGenreLike(String.format("%%%s%%", value));
        }
        return new ModelAndView("index", "films", films);
    }

    @GetMapping(value = "/film/{id}")
    public ModelAndView findById(@PathVariable Long id){
        Optional<Film> byId = filmRepository.findById(id);
        return byId.map(film ->
                new ModelAndView("singleFilm", "film", film)).orElseGet(()
                -> new ModelAndView("redirect:/error"));
    }


}



