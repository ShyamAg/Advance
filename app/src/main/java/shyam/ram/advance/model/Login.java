package shyam.ram.advance.model;

public class Login {
    private String username,password;
    public String usernameHint;
    public String passwordHint;


    public Login(String usernameHint, String passwordHint) {
        this.usernameHint = usernameHint;
        this.passwordHint = passwordHint;
    }

    public Login() {
    }
}
