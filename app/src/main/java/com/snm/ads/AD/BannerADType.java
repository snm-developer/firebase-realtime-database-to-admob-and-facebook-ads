package com.snm.ads.AD;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BannerADType {

    public static void BannerADConfigType (Activity activity){

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        db.getReference().child("Ads").child("ADType").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String BannerADType = snapshot.getValue(String.class);

                if ( BannerADType.contains("Admob") ){

                    AdmobBanner.AdmobBannerAD(activity);

                }

                if ( BannerADType.contains("Facebook") ){

                    FacebookBanner.FacebookBannerAD(activity);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}
