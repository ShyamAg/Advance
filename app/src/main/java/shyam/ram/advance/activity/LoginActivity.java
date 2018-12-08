package shyam.ram.advance.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.widget.Toast;

import shyam.ram.advance.R;
import shyam.ram.advance.databinding.LoginBinding;
import shyam.ram.advance.general.AndroidPermissions;
import shyam.ram.advance.general.C;
import shyam.ram.advance.model.Login;
import shyam.ram.advance.view_model.LoginView;

public class LoginActivity extends BaseActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = LoginActivity.this;
        if (!AndroidPermissions.checkLocationPermission(this)) {
            AndroidPermissions.permissions(this);
        }

        final LoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout._login);
        final LoginView loginView = new LoginView(new Login("Username", "Password"));
        loginBinding.setHint(loginView);
        loginBinding.setInterfaces(new shyam.ram.advance.interfaces.Login() {
            @Override
            public void onClickLogin() {
                if (C.isConnected(LoginActivity.this)) {
                    if(loginView.loginUpdate(context,loginBinding.etPassword.getText().toString(),loginBinding.etName.getText().toString()))
                        finish();
//                    Toast.makeText(LoginActivity.this, "Yes " + loginBinding.etPassword.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
//        loginBinding
    }
}
