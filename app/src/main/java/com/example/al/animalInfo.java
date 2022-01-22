package com.example.al;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class animalInfo extends AppCompatActivity {
    ImageView im;
    TextView tes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);
        im=findViewById(R.id.im);
        tes=findViewById(R.id.tex);
        Intent intent=getIntent();

        im.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_foreground));
        tes.setText(intent.getStringExtra("name"));
    }
}