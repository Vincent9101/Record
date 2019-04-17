package com.vincent.system.di.component;

import com.vincent.system.di.PerActivity;
import com.vincent.system.di.module.ActivityModule;
import com.vincent.system.ui.assessment.AssessmentActivity;
import com.vincent.system.ui.assessment.business.AddPatientRecordActivity;
import com.vincent.system.ui.home.HomeActivity;
import com.vincent.system.ui.login.LoginActivity;
import com.vincent.system.ui.personal_info.PersonalInfoActivity;
import com.vincent.system.ui.user_management.ManagementActivity;
import com.vincent.system.ui.user_management.add_user.AddUserFragment;
import com.vincent.system.ui.user_management.user_info.UserFragment;
import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


    void inject(LoginActivity activity);

    void inject(HomeActivity homeActivity);

    void inject(PersonalInfoActivity personalInfoActivity);

    void inject(ManagementActivity managementActivity);

    void inject(UserFragment userFragment);

    void inject(AddUserFragment addUserFragment);

    void inject(AssessmentActivity assessmentActivity);

    void inject(AddPatientRecordActivity addPatientRecordActivity);

}
