package com.vincent.system.ui.user_management.user_info;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vincent.system.R;
import com.vincent.system.data.network.model.UserInfoResponse;
import com.vincent.system.di.component.ActivityComponent;
import com.vincent.system.ui.base.BaseFragment;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：21:20
 */
public class UserFragment extends BaseFragment implements UserMvpView {

    public static final int SUPER = 100;
    public static final int NORMAL = 101;

    private final int type;
    @Inject
    UserMvpPresenter<UserMvpView> superMvpViewUserMvpPresenter;
    @Inject
    LinearLayoutManager mLayoutManager;

    private UserAdapter userAdapter = new UserAdapter();

    @BindView(R.id.user_recycler_view)
    RecyclerView recyclerView;

    public static Fragment newInstance(int userType) {
        Bundle args = new Bundle();
        UserFragment fragment = new UserFragment(userType);
        fragment.setArguments(args);
        return fragment;

    }

    public UserFragment() {
        super();
        type = NORMAL;
    }

    @SuppressLint("ValidFragment")
    public UserFragment(int type) {
        super();
        this.type = type;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            superMvpViewUserMvpPresenter.onAttach(this);
            superMvpViewUserMvpPresenter.doGetUserInfo(type);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        superMvpViewUserMvpPresenter.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        superMvpViewUserMvpPresenter.doGetUserInfo(type);
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);
    }


    @Override
    public void updateUserInfos(List<UserInfoResponse.UserInfo> userInfoList) {
        userAdapter.updateList(userInfoList);
    }
}
