package com.vincent.system.ui.personal_info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.vincent.system.R;
import com.vincent.system.ui.base.BaseActivity;

import javax.inject.Inject;

public class PersonalInfoActivity extends BaseActivity implements PersonalInfoMvpView {

    @BindView(R.id.role_info)
    AppCompatTextView textViewRoleInfo;
    @BindView(R.id.nickname_info)
    AppCompatTextView textViewNickNameInfo;
    @BindView(R.id.account_info)
    AppCompatTextView textViewAccountInfo;


    private String nicknameTemp;


    @BindView(R.id.change_info_layout)
    LinearLayout infoLinearLayout;

    @BindView(R.id.info_password_change)
    EditText newPasswordText;

    @BindView(R.id.info_nickname_change)
    EditText nicknameText;


    @Inject
    PersonalInfoMvpPresenter<PersonalInfoMvpView> personalInfoMvpViewPersonalInfoMvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        personalInfoMvpViewPersonalInfoMvpPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {
        personalInfoMvpViewPersonalInfoMvpPresenter.showInfo();
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, PersonalInfoActivity.class);
    }

    @OnClick(R.id.btn_change_info)
    void onChangeInfoClick() {
        infoLinearLayout.setVisibility(infoLinearLayout.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
    }

    @OnClick(R.id.btn_confirm_change_info)
    void onConfirmChangeInfo() {

        String nickname = nicknameText.getText().toString();
        String newPwd = newPasswordText.getText().toString();
        if (newPwd == null || newPwd.length() == 0 || newPwd.equals("")) {
            showMessage("密码不能为空！！！");
            return;
        }
        if (nickname == null || nickname.length() == 0 || nickname.equals("")) {
            showMessage("昵称为空表示不更改");
            personalInfoMvpViewPersonalInfoMvpPresenter.changeInfo(nicknameTemp, newPwd);
        } else
            personalInfoMvpViewPersonalInfoMvpPresenter.changeInfo(nickname, newPwd);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        personalInfoMvpViewPersonalInfoMvpPresenter.onDetach();
    }

    @Override
    public void showInfo(String roleValue, String account, String nickname) {
        textViewRoleInfo.setText("权限：" + roleValue);
        textViewNickNameInfo.setText("昵称：" + nickname);
        textViewAccountInfo.setText("账号：" + account);
        nicknameTemp = nickname;
        infoLinearLayout.setVisibility(View.GONE);
    }
}
