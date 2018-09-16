package com.mehedihasanbangladeshi.sdmgap.newspaperappdemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NewspaperView extends AppCompatActivity {

    WebView mWebView;
    String mURL;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newspaper_view);
        mWebView = findViewById(R.id.webview);

        swipeRefreshLayout = findViewById(R.id.refresh_layout);
        mURL = getIntent().getStringExtra("url");

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadURL();
            }
        });

        loadURL();




    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()){
            mWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }




    public void loadURL() {


        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().getLoadsImagesAutomatically();
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.loadUrl(mURL);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(getApplicationContext(), " Not found!!!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getApplicationContext(), "loading finished!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
