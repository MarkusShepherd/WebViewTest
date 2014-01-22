package info.riemannhypothesis.android.webviewtest;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.webkit.WebView;

public class JabberwockyActivity extends Activity {

	WebView webView;
	MediaPlayer myPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("file:///android_asset/jabberwocky.html");
	}

	@Override
	protected void onResume() {
		super.onResume();
		myPlayer = MediaPlayer.create(this, R.raw.schepke_opus_1);
		myPlayer.setLooping(true);
		myPlayer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		myPlayer.stop();
		myPlayer.release();
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
