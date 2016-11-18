package com.bwei.hhzmy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.activity.DituActivity;

/**
 * Created by zhangjie on 2016/11/16.
 */
public class ShopFragment extends Fragment {

    private LinearLayout ll;
    private TextView tv_address;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.goods_fagment,null);
        ll=(LinearLayout) view.findViewById(R.id.shop_linear);
        tv_address=(TextView) view.findViewById(R.id.tv_address);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), DituActivity.class);

                getActivity().startActivityForResult(intent,1);
            }
        });
        Intent intent=getActivity().getIntent();

        if(intent.hasExtra("地址")){
            Bundle bundle = intent.getExtras();

            String data = bundle.getString("地址");

            tv_address.setText(data);
        }else{
            tv_address.setText("null");
        }

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {




    }
}
