package WebService;

public class Home {
    public boolean isLogin = false;
    public User user;

    public void setUser(User user){
        this.user = user;
    }

    public String Login(String id, String pass){
        if (!isLogin){
            if(checkUser(id,pass) != null){
                isLogin = true;
                user.setUser(checkUser(id,pass));
                return "Login Success";
            }
            return "Wrong id or password";
        }
        else{
            return "already login";
        }
    }

    public String logout(){
        if (isLogin){
            isLogin = false;
            String userName = user.getUserName();
            user = null;
            return "bye " +userName ;
        }
        else{
            return "already logout";
        }
    }

    public String signUp(String id,String pass, String userName){
        if (isLogin){
            return "already login";
        }
        UserDao newUser = new UserDao(id,pass,userName);
        if(newUser.checkUserInfo()){
            isLogin = true;
            user.setUser(newUser);
            return "sign up success";
        }
        return "sign up fail";
    }

    private UserDao checkUser(String id, String pass){

        UserDao userInfo = user.getUserById(id);
        if (userInfo.id == id && userInfo.pass == pass){
            return userInfo;
        }
        return null;
    }
}
