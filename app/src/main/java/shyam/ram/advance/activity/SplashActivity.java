package shyam.ram.advance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import shyam.ram.advance.R;
import shyam.ram.advance.general.SharedPreference;

import static android.provider.Settings.Secure.ANDROID_ID;

public class SplashActivity extends AppCompatActivity {
    String deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deviceId = Settings.Secure.getString(this.getContentResolver(),
                ANDROID_ID);
        prepareLayout();
    }

    private void prepareLayout() {
        setContentView(R.layout.activity_splash);
        ImageView splash = (ImageView) findViewById(R.id.splash);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_animate);
        splash.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                gotoNext();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void gotoNext() {
        SharedPreference.instance(this);
        if (SharedPreference.isLogin(this)) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        finish();
    }

}
