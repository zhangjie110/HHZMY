package com.bwei.hhzmy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwei.hhzmy.fragment.Fragment1;
import com.bwei.hhzmy.fragment.Fragment2;
import com.bwei.hhzmy.fragment.Fragment3;

/**
 * Created by zhangjie on 2016/11/17.
 */
public class MyShopFPagerAdapter extends FragmentPagerAdapter {

    public MyShopFPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f=null;
        switch (position){
            case 0:
                f=new Fragment1();
                break;
            case 1:
                f=new Fragment2();
                break;
            case 2:
                f=new Fragment3();
                break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
