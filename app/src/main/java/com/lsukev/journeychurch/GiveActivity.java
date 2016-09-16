package com.lsukev.journeychurch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class GiveActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        super.onCreate(savedInstanceState);

//        WebView webView = new WebView(this);
        setContentView(R.layout.activity_give);
        WebView webView = (WebView) findViewById(R.id.myWebView);


        webView.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;
        webView.setWebChromeClient(new WebChromeClient(){
            private ProgressDialog mProgress;
            @Override
            public void onProgressChanged(WebView view, int progress){
               if (mProgress == null){
                   mProgress = new ProgressDialog(GiveActivity.this);
                   mProgress.show();
               }
                mProgress.setMessage("Loading " + String.valueOf(progress) + "%");
                if (progress == 100){
                    mProgress.dismiss();
                    mProgress=null;
                }
            }
        });
        webView.setWebViewClient(new WebViewClient(){
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl){
                Toast.makeText(GiveActivity.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });
        webView.loadUrl("https://takethejourney.securegive.com/SG/WebOnline/Home/Index?WO=takethejourney");

    }
    protected boolean useDrawerToggle(){
        return false;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_give)
            return true;
        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }

}
