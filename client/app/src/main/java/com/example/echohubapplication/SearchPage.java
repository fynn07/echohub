package com.example.echohubapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SearchPage extends AppCompatActivity {

    Button btnReturn;

    ImageButton group1, group2, group3, group4, group5, group6;
    TextView grp1, grp2, grp3, grp4, grp5, grp6, headerText;

    View rootview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_page);

        Intent fetchIntent = getIntent();

        String username = fetchIntent.getStringExtra("EXTRA_USERNAME");
        String bio = fetchIntent.getStringExtra("EXTRA_BIO");
        String status = fetchIntent.getStringExtra("EXTRA_STATUS");
        String bgcolor = fetchIntent.getStringExtra("EXTRA_BGCOLOR");
        String fcolor = fetchIntent.getStringExtra("EXTRA_FCOLOR");


        btnReturn = (Button) findViewById(R.id.btnReturn);
        group1 = findViewById(R.id.btnGrp1);
        group2 = findViewById(R.id.btnGrp2);
        group3 = findViewById(R.id.btnGrp3);
        group4 = findViewById(R.id.btnGrp4);
        group5 = findViewById(R.id.btnGrp5);
        group6 = findViewById(R.id.btnGrp6);
        grp1 = findViewById(R.id.textView3);
        grp2 = findViewById(R.id.textView4);
        grp3 = findViewById(R.id.textView5);
        grp4 = findViewById(R.id.textView6);
        grp5 = findViewById(R.id.textView7);
        grp6 = findViewById(R.id.textView8);
        headerText = findViewById(R.id.textView9);

        rootview = findViewById(R.id.main);
        rootview.setBackgroundColor(Color.parseColor(bgcolor));
        btnReturn.setBackgroundColor(Color.parseColor(fcolor));
        btnReturn.setTextColor(Color.parseColor(bgcolor));
        grp1.setTextColor(Color.parseColor(fcolor));
        grp2.setTextColor(Color.parseColor(fcolor));
        grp3.setTextColor(Color.parseColor(fcolor));
        grp4.setTextColor(Color.parseColor(fcolor));
        grp5.setTextColor(Color.parseColor(fcolor));
        grp6.setTextColor(Color.parseColor(fcolor));
        headerText.setTextColor(Color.parseColor(fcolor));



        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchPage.this, DashBoardPage.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_BIO", bio);
                intent.putExtra("EXTRA_STATUS", status);
                intent.putExtra("EXTRA_BGCOLOR", bgcolor);
                intent.putExtra("EXTRA_FCOLOR", fcolor);
                startActivity(intent);
                finish();
            }
        });

        String groupOne = "LeagueOfGeeks";
        String groupTwo = "CatLovers";
        String groupThree = "OnlyGym";
        String groupFour = "Cutters";
        String groupFive = "BeautyKids";
        String groupSix = "TheGrahams";

        Intent newIntent = new Intent(SearchPage.this, GroupChatPage.class);
        newIntent.putExtra("EXTRA_USERNAME", username);
        newIntent.putExtra("EXTRA_BIO", bio);
        newIntent.putExtra("EXTRA_STATUS", status);
        newIntent.putExtra("EXTRA_BGCOLOR", bgcolor);
        newIntent.putExtra("EXTRA_FCOLOR", fcolor);

        group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIntent.putExtra("EXTRA_GROUP", groupOne);
                startActivity(newIntent);
            }
        });

        group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIntent.putExtra("EXTRA_GROUP", groupTwo);

                startActivity(newIntent);
            }
        });

        group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIntent.putExtra("EXTRA_GROUP", groupThree);
                startActivity(newIntent);
            }
        });

        group4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIntent.putExtra("EXTRA_GROUP", groupFour);
                startActivity(newIntent);
            }
        });

        group5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIntent.putExtra("EXTRA_GROUP", groupFive);
                startActivity(newIntent);
            }
        });

        group6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIntent.putExtra("EXTRA_GROUP", groupSix);
                startActivity(newIntent);
            }
        });
    }
}