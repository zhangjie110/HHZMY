package com.bwei.hhzmy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.activity.WebViewActivity;
import com.bwei.hhzmy.bean.Bean;
import com.bwei.hhzmy.tools.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


/**
 * Created by zhangjie on 2016/11/9.
 */
public class MyShouYePagerAdapter extends PagerAdapter {

    private Context context;
    private List<Bean.DataBean.TagBean> list;
    private ImageLoader loader;

    public MyShouYePagerAdapter(Context context, List<Bean.DataBean.TagBean> list) {
        this.context = context;
        this.list = list;
        loader=ImageLoader.getInstance();
    }


    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position=position%list.size();
        View view=View.inflate(context, R.layout.pager_shouye_item,null);
        ImageView iv=(ImageView) view.findViewById(R.id.iv_pager_shouye);
        loader.displayImage("http://image1.suning.cn/"+list.get(position).getPicUrl(),iv, ImageLoaderUtils.initOptions());
        container.addView(view);
        final int finalPosition = position;
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, WebViewActivity.class);
                intent.putExtra("地址",list.get(finalPosition).getLinkUrl());
                context.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
