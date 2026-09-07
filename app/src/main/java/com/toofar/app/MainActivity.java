package com.toofar.app;
import android.app.Activity;import android.graphics.Color;import android.os.Bundle;import android.webkit.*;import android.view.View;
public class MainActivity extends Activity{
 WebView w;
 public void onCreate(Bundle b){super.onCreate(b);getWindow().setStatusBarColor(Color.rgb(255,248,241));w=new WebView(this);WebSettings s=w.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);w.setWebViewClient(new WebViewClient());w.setWebChromeClient(new WebChromeClient());setContentView(w);w.loadUrl("file:///android_asset/index.html");}
}
