public class RegistrationUser {
    String login;
    String password;

    String status;
    public String getLogin() {
        return login;
    }



    public String getPassword() {
        return password;
    }




    public RegistrationUser(String randomLogin, String randomPassword, String status) {
        this.login = randomLogin;
        this.password = randomPassword;
        this.status = status;
    }


}
