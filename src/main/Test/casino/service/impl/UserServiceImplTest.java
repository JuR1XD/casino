package casino.service.impl;

import com.packt.casino.Service.Impl.UserServiceImpl;
import com.packt.casino.domain.User;
import com.packt.casino.domain.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserServiceImplTest {

    @Mock
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void addUserTest_add_regularUsage()
    {
        //Arrange
        User user = User.builder()
                .email("jtaair234@gmail.com")
                .city("Groß-Rohrheim")
                .name("Juri")
                .credit(200.0)
                .password("Valantic01!")
                .postalCode("68649")
                .street("Rheinstraße")
                .streetNr("120")
                .birthday("2001-17-09")
                .isActivated(true)
                .surname("Hofmann")
                .build();

        //Act
        userRepository.save(user);
        //Assert
        assertTrue(user != null);
    }

    @Test
    public void addUserTest_add_userIsNull()
    {
        //Arrange


        User user = User.builder()
                .email(null)
                .city("Groß-Rohrheim")
                .name("Juri")
                .credit(200.0)
                .password("Valantic01!")
                .postalCode("68649")
                .street("Rheinstraße")
                .streetNr("120")
                .birthday("2001-17-09")
                .isActivated(true)
                .surname("Hofmann")
                .build();

        //Act
        userRepository.save(user);
        //Assert
        assertNull(user.getEmail());
    }

    @Test
    public void deleteUserTest_delete_deleteUser()
    {
        //Arrange

        User user = User.builder()
                .email("jtaair234@gmail.com")
                .city("Groß-Rohrheim")
                .name("Juri")
                .credit(200.0)
                .password("Valantic01!")
                .postalCode("68649")
                .street("Rheinstraße")
                .streetNr("120")
                .birthday("2001-17-09")
                .isActivated(true)
                .surname("Hofmann")
                .build();

        //Act
        userRepository.save(user);
        userRepository.delete(user);
        //Assert
        assertEquals(userRepository.findUserByUserId(user.getUserId()), null);
    }


}
