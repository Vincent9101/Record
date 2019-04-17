package com.vincent.system.data;

import android.content.Context;
import com.vincent.system.data.db.DbHelper;
import com.vincent.system.data.network.ApiHeader;
import com.vincent.system.data.network.ApiHelper;
import com.vincent.system.data.network.model.*;
import com.vincent.system.data.network.model.patient.AddPatientRequest;
import com.vincent.system.data.network.model.patient.DeletePatientRequest;
import com.vincent.system.data.network.model.patient.PatientRecordListResponse;
import com.vincent.system.data.prefs.PreferencesHelper;
import com.vincent.system.di.ApplicationContext;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }


    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().setToken(accessToken);
    }


    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return mApiHelper.doServerLoginApiCall(request);
    }

    @Override
    public Single<ChangeInfoResponse> doChangeInfo(ChangeInfoRequest request) {
        return mApiHelper.doChangeInfo(request);
    }

    @Override
    public Single<UserInfoResponse> doGetUserInfo() {
        return mApiHelper.doGetUserInfo();
    }

    @Override
    public Single<NormalResponse> doLogOff() {
        return mApiHelper.doLogOff();
    }

    @Override
    public Single<NormalResponse> doAddUser(AddUserRequest addUserRequest) {
        return mApiHelper.doAddUser(addUserRequest);
    }

    @Override
    public Single<PatientRecordListResponse> doGetPatientRecord() {
        return mApiHelper.doGetPatientRecord();
    }

    @Override
    public Single<NormalResponse> doDeletePatientRecord(DeletePatientRequest deletePatientRequest) {
        return mApiHelper.doDeletePatientRecord(deletePatientRequest);
    }

    @Override
    public Single<NormalResponse> doAddPatientRecord(AddPatientRequest addPatientRequest) {
        return mApiHelper.doAddPatientRecord(addPatientRequest);
    }


    @Override
    public String getRoleValue() {
        return mPreferencesHelper.getRoleValue();
    }

    @Override
    public void setRoleValue(String roleValue) {
        mPreferencesHelper.setRoleValue(roleValue);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }


    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserAccount() {
        return mPreferencesHelper.getCurrentUserAccount();
    }

    @Override
    public void setCurrentUserAccount(String account) {
        mPreferencesHelper.setCurrentUserAccount(account);
    }


    @Override
    public void updateApiHeader(String accessToken) {
        mApiHelper.getApiHeader().setToken(accessToken);
        ;
    }

    @Override
    public void updateUserInfo(String accessToken,
                               LoggedInMode loggedInMode,
                               String userName,
                               String account,
                               String roleValue) {
        setAccessToken(accessToken);
        setCurrentUserAccount(account);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setRoleValue(roleValue);
        updateApiHeader(accessToken);
    }


}
