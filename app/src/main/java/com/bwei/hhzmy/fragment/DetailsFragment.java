package com.bwei.hhzmy.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.adapter.MyShopFPagerAdapter;
import com.bwei.hhzmy.view.MyViewPgaer;

/**
 * Created by zhangjie on 2016/11/16.
 */
public class DetailsFragment extends Fragment{

    private TextView tv_xiangping;
    private TextView tv_canshu;
    private TextView tv_shouhou;

    private MyViewPgaer vp;
    private MyShopFPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.detailsfragment,null);
        tv_xiangping=(TextView) view.findViewById(R.id.tv_xiangping);
        tv_canshu=(TextView) view.findViewById(R.id.tv_canshu);
        tv_shouhou=(TextView) view.findViewById(R.id.tv_shouhou);
        vp=(MyViewPgaer) view.findViewById(R.id.shop_vp);

        adapter=new MyShopFPagerAdapter(getChildFragmentManager());
        vp.setAdapter(adapter);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 0:
                        tv_xiangping.setTextColor(Color.YELLOW);
                        tv_canshu.setTextColor(Color.BLACK);
                        tv_shouhou.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        tv_xiangping.setTextColor(Color.BLACK);
                        tv_canshu.setTextColor(Color.YELLOW);
                        tv_shouhou.setTextColor(Color.BLACK);
                        break;
                    case 2:
                        tv_xiangping.setTextColor(Color.BLACK);
                        tv_canshu.setTextColor(Color.BLACK);
                        tv_shouhou.setTextColor(Color.YELLOW);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tv_xiangping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(0);
            }
        });
        tv_canshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(1);
            }
        });
        tv_shouhou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(2);
            }
        });
        return view;
    }


}
