package shyam.ram.advance.interfaces;

import javax.inject.Singleton;

import dagger.Component;
import shyam.ram.advance.activity.MainActivity;
import shyam.ram.advance.general.NewApplication;
import shyam.ram.advance.module.AppModule;

@Singleton
@Component(modules = {AppModule.class
})
public interface AppComponent {
    void inject(NewApplication newApplication);
    void inject(MainActivity mainActivity);
}
