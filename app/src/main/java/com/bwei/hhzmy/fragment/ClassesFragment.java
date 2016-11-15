package com.bwei.hhzmy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.activity.SousuoActivity;


/**
 * Created by zhangjie on 2016/11/7.
 */
public class ClassesFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2,container,false);
        ll=(LinearLayout) view.findViewById(R.id.ll_fen);

        ll.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getActivity(), SousuoActivity.class);
        startActivity(intent);

    }
}
