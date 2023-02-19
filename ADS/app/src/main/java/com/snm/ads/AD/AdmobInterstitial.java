package com.snm.ads.AD;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdmobInterstitial {

    public Context context;
    private String AdmobInterstitialID;
    public InterstitialAd mInterstitialAd;

    public AdmobInterstitial(Context context){

        this.context = context;

    }


    public void AdmobInterstitialAD(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference().child("Ads").child("ADType").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String ADType = snapshot.getValue(String.class);

                if ( ADType.contains("Admob") ){

                    db.getReference().child("Ads").child("Admob").child("admobInterstitialAdID").addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            AdmobInterstitialID = snapshot.getValue(String.class);

                            loadAdmobInterstitialAd();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }

                    });

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void loadAdmobInterstitialAd() {

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load( context, AdmobInterstitialID, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                        mInterstitialAd = interstitialAd;

                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdDismissedFullScreenContent() {

                                loadAdmobInterstitialAd();

                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {

                            }

                            @Override
                            public void onAdShowedFullScreenContent() {

                                mInterstitialAd = null;

                            }
                        });

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mInterstitialAd = null;

                    }
                });


    }

}
