package Proyecto_AD_UD1.model;

public class Session {
    private User user;

    public Session() {
        this.user = null;
    }

    public boolean login(String username, String pass, Users users) {
        User user = users.getUser(username);
        if(user == null){
            return false;
        }
        boolean ok = user.checkPassword(pass);
        if(ok){
            this.user = user;
        }
        return ok;
    }

    public void logout(){
        this.user = null;
    }


}
