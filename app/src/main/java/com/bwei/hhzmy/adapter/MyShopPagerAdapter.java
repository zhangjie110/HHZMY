package com.bwei.hhzmy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwei.hhzmy.fragment.DetailsFragment;
import com.bwei.hhzmy.fragment.EvaluateFragment;
import com.bwei.hhzmy.fragment.ShopFragment;

/**
 * Created by zhangjie on 2016/11/16.
 */
public class MyShopPagerAdapter extends FragmentPagerAdapter {

    public MyShopPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f=null;
        switch (position){
            case 0:
                f=new ShopFragment();
                break;
            case 1:
                f=new DetailsFragment();
                break;
            case 2:
                f=new EvaluateFragment();
                break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
