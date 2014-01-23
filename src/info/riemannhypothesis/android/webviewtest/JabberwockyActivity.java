package info.riemannhypothesis.android.webviewtest;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class JabberwockyActivity extends Activity {

	WebView webView;
	MediaPlayer myPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		webView = (WebView) findViewById(R.id.webViewJabberwocky);
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

	public void openWikipedia(View view) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://en.wikipedia.org/wiki/Jabberwocky"));
		startActivity(intent);
	}

	public void loadImage(View view) {
		webView.loadUrl("file:///android_asset/troll.jpg");
	}

}
