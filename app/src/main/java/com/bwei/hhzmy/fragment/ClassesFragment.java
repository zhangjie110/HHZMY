package com.bwei.hhzmy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.activity.SousuoActivity;
import com.bwei.hhzmy.adapter.DividerItemDecoration;
import com.bwei.hhzmy.adapter.MyClassLeftAdapter;
import com.bwei.hhzmy.adapter.MyClassRightAdapter;
import com.bwei.hhzmy.bean.MyBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhangjie on 2016/11/7.
 */
public class ClassesFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll;
    private RecyclerView left;
    private RecyclerView right;
    private List<MyBean.RsBean> list=new ArrayList<>();
    private ArrayList<MyBean.RsBean.ChildrenBean> childrenList=new ArrayList<>();
    private MyClassLeftAdapter adapter;
    private MyClassRightAdapter contextAdapter;
    private int index=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2,container,false);
        ll=(LinearLayout) view.findViewById(R.id.ll_fen);
        left=(RecyclerView) view.findViewById(R.id.left);
        right=(RecyclerView) view.findViewById(R.id.right);

        initData();
        initsetleftrecycler();
        initsetrightrecycler();
        ll.setOnClickListener(this);
        return view;
    }

    /**
     * 右边内容设置
     */
    private void initsetrightrecycler() {
        GridLayoutManager manager=new GridLayoutManager(getActivity(),3);
        //设置布局管理器
        right.setLayoutManager(manager);
        //设置垂直
        manager.setOrientation(OrientationHelper.VERTICAL);
        //设置只有字体占行数
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //判断是否为标题 ，是 返回3   否  返回1
                return childrenList.get(position).isHeader?3:1;
            }
        });
        //默认将第一个数据进行遍历展示
        List<MyBean.RsBean.ChildrenBean>  childrenBeanList=list.get(0).children;
        for (int i = 0; i < childrenBeanList.size(); i++) {
            childrenBeanList.get(i).isHeader = true;
            childrenList.add(childrenBeanList.get(i));
            childrenList.addAll(childrenBeanList.get(i).children);
        }

        //设置适配器
        contextAdapter = new MyClassRightAdapter(getActivity(),childrenList);
        right.setAdapter(contextAdapter);
    }
    /**
     * 获取数据
     */
    private void initData() {
        try {
            //读取本地文件
            InputStream inputStream = getResources().getAssets().open("category.txt");

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String str = null;
            while((str = br.readLine())!=null){
                stringBuffer.append(str);
            }
            str=stringBuffer.toString();
            Log.e("bean---------",str);
            Gson gson=new Gson();
            MyBean myBean = gson.fromJson(str, MyBean.class);

            list.addAll(myBean.rs);
            //默认第一个选中
            list.get(0).ischeck=true;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 左边内容设置
     */
    private void initsetleftrecycler() {
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        //设置布局管理器
        left.setLayoutManager(manager);
        //设置垂直
        manager.setOrientation(OrientationHelper.VERTICAL);

        //设置适配器
        adapter=new MyClassLeftAdapter(getActivity(),list);

        //设置分割线
        left.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        left.setAdapter(adapter);
        //设置点击监听
        adapter.setOnItemClickLitener(new MyClassLeftAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int positon) {
                list.get(index).ischeck = false;
                list.get(positon).ischeck = true;
                index = positon;
                //点击之后进行修改数据
                update(positon);
            }

            @Override
            public void onItemLongClick(View view, int position) {


            }
        });

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        childrenList.clear();
        list.clear();
    }
    /**
     * 修改点击后进行展示的数据
     * @param positon
     */
    private void update(int positon) {
        adapter.notifyDataSetChanged();//进行数据刷新
        childrenList.clear();//数据进行清空，放更新的数据
        //第一层children
        List<MyBean.RsBean.ChildrenBean> childrenBeen=list.get(positon).children;
        for (int i = 0; i < childrenBeen.size(); i++) {
            childrenBeen.get(i).isHeader = true;
            childrenList.add(childrenBeen.get(i));
            childrenList.addAll(childrenBeen.get(i).children);
        }
        contextAdapter.notifyDataSetChanged();//刷新内容展示
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getActivity(), SousuoActivity.class);
        startActivity(intent);

    }


}
