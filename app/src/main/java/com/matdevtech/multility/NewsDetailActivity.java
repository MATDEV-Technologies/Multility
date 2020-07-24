package com.matdevtech.multility;

// Imports
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
//import android.widget.TextView;

// Main class
public class NewsDetailActivity extends AppCompatActivity {

    // Class vars
    @SuppressWarnings("unused")
    private ImageView imageView;
    @SuppressWarnings("unused")
    private FrameLayout date_behaviour;
    @SuppressWarnings("unused")
    private String mUrl,mImg,mTitle,mDate,mSource,mAuthor;

    // Activity init
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
//
//        date_behaviour = findViewById(R.id.date_behavior);
//        imageView = findViewById(R.id.backdrop);
//        date = findViewById(R.id.date);
//        time = findViewById(R.id.time)
//        title = findViewById(R.id.title);
//
//        Intent intent = getIntent();
//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.error(Utils.getRandomDrawbleColor());
//
//        date.setText(Utils.DateFormat(mDate));
//        title.SetText(mTitle);
//
//        String author;
//        if (mAuthor != null || mAuthor != ""){
//
//        }
        @SuppressWarnings("unused")
        Intent browserIntent = getIntent();
    }

    // INitialize the web view (webpage inside app structure)
    @SuppressWarnings("unused")
    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView(String url) {
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setLoadsImagesAutomatically(true);
        // Warning says there could be XSS vulnerabilities with JS auto-enabled; just a heads up
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}