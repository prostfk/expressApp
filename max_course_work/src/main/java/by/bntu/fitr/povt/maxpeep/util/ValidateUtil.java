package by.bntu.fitr.povt.maxpeep.util;

import by.bntu.fitr.povt.maxpeep.model.entity.Film;
import by.bntu.fitr.povt.maxpeep.model.entity.User;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ValidateUtil {

    public static boolean validateUser(User user){
        try {
            int password = user.getPassword().length();
            int username = user.getUsername().length();
            return password >= 6 && password < 20 && username >= 5 && username < 15;
        }catch (NullPointerException e){
            return false;
        }
    }

    public static boolean validateFilm(Film film){
        try {
            int title = film.getTitle().length();
            int desc = film.getDescription().length();
            int genre = film.getGenre().length();
            String path = film.getPathToFile();
            Integer year = film.getYear();
            return title >= 5 && title <= 50 && desc >= 10
                    && desc <= 9999 && genre >= 3 && genre <= 15 && year >= 1900 && year <= new GregorianCalendar().get(Calendar.YEAR);
        }catch (NullPointerException e){
            return false;
        }
    }


}
