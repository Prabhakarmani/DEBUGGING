package prabhakar.debugging;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity
{
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button open = (Button)findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                opendeveloper();
            }
        });
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);
        AdRequest adRequesta = new AdRequest.Builder().build();
        interstitial = new InterstitialAd(MainActivity.this);
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
        interstitial.loadAd(adRequesta);
        interstitial.setAdListener(new AdListener()
        {
            public void onAdLoaded() {
                displayInterstitial();
            }
        });
    }
    public void displayInterstitial()
    {
        if (interstitial.isLoaded())
        {
            interstitial.show();
        }
    }
    public void opendeveloper()
    {
        startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
/*
        final Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        final ComponentName cn = new ComponentName("com.android.settings", "com.android.settings.wifi.WifiSettings");
        intent.setComponent(cn);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity( intent);*/
    }
}
