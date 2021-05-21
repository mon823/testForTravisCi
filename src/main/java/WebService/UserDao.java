package WebService;

public class UserDao {
    public String id;
    public String pass;
    public String userName;

    UserDao (String id,String pass, String userName) {
        this.id = id;
        this.pass = pass;
        this.userName = userName;
    }

    public boolean checkUserInfo(){
        if (checkId(id) && checkPass(pass) && checkUserName(userName)) {
            return true;
        }
        return false;
    }

    private boolean checkId(String id){
        if(!(id.length() > 6 && id.length() < 14)){
            return false;
        }

        return true;
    }

    private boolean checkPass(String pass){
        if(! (pass.length() >= 8)){
            return false;
        }

        return true;
    }

    private boolean checkUserName(String userName){
        if(! (userName.length() < 8)){
            return false;
        }

        return true;
    }

}
