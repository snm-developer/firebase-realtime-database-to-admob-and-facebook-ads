package com.snm.ads.AD;

import android.app.Activity;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.snm.ads.R;

public class FacebookBanner {

    public static void FacebookBannerAD ( Activity activity ){

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        db.getReference().child("Ads").child("Facebook").child("facebookBannerAdID").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String FacebookBannerID = snapshot.getValue(String.class);

                AudienceNetworkAds.initialize(activity);
                AdView adView = new AdView( activity, FacebookBannerID, AdSize.BANNER_HEIGHT_50);
                LinearLayout adContainer = (LinearLayout) activity.findViewById(R.id.layout_banner_ad);
                adContainer.addView(adView);
                adView.loadAd();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }

}
