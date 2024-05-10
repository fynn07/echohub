package com.example.echohubapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditUserPage extends AppCompatActivity {

    Button btnReturn, btnStatus, btnActive, btnAway, btnDisturb;

    EditText user, bios;
    LinearLayout allStatus;

    ImageView imageStatus;

    String intStatus;

    View rootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_user_page);

        Intent fetchIntent = getIntent();

        String username = fetchIntent.getStringExtra("EXTRA_USERNAME");
        String bio = fetchIntent.getStringExtra("EXTRA_BIO");
        intStatus = fetchIntent.getStringExtra("EXTRA_STATUS");
        String bgcolor = fetchIntent.getStringExtra("EXTRA_BGCOLOR");
        String fcolor = fetchIntent.getStringExtra("EXTRA_FCOLOR");

        user = findViewById(R.id.edtUsername);
        bios = findViewById(R.id.edtBio);

        user.setText(username);
        bios.setText(bio);

        imageStatus = findViewById(R.id.imageStatus);

        btnStatus = findViewById(R.id.btnAddStatus);
        btnActive = findViewById(R.id.btnActive);
        btnAway = findViewById(R.id.btnAway);
        btnDisturb = findViewById(R.id.btnDoNotDisturb);
        rootView = findViewById(R.id.main);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        rootView.setBackgroundColor(Color.parseColor(bgcolor));
        user.setTextColor(Color.parseColor(fcolor));
        bios.setTextColor(Color.parseColor(fcolor));
        btnReturn.setBackgroundColor(Color.parseColor(fcolor));
        btnReturn.setTextColor(Color.parseColor(bgcolor));
        btnStatus.setBackgroundColor(Color.parseColor(fcolor));
        btnStatus.setTextColor(Color.parseColor(bgcolor));
        btnActive.setBackgroundColor(Color.parseColor(fcolor));
        btnActive.setTextColor(Color.parseColor(bgcolor));
        btnAway.setBackgroundColor(Color.parseColor(fcolor));
        btnAway.setTextColor(Color.parseColor(bgcolor));
        btnDisturb.setBackgroundColor(Color.parseColor(fcolor));
        btnDisturb.setTextColor(Color.parseColor(bgcolor));

        allStatus = findViewById(R.id.hiddenButtonsLayout);

        if(intStatus.equals("active")) {
            imageStatus.setImageResource(R.drawable.circlegreen);
        } else if(intStatus.equals("away")) {
            imageStatus.setImageResource(R.drawable.circleorange);
        } else {
            imageStatus.setImageResource(R.drawable.circlered);
        }

        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allStatus.getVisibility() == View.VISIBLE) {
                    allStatus.setVisibility(View.GONE);
                } else {
                    allStatus.setVisibility(View.VISIBLE);
                }
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userChanged = user.getText().toString().trim();
                String bioChanged = bios.getText().toString();
                Intent intent = new Intent(EditUserPage.this, DashBoardPage.class);
                intent.putExtra("EXTRA_USERNAME", userChanged);
                intent.putExtra("EXTRA_BIO", bioChanged);
                intent.putExtra("EXTRA_STATUS", intStatus);
                intent.putExtra("EXTRA_BGCOLOR", bgcolor);
                intent.putExtra("EXTRA_FCOLOR", fcolor);
                startActivity(intent);
                finish();
            }
        });

        btnActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageStatus.setImageResource(R.drawable.circlegreen);
                intStatus = "active";
            }
        });

        btnAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageStatus.setImageResource(R.drawable.circleorange);
                intStatus = "away";
            }
        });

        btnDisturb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageStatus.setImageResource(R.drawable.circlered);
                intStatus = "donotdisturb";
            }
        });
    }
}