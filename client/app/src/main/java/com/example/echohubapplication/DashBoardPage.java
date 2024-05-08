package com.example.echohubapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashBoardPage extends AppCompatActivity {

    ImageButton btnSearchGroup, btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dash_board_page);

        Intent fetchIntent = getIntent();
        String username = fetchIntent.getStringExtra("EXTRA_USERNAME");
        String bio = fetchIntent.getStringExtra("EXTRA_BIO");
        String intStatus = fetchIntent.getStringExtra("EXTRA_STATUS");

        btnSearchGroup = (ImageButton) findViewById(R.id.btnSearchGroup);
        btnProfile = (ImageButton) findViewById(R.id.btnProfile);

        btnSearchGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardPage.this, SearchPage.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_BIO", bio);
                intent.putExtra("EXTRA_STATUS", intStatus);
                startActivity(intent);
                finish();
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardPage.this, EditUserPage.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_BIO", bio);
                intent.putExtra("EXTRA_STATUS", intStatus);
                startActivity(intent);
                finish();
            }
        });
    }
}