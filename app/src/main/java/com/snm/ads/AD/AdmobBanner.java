package com.snm.ads.AD;

import android.app.Activity;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.snm.ads.R;

public class AdmobBanner {

    public static void AdmobBannerAD(Activity activity){

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        db.getReference().child("Ads").child("Admob").child("admobBannerAdID").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String AdmobBannerID = snapshot.getValue(String.class);

                AdView mAdView = new AdView(activity);
                mAdView.setAdUnitId(AdmobBannerID);
                mAdView.setAdSize(AdSize.BANNER);
                ((LinearLayout) activity.findViewById(R.id.layout_banner_ad)).addView(mAdView);

                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);

                mAdView.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                    }

                    @Override
                    public void onAdOpened() {

                    }

                    @Override
                    public void onAdClicked() {

                    }

                    @Override
                    public void onAdClosed() {

                        AdRequest adRequest = new AdRequest.Builder().build();
                        mAdView.loadAd(adRequest);

                    }

                });



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}