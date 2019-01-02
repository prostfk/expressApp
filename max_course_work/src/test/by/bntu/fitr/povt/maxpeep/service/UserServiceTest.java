package by.bntu.fitr.povt.maxpeep.service;

import by.bntu.fitr.povt.maxpeep.model.entity.User;
import by.bntu.fitr.povt.maxpeep.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindUserByUsernameShouldBeOk() {
        when(userRepository.findByUsername("max")).thenReturn(new User("max","zxc",false));
        assertEquals(new User("max","zxc",false), userService.findByUsername("max"));
    }

    @Test
    public void testFindUserByUsernameShouldBeFail() {
        when(userRepository.findByUsername(null)).thenReturn(null);
        assertNull(userService.findByUsername(null));
    }
}
