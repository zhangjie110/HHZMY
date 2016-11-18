package com.bwei.hhzmy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.bean.Bean;
import com.bwei.hhzmy.tools.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by zhangjie on 2016/11/14.
 */
public class MyShouYeGridAdapter extends BaseAdapter{

    private Context context;
    private List<Bean.DataBean.TagBean> list;
    private ImageLoader loader;

    public MyShouYeGridAdapter(Context context, List<Bean.DataBean.TagBean> list) {
        this.context = context;
        this.list = list;
        loader=ImageLoader.getInstance();
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
        ViewHolder holder=null;
        if (view==null){
            view=View.inflate(context, R.layout.grid_shouye_item,null);
            holder=new ViewHolder();
            holder.tv= (TextView) view.findViewById(R.id.tv_grid_shouye);
            holder.iv=(ImageView) view.findViewById(R.id.iv_grid_shouye);
            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }
        holder.tv.setText(list.get(i).getElementName());
        loader.displayImage("http://image1.suning.cn/"+list.get(i).getPicUrl(),holder.iv, ImageLoaderUtils.initOptions());


        return view;
    }
}

class ViewHolder{
    TextView tv;
    ImageView iv;
}