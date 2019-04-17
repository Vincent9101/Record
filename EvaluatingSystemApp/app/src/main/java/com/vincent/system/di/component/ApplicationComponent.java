package com.vincent.system.di.component;

import android.app.Application;
import android.content.Context;
import com.vincent.system.EvaluatingSystemApp;
import com.vincent.system.data.DataManager;
import com.vincent.system.di.ApplicationContext;
import com.vincent.system.di.module.ApplicationModule;
import dagger.Component;

import javax.inject.Singleton;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(EvaluatingSystemApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
