package com.mopub.mobileads.simpleadsdemo;

import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial.MoPubInterstitialListener;
import com.mopub.mobileads.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class InterstitialsTab extends Activity implements MoPubInterstitialListener {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interstitials);

        Button loadShowButton = (Button) findViewById(R.id.loadshowinterstitial);
        loadShowButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showInterstitialAd();
            }
        });
    }

    public void showInterstitialAd() {
        MoPubInterstitial interstitial = new MoPubInterstitial(this, 
                SimpleAdsDemoConstants.PUB_ID_INTERSTITIAL);
        interstitial.setListener(this);
        interstitial.showAd();
    }

    @Override
    public void OnInterstitialLoaded() {
    }

    @Override
    public void OnInterstitialFailed() {
        Toast.makeText(this, "No ad available", Toast.LENGTH_SHORT).show();
    }
}
