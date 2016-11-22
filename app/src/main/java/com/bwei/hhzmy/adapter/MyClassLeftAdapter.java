package com.bwei.hhzmy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.bean.MyBean;

import java.util.List;


/**
 * Created by zhangjie on 2016/11/22.
 */
public class MyClassLeftAdapter extends RecyclerView.Adapter<MyClassLeftAdapter.MyLiftViewHolder> {

    private final Context context;
    private final List<MyBean.RsBean> list;

    public MyClassLeftAdapter(Context context, List<MyBean.RsBean> list) {
        this.context=context;
        this.list=list;

    }

    @Override
    public MyClassLeftAdapter.MyLiftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view=View.inflate(context, R.layout.recycler_lift_item,null);
        MyLiftViewHolder holder=new MyLiftViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(final MyLiftViewHolder holder, int position) {
        holder.tv.setText(list.get(position).dirName);

        //判断是否选中改变选中颜色
        if (list.get(position).ischeck){
            holder.tvimage.setVisibility(View.VISIBLE);
            holder.tv.setBackgroundResource(R.color.tabitem);
            holder.tv.setTextColor(0xFFF29400);
        }else{
            holder.tvimage.setVisibility(View.GONE);
            holder.tv.setBackgroundResource(R.color.tabwite);
            holder.tv.setTextColor(Color.BLACK);
        }



        //如果设置回调，则设置点击事件
        if(onItemClickLitener!=null){
            //设置点击
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=holder.getLayoutPosition();
                    onItemClickLitener.onItemClick(holder.itemView,pos);
                }
            });
            //长按事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {

                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getLayoutPosition();
                    onItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    /**
     * 设置监听
     */
    public interface OnItemClickLitener{
        void onItemClick(View view,int positon);
        void onItemLongClick(View view,int position);
    }

    private OnItemClickLitener onItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener){
        this.onItemClickLitener=onItemClickLitener;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyLiftViewHolder extends RecyclerView.ViewHolder{

        TextView tvimage;
        TextView tv;

        public MyLiftViewHolder(View itemView) {
            super(itemView);
            tv=(TextView) itemView.findViewById(R.id.left_name);
            tvimage=(TextView) itemView.findViewById(R.id.recycle_line_iamge);
        }

    }
}

