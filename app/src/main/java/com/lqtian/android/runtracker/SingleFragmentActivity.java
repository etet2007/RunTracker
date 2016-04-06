package com.lqtian.android.runtracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * 我们设置从activity_fragment.xml布局里生成activity视图。然后在容器中寻找
 *FragmentManager里的fragment。如fragment不存在，则创建一个新的fragment
 *并将其添加到容器中。
 * Created by Administrator on 2016/1/15 0015.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    protected int getLayoutResId(){
        return R.layout.activity_fragment;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        FragmentManager fm = getSupportFragmentManager();//因为使用的是支持库的，不然可以使用getFragmentManager
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);//容器资源Id是FragmentManager中fragment的唯一标识符

        if (fragment == null) {
            fragment=createFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer,fragment)//在哪个容器显示哪个fragment
                    .commit();
        }

    }
}