package com.example.movses.greenpage.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movses.greenpage.R;

public class DetailsActivity extends AppCompatActivity {

    ImageView profileimage;
    TextView name;
    TextView surname;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        profileimage=findViewById(R.id.detail_image);
        name=findViewById(R.id.detail_name);;
        surname=findViewById(R.id.detail_surname);
        Glide.with(context).load(getIntent().getStringExtra("img_url")).into(profileimage);
        name.setText(getIntent().getStringExtra("name"));
        surname.setText(getIntent().getStringExtra("surname"));




    }
}
