package co.quipux.models;

import co.quipux.utils.BaseConfig;

public class LoginData extends BaseConfig {

    private String email;
    private String password;


    public LoginData(String email, String password) {
        super(LoginData.class);
        this.email = email;
        this.password = password;
        BaseConfig.log.info("User information setup ["+this.getClass().getName()+"]");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
