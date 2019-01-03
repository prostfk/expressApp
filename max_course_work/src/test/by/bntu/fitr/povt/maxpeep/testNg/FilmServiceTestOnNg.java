//package by.bntu.fitr.povt.maxpeep.testNg;
//
//import by.bntu.fitr.povt.maxpeep.model.entity.Film;
//import by.bntu.fitr.povt.maxpeep.repository.FilmRepository;
//import by.bntu.fitr.povt.maxpeep.service.FilmService;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import java.util.LinkedList;
//import static org.mockito.Mockito.when;
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertNull;
//
//public class FilmServiceTestOnNg {
//
//    @Mock
//    private FilmRepository filmRepository;
//
//    @InjectMocks
//    private FilmService filmService;
//
//    @BeforeTest
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testFindFilmByIdShouldBeOk() {
//        Film film = new Film();
//        film.setId(1L);
//        when(filmRepository.findFilmById(1L)).thenReturn(
//                film
//        );
//        assertEquals(film, filmService.findFilmById(1L));
//    }
//
//    @Test
//    public void testFindFilmByIdShouldBeNull() {
//        when(filmRepository.findFilmById(null)).thenReturn(null);
//        assertNull(filmService.findFilmById(null));
//    }
//
//    @Test
//    public void testFindFilmsByDescriptionLikeShouldBeOk() {
//        when(filmRepository.findFilmsByGenreLike("desc")).thenReturn(new LinkedList<>());
//        assertEquals(new LinkedList<>(), filmService.findFilmsByDescriptionLike("desc"));
//    }
//
//    @Test
//    public void testFindFilmsByDescriptionLikeShouldBeNull() {
//        when(filmRepository.findFilmsByGenreLike(null)).thenReturn(null);
//        assertNull(filmService.findFilmsByGenreLike(null));
//    }
//
//    @Test
//    public void testFindFilmsByTitleLikeShouldBeOk() {
//        when(filmRepository.findFilmsByTitleLike("title")).thenReturn(new LinkedList<>());
//        assertEquals(new LinkedList<>(), filmService.findFilmsByDescriptionLike("title"));
//    }
//
//    @Test
//    public void testFindFilmsByTitleLikeShouldBeNull() {
//        when(filmRepository.findFilmsByTitleLike(null)).thenReturn(null);
//        assertNull(filmService.findFilmsByTitleLike(null));
//    }
//
//    @Test
//    public void testFindFilmsByGenreLikeShouldBeOk() {
//        when(filmRepository.findFilmsByGenreLike("genre")).thenReturn(new LinkedList<>());
//        assertEquals(new LinkedList<>(), filmService.findFilmsByGenreLike("genre"));
//    }
//
//    @Test
//    public void testFindFilmsByGenreLikeShouldBeNull() {
//        when(filmRepository.findFilmsByGenreLike(null)).thenReturn(null);
//        assertNull(filmService.findFilmsByGenreLike(null));
//    }
//
//    @Test
//    public void testFindFilmsByYearShouldBeOk() {
//        when(filmRepository.findFilmsByYear(2018)).thenReturn(new LinkedList<>());
//        assertEquals(new LinkedList<>(), filmService.findFilmsByYear(2018));
//    }
//
//    @Test
//    public void testFindFilmsByYearShouldBeNull() {
//        when(filmRepository.findFilmsByYear(null)).thenReturn(null);
//        assertNull(filmService.findFilmsByYear(null));
//    }
//
//}
