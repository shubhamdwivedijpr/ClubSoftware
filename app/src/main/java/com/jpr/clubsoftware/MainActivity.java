package com.jpr.clubsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView myweb;

    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myweb=findViewById(R.id.webview);
        WebSettings webSettings = myweb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myweb.loadUrl("http://www.clubsoftware.in/Login.aspx");
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        myweb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl("http://www.clubsoftware.in/Login.aspx");
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(MainActivity.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
        myweb.loadUrl("http://www.clubsoftware.in/Login.aspx");




    }

    @Override
    public void onBackPressed() {
        if (myweb.canGoBack())
        {
            myweb.goBack();
        }else
        {
            super.onBackPressed();
        }

    }

}

