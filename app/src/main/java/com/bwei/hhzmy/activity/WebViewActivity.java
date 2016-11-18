package com.bwei.hhzmy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bwei.hhzmy.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wv=(WebView) findViewById(R.id.wv);
        WebSettings webSettings= wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Intent intent=getIntent();
        String url=intent.getStringExtra("地址");
        wv.loadUrl(url);

    }
}
