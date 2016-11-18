package com.bwei.hhzmy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bwei.hhzmy.R;

/**
 * Created by zhangjie on 2016/11/16.
 */
public class Fragment2 extends Fragment {

    private View view;
    private WebView wb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getActivity(), R.layout.fragment_ggcanshu,null);
        wb=(WebView) view.findViewById(R.id.shop_wbcanshu);
        wb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        String htmlData="http://product.suning.com/pds-web/product/graphicDetailsApp/0000000000/102295661/10051/R9000413/1.html";
        WebSettings webSettings= wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wb.loadUrl(htmlData);
        return view;
    }
}
