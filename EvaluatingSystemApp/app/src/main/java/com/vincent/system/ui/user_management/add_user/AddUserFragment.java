package com.vincent.system.ui.user_management.add_user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.vincent.system.R;
import com.vincent.system.di.component.ActivityComponent;
import com.vincent.system.ui.base.BaseFragment;
import com.vincent.system.ui.user_management.ManagementActivity;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：15:15
 */
public class AddUserFragment extends BaseFragment implements AddUserMvpView {
    @Inject
    AddUserMvpPresenter<AddUserMvpView> addUserMvpViewAddUserMvpPresenter;

    @BindView(R.id.role_spinner)
    AppCompatSpinner roleSpinner;
    @BindView(R.id.new_account)
    TextInputEditText accountInput;
    @BindView(R.id.new_nickname)
    TextInputEditText nicknameInput;

    public static AddUserFragment newInstance() {
        return new AddUserFragment();
    }

    @Override
    protected void setUp(View view) {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            addUserMvpViewAddUserMvpPresenter.onAttach(this);

        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        addUserMvpViewAddUserMvpPresenter.onDetach();
    }

    @OnClick(R.id.confirm_add_btn)
    void onAddClick(View v) {
        String role = roleSpinner.getSelectedItem().toString();
        String account = accountInput.getText().toString();
        String nickname = nicknameInput.getText().toString();
        if (isEmpty(account) || isEmpty(nickname)) {
            showMessage("账户名或者昵称不可为空!!!");
            return;
        }
        addUserMvpViewAddUserMvpPresenter.doAddUser(role.trim(), account.trim(), nickname.trim());
    }

    private boolean isEmpty(String str) {
        return str == null || str.equals("") || str.length() == 0;
    }

    @Override
    public void onAddSucceeded() {
        showMessage("用户添加成功！！！");
    }
}
