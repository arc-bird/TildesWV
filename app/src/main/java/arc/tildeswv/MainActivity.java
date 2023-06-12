/*
Forked from https://github.com/woheller69/gptassist
to create a small WebView wrapper for the social media
network Tildes (https://tildes.net).
*/

package arc.tildeswv;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private WebView tildesWebView = null;
    private WebSettings tildesWebSettings = null;
    private CookieManager tildesCookieManager = null;
    private final Context context = this;
    private String TAG = "TildesWV";
    private String urlToLoad = "https://tildes.net/";

    private static final ArrayList<String> allowedDomains = new ArrayList<String>();

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            setTheme(android.R.style.Theme_DeviceDefault_DayNight);
        }
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the WebView
        tildesWebView = findViewById(R.id.tildesWebView);
        tildesWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        //Set cookie options
        CookieManager tildesCookieManager = CookieManager.getInstance();
        tildesCookieManager.setAcceptCookie(true);
        tildesCookieManager.setAcceptThirdPartyCookies(tildesWebView, false);

        tildesWebSettings = tildesWebView.getSettings();

        tildesWebSettings.setJavaScriptEnabled(true);
        tildesWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        tildesWebSettings.setDomStorageEnabled(true);

        tildesWebSettings.setAllowContentAccess(true);
        tildesWebSettings.setAllowFileAccess(false);
        tildesWebSettings.setBuiltInZoomControls(false);
        tildesWebSettings.setDatabaseEnabled(true);
        tildesWebSettings.setSaveFormData(true);
        tildesWebSettings.setDisplayZoomControls(false);
        tildesWebSettings.setGeolocationEnabled(false);

        tildesWebView.loadUrl(urlToLoad);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Credit (CC BY-SA 3.0): https://stackoverflow.com/a/6077173
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (tildesWebView.canGoBack() && !tildesWebView.getUrl().equals("about:blank")) {
                        tildesWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}