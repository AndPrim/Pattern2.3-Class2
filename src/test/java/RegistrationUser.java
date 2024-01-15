public class RegistrationUser {
    String login;
    String password;

    String status;
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public RegistrationUser(String randomLogin, String randomPassword, String status) {
        this.login = randomLogin;
        this.password = randomPassword;
        this.status = status;
    }


}
