package info.riemannhypothesis.android.webviewtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WotwActivity extends Activity {

	WebView webView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("file:///android_asset/waroftheworlds.html");
	}

	@Override
	public void onBackPressed() {
		if (webView.canGoBack()) {
			webView.goBack();
		} else {
			super.onBackPressed();
		}
	}
}
