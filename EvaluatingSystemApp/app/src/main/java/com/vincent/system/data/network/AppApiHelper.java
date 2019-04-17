package com.vincent.system.data.network;

import com.google.gson.reflect.TypeToken;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.vincent.system.data.network.model.*;
import com.vincent.system.data.network.model.patient.AddPatientRequest;
import com.vincent.system.data.network.model.patient.DeletePatientRequest;
import com.vincent.system.data.network.model.patient.PatientRecordListResponse;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }


    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                              request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<ChangeInfoResponse> doChangeInfo(ChangeInfoRequest request) {
        return Rx2AndroidNetworking.put(ApiEndPoint.ENDPOINT_INFO)
                .addBodyParameter(request)
                .addHeaders(getApiHeader())
                .build()
                .getObjectSingle(ChangeInfoResponse.class);
    }

    @Override
    public Single<UserInfoResponse> doGetUserInfo() {


        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_USER_MANAGEMENT)
                .addHeaders(getApiHeader())
                .build()
                .getObjectSingle(UserInfoResponse.class);

    }

    @Override
    public Single<NormalResponse> doLogOff() {
        return Rx2AndroidNetworking.delete(ApiEndPoint.ENDPOINT_LOGOFF)
                .addHeaders(getApiHeader())
                .build()
                .getObjectSingle(NormalResponse.class);
    }

    @Override
    public Single<NormalResponse> doAddUser(AddUserRequest addUserRequest) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_USER_MANAGEMENT)
                .addBodyParameter(addUserRequest)
                .addHeaders(getApiHeader())
                .build()
                .getObjectSingle(NormalResponse.class);
    }

    @Override
    public Single<PatientRecordListResponse> doGetPatientRecord() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_PATIENT_RECORD)
                .addHeaders(getApiHeader())
                .build()
                .getParseSingle(TypeToken.get(PatientRecordListResponse.class));
    }

    @Override
    public Single<NormalResponse> doDeletePatientRecord(DeletePatientRequest deletePatientRequest) {
        return Rx2AndroidNetworking.delete(ApiEndPoint.ENDPOINT_PATIENT_RECORD)
                .addBodyParameter(deletePatientRequest)
                .addHeaders(getApiHeader())
                .build()
                .getObjectSingle(NormalResponse.class);
    }

    @Override
    public Single<NormalResponse> doAddPatientRecord(AddPatientRequest addPatientRequest) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_PATIENT_RECORD)
                .addBodyParameter(addPatientRequest)
                .addHeaders(getApiHeader())
                .build()
                .getObjectSingle(NormalResponse.class);
    }
}


