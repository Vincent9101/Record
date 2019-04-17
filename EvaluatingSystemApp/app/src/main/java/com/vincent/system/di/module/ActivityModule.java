
package com.vincent.system.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.vincent.system.di.ActivityContext;
import com.vincent.system.di.PerActivity;
import com.vincent.system.ui.assessment.AssessmentMvpPresenter;
import com.vincent.system.ui.assessment.AssessmentMvpView;
import com.vincent.system.ui.assessment.AssessmentPresenter;
import com.vincent.system.ui.assessment.business.AddPatientMvpPresenter;
import com.vincent.system.ui.assessment.business.AddPatientMvpView;
import com.vincent.system.ui.assessment.business.AddPatientPresenter;
import com.vincent.system.ui.home.HomeMvpPresenter;
import com.vincent.system.ui.home.HomeMvpView;
import com.vincent.system.ui.home.HomePresenter;
import com.vincent.system.ui.login.LoginMvpPresenter;
import com.vincent.system.ui.login.LoginMvpView;
import com.vincent.system.ui.login.LoginPresenter;
import com.vincent.system.ui.personal_info.PersonalInfoMvpPresenter;
import com.vincent.system.ui.personal_info.PersonalInfoMvpView;
import com.vincent.system.ui.personal_info.PersonalInfoPresenter;
import com.vincent.system.ui.user_management.ManagementMvpPresenter;
import com.vincent.system.ui.user_management.ManagementMvpView;
import com.vincent.system.ui.user_management.ManagementPagerAdapter;
import com.vincent.system.ui.user_management.ManagementPresenter;
import com.vincent.system.ui.user_management.add_user.AddUserMvpPresenter;
import com.vincent.system.ui.user_management.add_user.AddUserMvpView;
import com.vincent.system.ui.user_management.add_user.AddUserPresenter;
import com.vincent.system.ui.user_management.user_info.UserMvpPresenter;
import com.vincent.system.ui.user_management.user_info.UserMvpView;
import com.vincent.system.ui.user_management.user_info.UserPresenter;
import com.vincent.system.util.rx.AppSchedulerProvider;
import com.vincent.system.util.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }


    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    UserMvpPresenter<UserMvpView> provideSuperPresenter(UserPresenter<UserMvpView> userPresenter) {
        return userPresenter;
    }

    @Provides
    AddUserMvpPresenter<AddUserMvpView> provideAddUserPresenter(AddUserPresenter<AddUserMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    AssessmentMvpPresenter<AssessmentMvpView> provideAssessmentPresenter(AssessmentPresenter<AssessmentMvpView> assessmentMvpViewAssessmentPresenter) {
        return assessmentMvpViewAssessmentPresenter;
    }

    @Provides
    @PerActivity
    AddPatientMvpPresenter<AddPatientMvpView> provideAddPatientPresenter(AddPatientPresenter<AddPatientMvpView> addPatientMvpViewAddPatientPresenter) {
        return addPatientMvpViewAddPatientPresenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    HomeMvpPresenter<HomeMvpView> provideHomePresenter(
            HomePresenter<HomeMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    PersonalInfoMvpPresenter<PersonalInfoMvpView> providePersonalInfoPresenter(PersonalInfoPresenter<PersonalInfoMvpView> personalInfoMvpViewPersonalInfoPresenter) {
        return personalInfoMvpViewPersonalInfoPresenter;

    }


    @Provides
    @PerActivity
    ManagementMvpPresenter<ManagementMvpView> provideManagementPresenter(ManagementPresenter<ManagementMvpView> managementMvpViewManagementPresenter) {
        return managementMvpViewManagementPresenter;
    }

    @Provides
    ManagementPagerAdapter provideManagementPagerAdapter(AppCompatActivity activity) {
        return new ManagementPagerAdapter(activity.getSupportFragmentManager());
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

}
