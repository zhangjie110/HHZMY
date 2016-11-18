package com.bwei.hhzmy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.bean.Bean;
import com.bwei.hhzmy.tools.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by zhangjie on 2016/11/15.
 */
public class MyShouGridAdapter1 extends BaseAdapter {

    private List<Bean.DataBean.TagBean> list;
    private Context context;
    private ImageLoader imageLoader;

    public MyShouGridAdapter1(List<Bean.DataBean.TagBean> list, Context context) {
        this.list = list;
        this.context = context;
        imageLoader=ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 holder=null;
        if (view==null){
            view=View.inflate(context, R.layout.grid_shouye_item1,null);
            holder=new ViewHolder1();
            holder.iv=(ImageView) view.findViewById(R.id.iv_shouye_grid);
            view.setTag(holder);
        }else{
            holder=(ViewHolder1) view.getTag();
        }

        imageLoader.displayImage("http://image1.suning.cn/"+list.get(i).getPicUrl(),holder.iv, ImageLoaderUtils.initOptions());


        return view;
    }
}

class ViewHolder1{
    ImageView iv;
}