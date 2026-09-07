package com.toofar.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;

    public class NativeBridge {
        @JavascriptInterface
        public void share(String text) {
            runOnUiThread(() -> {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Condividi TOOFAR?"));
            });
        }
        @JavascriptInterface
        public void copy(String text) {
            ClipboardManager cm = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setPrimaryClip(ClipData.newPlainText("TOOFAR?", text));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(8,10,13));
        getWindow().setNavigationBarColor(Color.rgb(8,10,13));

        webView = new WebView(this);
        webView.setBackgroundColor(Color.rgb(8,10,13));
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(true);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);
        s.setMediaPlaybackRequiresUserGesture(false);

        webView.addJavascriptInterface(new NativeBridge(), "NativeShare");
        webView.setWebViewClient(new WebViewClient() {
            @Override public void onPageFinished(WebView view, String url) {
                handleIntent(getIntent());
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        setContentView(webView);
        webView.loadUrl("file:///android_asset/index.html");
    }

    private void handleIntent(Intent intent) {
        if (intent == null || intent.getData() == null || webView == null) return;
        Uri data = intent.getData();
        if ("toofar".equals(data.getScheme()) && "room".equals(data.getHost())) {
            String code = data.getLastPathSegment();
            if (code != null) {
                String safe = code.replace("'", "").replace("\"", "");
                webView.evaluateJavascript("window.openRoomFromNative('" + safe + "')", null);
            }
        }
    }

    @Override protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    @Override public void onBackPressed() {
        if (webView != null) {
            webView.evaluateJavascript("window.TOOFAR_BACK ? window.TOOFAR_BACK() : null", null);
        } else {
            super.onBackPressed();
        }
    }
}
