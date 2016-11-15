package com.bwei.hhzmy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bwei.hhzmy.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by zhangjie on 2016/11/15.
 */
public class MyShouYeListAdapter extends BaseAdapter {

    private Context context;/*
    private List<Bean.DataBean.TagBean> list_;
    private List<Bean.DataBean.TagBean> tag24;
    private List<Bean.DataBean.TagBean> list_;
    private List<Bean.DataBean.TagBean> list_;
    private List<Bean.DataBean.TagBean> list_;*/
    private List<Bean.DataBean.TagBean> list_;
    private ImageLoader loader;

    public MyShouYeListAdapter(Context context, List<Bean.DataBean.TagBean> list_) {
        this.context = context;
        this.list_ = list_;
        loader=loader.getInstance();
    }

    @Override
    public int getCount() {
        return list_.size();
    }

    @Override
    public Object getItem(int i) {
        return list_.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        return null;
    }
}
