package by.bntu.fitr.povt.maxpeep.service;

import by.bntu.fitr.povt.maxpeep.model.entity.Film;
import by.bntu.fitr.povt.maxpeep.model.entity.User;
import by.bntu.fitr.povt.maxpeep.model.entity.UserFilm;
import by.bntu.fitr.povt.maxpeep.repository.UserFilmRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class UserFilmServiceTest {

    @Mock
    private UserFilmRepository userFilmRepository;

    @InjectMocks
    private UserFilmService userFilmService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindUserFilmsByUserShouldBeOk() {
        when(userFilmRepository.findUserFilmsByUser(new User()))
                .thenReturn(new LinkedList<>());
        assertEquals(new LinkedList<>(), userFilmService.findUserFilmsByUser(new User()));
    }

    @Test
    public void testFindUserFilmsByUserShouldBeNull() {
        when(userFilmRepository.findUserFilmsByUser(null))
                .thenReturn(null);
        assertNull(userFilmService.findUserFilmsByUser(null));
    }

    @Test
    public void testFindUserFilmByFilmAndUserShouldBeOk() {
        when(userFilmRepository.findUserFilmByFilmAndUser(new Film(), new User()))
                .thenReturn(new UserFilm());
        assertEquals(new UserFilm(),userFilmService.findUserFilmByFilmAndUser(new Film(), new User()));
    }

    @Test
    public void testFindUserFilmByFilmAndUserShouldBeNull() {
        when(userFilmRepository.findUserFilmByFilmAndUser(null,null))
                .thenReturn(null);
        assertNull(userFilmService.findUserFilmByFilmAndUser(null, null));
    }

    @Test
    public void testFindUserFilmsByFilmShouldBeOk() {
        when(userFilmRepository.findUserFilmsByFilm(new Film()))
                .thenReturn(new LinkedList<>());
        assertEquals(new LinkedList<>(), userFilmService.findUserFilmsByFilm(new Film()));
    }

    @Test
    public void testFindUserFilmsByFilmShouldBeNull() {
        when(userFilmRepository.findUserFilmsByFilm(null))
                .thenReturn(null);
        assertNull(userFilmService.findUserFilmsByFilm(null));
    }
}
