package WebService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HomeTest {

    Home mockUser(){
        User mockUser = mock(User.class);
        UserDao testUser = new UserDao("testuser","qwer1234","test1");
        when(mockUser.getUserName()).thenReturn("test1");
        when(mockUser.getUserById("testuser")).thenReturn(testUser);
        Home home = new Home();
        home.setUser(mockUser);
        return home;
    }

    @Test
    @DisplayName("login Success Test")
    void login() {
        Home home = mockUser();
        assertEquals("Login Success",home.Login("testuser","qwer1234"));

    }
    @Test
    @DisplayName("login Fail Test")
    void login_1() {
        Home home = mockUser();
        assertEquals("Wrong id or password",home.Login("testuser","qwer12345"));
    }
    @Test
    @DisplayName("Already Login Test")
    void login_2() {
        Home home = mockUser();
        home.Login("testuser","qwer1234");
        assertEquals("already login",home.Login("testuser","qwer1234"));
    }

    @Test
    @DisplayName("Logout Test")
    void logout() {
        Home home = mockUser();
        home.Login("testuser","qwer1234");
        assertEquals("bye test1",home.logout());
    }

    @Test
    @DisplayName("Already Logout Test")
    void logout_1() {
        Home home = mockUser();
        assertEquals("already logout",home.logout());
    }

    @Test
    @DisplayName("Already login in Sign up Test")
    void signUp() {
        Home home = mockUser();
        home.Login("testuser","qwer1234");
        assertEquals("already login",home.signUp("testuser","qwer1234","test1"));
    }

    @Test
    @DisplayName("Sign up success Test")
    void signUp_1() {
        Home home = mockUser();
        assertEquals("sign up success",home.signUp("testuser","qwer1234","test1"));
    }

    @Test
    @DisplayName("Sign up fail Test")
    void signUp_2() {
        Home home = mockUser();
        assertEquals("sign up fail",home.signUp("testuser","qwer1234","testuser1"));
    }


}