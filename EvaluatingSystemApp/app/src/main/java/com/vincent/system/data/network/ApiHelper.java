package com.vincent.system.data.network;


import com.vincent.system.data.network.model.*;
import com.vincent.system.data.network.model.patient.AddPatientRequest;
import com.vincent.system.data.network.model.patient.DeletePatientRequest;
import com.vincent.system.data.network.model.patient.PatientRecordListResponse;
import io.reactivex.Single;


public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<ChangeInfoResponse> doChangeInfo(ChangeInfoRequest request);

    public Single<UserInfoResponse> doGetUserInfo();

    public Single<NormalResponse> doLogOff();

    public Single<NormalResponse> doAddUser(AddUserRequest addUserRequest);

    public Single<PatientRecordListResponse> doGetPatientRecord();

    public Single<NormalResponse> doDeletePatientRecord(DeletePatientRequest deletePatientRequest);

    public Single<NormalResponse> doAddPatientRecord(AddPatientRequest addPatientRequest);
}
