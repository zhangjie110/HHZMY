package com.bwei.hhzmy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.bean.MyBean;
import com.bwei.hhzmy.tools.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by zhangjie on 2016/11/22.
 */
public class MyClassRightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final Context context;
    private final List<MyBean.RsBean.ChildrenBean> children;
    private final int HEADER=1;
    private final int CONTENT=2;
    private ImageLoader loader;

    public MyClassRightAdapter(Context context, List<MyBean.RsBean.ChildrenBean> children) {
        this.context = context;
        this.children = children;
        loader=ImageLoader.getInstance();
    }

    /*通过判断返回布局类型，显示布局数目 */
    @Override
    public int getItemViewType(int position) {
        if(children.get(position).isHeader){//是否为头部布局
            return HEADER;
        }else {
            return CONTENT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //判断加载布局
        if (viewType==HEADER) {
            HeaderViewHolder headerViewHolder=new HeaderViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.recycler_right_header,parent,false));
            return headerViewHolder;
        }else if (viewType==CONTENT){
            MyViewHolder1 contentViewHolder=new MyViewHolder1(LayoutInflater.from(context)
                    .inflate(R.layout.recycler_right_item,parent,false));
            return contentViewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //设置数据   判断holder是哪个布局中的控件  进行数据展示
        if (holder instanceof HeaderViewHolder){
            ((HeaderViewHolder) holder).tv.setText(children.get(position).dirName);
        }else if (holder instanceof MyViewHolder1){
            ((MyViewHolder1) holder).tv.setText(children.get(position).dirName);
            loader.displayImage(children.get(position).imgApp,((MyViewHolder1) holder).imageView, ImageLoaderUtils.initOptions());

            //加载图片
            /*Glide.with(context)
                    .load(children.get(position).imgApp)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(((MyViewHolder1) holder).imageView);*/
        }
    }


    @Override
    public int getItemCount() {
        return children.size();
    }
}

class HeaderViewHolder extends RecyclerView.ViewHolder{

    TextView tv;

    public HeaderViewHolder(View itemView) {
        super(itemView);

        tv = (TextView) itemView.findViewById(R.id.tv_header);
    }
}

class MyViewHolder1 extends RecyclerView.ViewHolder{
    TextView tv;
    ImageView imageView;

    public MyViewHolder1(View itemView) {
        super(itemView);
        tv=(TextView) itemView.findViewById(R.id.right_name);
        imageView=(ImageView) itemView.findViewById(R.id.right_image);

    }
}