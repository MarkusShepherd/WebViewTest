package info.riemannhypothesis.android.webviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class UofiAtNasaActivity extends Activity {

	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("file:///android_asset/uofi-at-nasa.html");
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
