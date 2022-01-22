package com.example.al;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.myInterface{
 RecyclerView recyclerView;
 ArrayList<Animal>animals;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                    }
                });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
                Toast.makeText(MainActivity.this,"add loaded",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        animals = new ArrayList<>();
        animals.add(new Animal("Cat", R.drawable.cat));
        animals.add(new Animal("Elephant", R.drawable.elephant));
        animals.add(new Animal("Kangaroo", R.drawable.kangaroo));
        animals.add(new Animal("Kingfisher", R.drawable.kingfisher));
        animals.add(new Animal("Meerkat", R.drawable.meerkat));
        animals.add(new Animal("Horse", R.drawable.horse));
        animals.add(new Animal("Butterfly", R.drawable.butter));
        animals.add(new Animal("Parrot", R.drawable.par));
        animals.add(new Animal("Lion", R.drawable.ln));
        animals.add(new Animal("Duck", R.drawable.du));
        animals.add(new Animal("Gorila", R.drawable.go));
        animals.add(new Animal("Deer", R.drawable.de));
        animals.add(new Animal("Camel", R.drawable.cam));
        animals.add(new Animal("crocodile", R.drawable.crc));
        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this, this);


            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(animalAdapter);

        }
        @Override
        public void onItemClick(int positionAnimal)
        {
            Toast.makeText(this,"clicked"+animals.get(positionAnimal).getName(),Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,animalInfo.class);
            intent.putExtra("image",animals.get(positionAnimal).getImage());
            intent.putExtra("name",animals.get(positionAnimal).getName());
        startActivity(intent);
        }

    }
