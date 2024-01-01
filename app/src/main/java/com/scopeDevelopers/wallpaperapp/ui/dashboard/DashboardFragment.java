 package com.scopeDevelopers.wallpaperapp.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.scopeDevelopers.wallpaperapp.MainActivity;
import com.scopeDevelopers.wallpaperapp.R;
import com.scopeDevelopers.wallpaperapp.SplashActivity;

 public class DashboardFragment extends Fragment {

    View root;
    private AdView mAdView;
    InterstitialAd interstitial;


    String[] title = {"Travel","Animal","Cars","Love","Nature","Sports"};
    int[] images = {R.mipmap.travel,R.mipmap.animal,R.mipmap.cars,R.mipmap.love,R.mipmap.nature,R.mipmap.sports};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        AdMob();

        AdView adView = new AdView(getContext());
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.Admob_Banner));

        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        RecyclerView catList = root.findViewById(R.id.catList);
        catList.setLayoutManager(new LinearLayoutManager(getActivity()));
        catList.setAdapter(new catAdapter(getContext(),title,images));

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (interstitial.isLoaded()){
                    interstitial.show();
                }
            }
        }, 4000);

        return root;
    }

    public void AdMob() {
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("YOUR_TEST_DEVICE_ID").build();
        interstitial = new InterstitialAd(getContext());
        interstitial.setAdUnitId(getString(R.string.Admob_Interstial));
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                //Ads loaded
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                //Ads closed
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                //Ads couldn't loaded
            }
        });
        interstitial.loadAd(adRequest);
    }

}