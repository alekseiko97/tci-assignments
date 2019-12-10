package book_exercise;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Test
    public void verifyUserGotPassword() {
        User user = mock(User.class);
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

        try {
            userService.assignPassword(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify(user).getPassword();
        verify(userDAO).updateUser(user);
    }

}