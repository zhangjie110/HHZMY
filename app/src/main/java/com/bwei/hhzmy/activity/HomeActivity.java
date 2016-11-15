package com.bwei.hhzmy.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.bwei.hhzmy.R;
import com.bwei.hhzmy.fragment.ClassesFragment;
import com.bwei.hhzmy.fragment.HomeFragment;
import com.bwei.hhzmy.fragment.MyFragment;
import com.bwei.hhzmy.fragment.ShopCarFragment;

public class HomeActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{

    private HomeFragment fragment1 = new HomeFragment();
    private ClassesFragment fragment2 = new ClassesFragment();
    private ShopCarFragment fragment3 = new ShopCarFragment();
    private MyFragment fragment4 = new MyFragment();
    private FragmentManager manager = getSupportFragmentManager();
    private FragmentTransaction transaction = manager.beginTransaction();
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initData();
    }

    private void initData() {
        rg=(RadioGroup) findViewById(R.id.rg);
        //RadioGroup监听
        rg.setOnCheckedChangeListener(this);
        transaction.replace(R.id.fl, fragment1).commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (i) {
            case R.id.rb1:
                transaction.replace(R.id.fl, fragment1, "fragment1").commit();
                break;
            case R.id.rb2:
                transaction.replace(R.id.fl, fragment2, "fragment2").commit();
                break;
            case R.id.rb3:
                transaction.replace(R.id.fl, fragment3, "fragment3").commit();
                break;
            case R.id.rb4:
                transaction.replace(R.id.fl, fragment4, "fragment4").commit();
                break;
        }

    }
}
