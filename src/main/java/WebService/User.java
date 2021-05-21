package WebService;

public interface User {
    public UserDao getUserById(String id);
    public void setUser(UserDao user);
    public String getUserName();
}
