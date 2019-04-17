package com.vincent.system.ui.user_management.user_info;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vincent.system.R;
import com.vincent.system.data.network.model.UserInfoResponse;
import com.vincent.system.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：22:38
 */
public class UserAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int SUPER = 0;
    public static final int NORMAL = 1;


    private List<UserInfoResponse.UserInfo> userInfoList = new ArrayList<>();

    public void updateList(List<UserInfoResponse.UserInfo> list) {
        userInfoList.clear();
        userInfoList.addAll(list);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_user_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {

        baseViewHolder.onBind(i);
    }


    @Override
    public int getItemCount() {
        return userInfoList.size();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.recycler_item_role)
        TextView roleText;
        @BindView(R.id.recycler_item_account)
        TextView accountText;
        @BindView(R.id.recycler_item_nickname)
        TextView nicknameText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
            roleText.setText("");
            accountText.setText("");
            nicknameText.setText("");
        }

        @Override
        public void onBind(int position) {
            UserInfoResponse.UserInfo userInfo = userInfoList.get(position);
            roleText.setText("用户类型：" + userInfo.getRoleValue());
            accountText.setText("账户：" + userInfo.getAccount());
            nicknameText.setText("昵称：" + userInfo.getNickname());
            //初始化数据
        }

    }
}
