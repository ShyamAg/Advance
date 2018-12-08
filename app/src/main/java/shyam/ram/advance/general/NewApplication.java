package shyam.ram.advance.general;

import android.app.Application;

import shyam.ram.advance.interfaces.AppComponent;
import shyam.ram.advance.interfaces.DaggerAppComponent;
import shyam.ram.advance.module.AppModule;

public class NewApplication extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().appModule(new AppModule(this)).build().inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
