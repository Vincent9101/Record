
package com.vincent.system.di.module;

import android.app.Application;
import android.content.Context;
import com.vincent.system.BuildConfig;
import com.vincent.system.R;
import com.vincent.system.data.AppDataManager;
import com.vincent.system.data.DataManager;
import com.vincent.system.data.db.AppDbHelper;
import com.vincent.system.data.db.DbHelper;
import com.vincent.system.data.network.ApiHeader;
import com.vincent.system.data.network.ApiHelper;
import com.vincent.system.data.network.AppApiHelper;
import com.vincent.system.data.prefs.AppPreferencesHelper;
import com.vincent.system.data.prefs.PreferencesHelper;
import com.vincent.system.di.ApiInfo;
import com.vincent.system.di.ApplicationContext;
import com.vincent.system.di.DatabaseInfo;
import com.vincent.system.di.PreferenceInfo;
import com.vincent.system.util.AppConstants;
import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import javax.inject.Singleton;


@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
