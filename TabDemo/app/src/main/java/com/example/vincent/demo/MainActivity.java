package com.example.vincent.demo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private RadioGroup mRgTab;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private int checkedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRgTab = (RadioGroup) findViewById(R.id.rg_main);
        mRgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                 checkedFragment=checkedId;
                switch (checkedId) {
                    case R.id.rb_home:
                        changeFragment(HomeFragment.class.getName());
                        break;
                    case R.id.rb_phone_book:
                        changeFragment(PhoneBookFragment.class.getName());
                        break;
                    case R.id.rb_find:
                        changeFragment(FindFragment.class.getName());
                        break;
                    case R.id.rb_me:
                        changeFragment(MeFragment.class.getName());
                        break;
                }
            }
        });
        if(savedInstanceState == null){
            changeFragment(HomeFragment.class.getName());
        }
    }

    /**
     * show target fragment
     *
     * @param tag
     */
    public void changeFragment(String tag) {
        hideFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            transaction.show(fragment);
        } else {
            if (tag.equals(HomeFragment.class.getName())) {
                fragment = HomeFragment.newInstance();
            } else if (tag.equals(PhoneBookFragment.class.getName())) {
                fragment = PhoneBookFragment.newInstance();
            } else if (tag.equals(FindFragment.class.getName())) {
                fragment = FindFragment.newInstance();
            } else if (tag.equals(MeFragment.class.getName())) {
                fragment = MeFragment.newInstance();
            }
            mFragmentList.add(fragment);
            transaction.add(R.id.fl_container, fragment, fragment.getClass().getName());
        }
        transaction.commitAllowingStateLoss();

    }

    /**
     * hide all fragment
     */
    private void hideFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        for (Fragment f : mFragmentList) {
            ft.hide(f);
        }
        ft.commit();
    }

    @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK&&checkedFragment==R.id.rb_me&&((MeFragment)getFragmentManager().findFragmentByTag(MeFragment.class.getName())).getWebView().canGoBack())
        {
            ((MeFragment)getFragmentManager().findFragmentByTag(MeFragment.class.getName())).getWebView().goBack();
             return  true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
