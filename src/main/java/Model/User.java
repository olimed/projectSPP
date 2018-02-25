package Model;

public class User {
    private int user_id;
    private String user_login;
    private String user_password;
    private String user_name;
    private String usre_mail;
    private String usre_telephone;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUsre_mail() {
        return usre_mail;
    }

    public void setUsre_mail(String usre_mail) {
        this.usre_mail = usre_mail;
    }

    public String getUsre_telephone() {
        return usre_telephone;
    }

    public void setUsre_telephone(String usre_telephone) {
        this.usre_telephone = usre_telephone;
    }
}
