package com.vincent.system.ui.user_management;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.vincent.system.ui.user_management.add_user.AddUserFragment;
import com.vincent.system.ui.user_management.user_info.UserFragment;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：21:06
 */
public class ManagementPagerAdapter extends FragmentStatePagerAdapter {
    private int mTabCount;

    public ManagementPagerAdapter(FragmentManager fm) {
        super(fm);
        mTabCount = 0;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return UserFragment.newInstance(UserFragment.SUPER);
            case 1:
                return UserFragment.newInstance(UserFragment.NORMAL);
            case 2:
                return AddUserFragment.newInstance();
            default:
                return null;
        }

    }


    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setTabCount(int mTabCount) {
        this.mTabCount = mTabCount;
    }
}
