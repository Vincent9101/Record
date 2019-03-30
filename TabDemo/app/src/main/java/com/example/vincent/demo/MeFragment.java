package com.example.vincent.demo;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.security.Key;


public class MeFragment extends Fragment {

    private WebView mWebView;
    private TextView titleWebView;

    public MeFragment() {

    }

    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("FragmentMe", "creating ");
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_me, container, false);
        Log.d("FragmentMe", "return view");
        titleWebView = view.findViewById(R.id.title_webview);
        mWebView = view.findViewById(R.id.blog_view);
        initWebView();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((i == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
                return false;
            }
        });
        return view;
    }

    private void initWebView() {
        WebSettings webSettings = mWebView.getSettings();
        //支持javascript
        webSettings.setJavaScriptEnabled(true);
        //自适应屏幕
        webSettings.setUseWideViewPort(true);//将图片调整到webview的大小
        webSettings.setLoadWithOverviewMode(true);//缩放值屏幕的大小
//
//       //缩放操作
//       webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
//       webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
//       webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d("Vincent blog view", "开始加载");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d("Vincent blog view", "加载结束");
            }

            // 链接跳转都会走这个方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("Vincent blog view", "Url：" + url);
                view.loadUrl(url);// 强制在当前 WebView 中加载 url
                return true;
            }
        });


        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Log.d("Vincent blog view", "newProgress：" + newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                titleWebView.setText(title);
                Log.d("Vincent blog view", "标题：" + title);
            }
        });


        mWebView.loadUrl("https://www.bloger.top");
        mWebView.canGoBack();
        mWebView.canGoForward();

    }
    public WebView getWebView(){
        return mWebView;
    }


}
