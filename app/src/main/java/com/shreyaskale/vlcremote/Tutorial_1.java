package com.shreyaskale.vlcremote;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class Tutorial_1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Loading WebView from local html file
        WebView webView = (WebView)findViewById(R.id.webView1);
        webView.loadUrl("file:///android_asset/vlcsetup1.html");
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
