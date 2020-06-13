package net.totalh.tutoria.Activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import net.totalh.tutoria.R;

public class WebViewActivity extends AppCompatActivity {
    Toolbar toolbar;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        String title1 = getIntent().getStringExtra("titles") + ".html";
        WebView webView = findViewById(R.id.webView);
        toolbar =findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title1.replace("_"," ").replace(".html",""));
        toolbar.setTitleTextColor(Color.WHITE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDefaultFontSize(50);
        webView.getSettings().setMinimumFontSize(50);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.loadUrl("http://www.tutoria.22web.org/" + title1);
    }
}
