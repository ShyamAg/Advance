package shyam.ram.advance.module;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import shyam.ram.advance.general.NewApplication;

@Module
public class AppModule {
    private final NewApplication newApplication;

    public AppModule(NewApplication newApplication) {
        this.newApplication = newApplication;
    }

    @Provides
    @Singleton
    Context contextProvider() {
        return newApplication;
    }

    @Provides
    @Singleton
    SharedPreferences sharedPreferenceProvider(Context context) {
        return newApplication.getSharedPreferences("New", Context.MODE_PRIVATE);
    }

}
