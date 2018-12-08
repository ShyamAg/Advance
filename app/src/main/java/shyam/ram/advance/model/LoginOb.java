package shyam.ram.advance.model;

import android.databinding.ObservableField;

public class LoginOb {
//    private String username,password;
    public String usernameHint;
    public String passwordHint;

    public ObservableField<String> getUsername() {
        return username;
    }

    public ObservableField<String> getPassword() {
        return password;
    }

    public final ObservableField<String> username =  new ObservableField<>("");
    public final ObservableField<String> password = new ObservableField<>("");
    public LoginOb(String usernameHint, String passwordHint) {
        this.usernameHint = usernameHint;
        this.passwordHint = passwordHint;
    }

    public LoginOb() {
    }
}
