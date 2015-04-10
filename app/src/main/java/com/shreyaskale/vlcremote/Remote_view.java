package com.shreyaskale.vlcremote;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.HttpAuthHandler;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


@SuppressLint("SetJavaScriptEnabled")
public class Remote_view extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 1. Get passed intent
        Intent intent = getIntent();

        // 2. Get message value from intent
        String url = intent.getStringExtra("ip");
        //String pass = intent.getStringExtra("pass");
        //String url2 ="http://:"+pass+"@"+url+":8080";
        String url2 ="http://"+url+":8080";

        //Loading WebView from user input IP address
        WebView webView = (WebView)findViewById(R.id.webView3);
        webView.setWebViewClient(new MyWebViewClient ());
        webView.loadUrl(url2);
        //webView.setWebChromeClient(new WebChromeClient());
        //webView.clearCache(true);
        //webView.clearHistory();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onReceivedHttpAuthRequest(WebView view,HttpAuthHandler handler, String host, String realm) {
            Intent intent = getIntent();
            String pass = intent.getStringExtra("pass");
            handler.proceed("",pass);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

