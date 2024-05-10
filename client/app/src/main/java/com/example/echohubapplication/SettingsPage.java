package com.example.echohubapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SettingsPage extends AppCompatActivity {

    Switch notif, darkmode;
    EditText background, fontcolor;
    Button save, returnBtn;
    View rootView;

    String bgcolor, fcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        notif = findViewById(R.id.switchNotifications);
        darkmode = findViewById(R.id.switchDarkMode);
        background = findViewById(R.id.editBackground);
        fontcolor = findViewById(R.id.editFontColor);
        save = findViewById(R.id.btnSaveSettings);
        rootView = findViewById(R.id.main);
        returnBtn = findViewById(R.id.btnReturn);

        Intent fetchIntent = getIntent();
        bgcolor = fetchIntent.getStringExtra("EXTRA_BGCOLOR");
        fcolor = fetchIntent.getStringExtra("EXTRA_FCOLOR");

        rootView.setBackgroundColor(Color.parseColor(bgcolor));
        save.setBackgroundColor(Color.parseColor(fcolor));
        save.setTextColor(Color.parseColor(bgcolor));
        returnBtn.setBackgroundColor(Color.parseColor(fcolor));
        returnBtn.setTextColor(Color.parseColor(bgcolor));
        setTextColor(fcolor);

        setupListeners(fetchIntent);
    }

    private void setupListeners(Intent fetchIntent) {
        save.setOnClickListener(v -> {
            applySettings();
        });

        returnBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsPage.this, DashBoardPage.class);
            intent.putExtras(fetchIntent);
            intent.putExtra("EXTRA_BGCOLOR", bgcolor);
            intent.putExtra("EXTRA_FCOLOR", fcolor);
            startActivity(intent);
            finish();
        });
    }

    private void applySettings() {
        if (darkmode.isChecked()) {
            bgcolor = "#000000";
            fcolor = "#FFFFFF";
        } else {
            String inputBgColor = background.getText().toString().trim();
            String inputFontColor = fontcolor.getText().toString().trim();

            bgcolor = isValidHexColor(inputBgColor) ? inputBgColor : "#4A36DB";
            fcolor = isValidHexColor(inputFontColor) ? inputFontColor : "#FFFFFF";
        }
        save.setBackgroundColor(Color.parseColor(fcolor));
        save.setTextColor(Color.parseColor(bgcolor));
        returnBtn.setBackgroundColor(Color.parseColor(fcolor));
        returnBtn.setTextColor(Color.parseColor(bgcolor));
        rootView.setBackgroundColor(Color.parseColor(bgcolor));
        setTextColor(fcolor);
    }

    private void setTextColor(String colorHex) {
        TextView textViewHeader = findViewById(R.id.txtHeader);
        notif = findViewById(R.id.switchNotifications);
        darkmode = findViewById(R.id.switchDarkMode);
        background = findViewById(R.id.editBackground);
        fontcolor = findViewById(R.id.editFontColor);
        textViewHeader.setTextColor(Color.parseColor(colorHex));
        notif.setTextColor(Color.parseColor(fcolor));
        darkmode.setTextColor(Color.parseColor(fcolor));
        background.setTextColor(Color.parseColor(fcolor));
        fontcolor.setTextColor(Color.parseColor(fcolor));
    }

    private boolean isValidHexColor(String colorHex) {
        return colorHex.matches("^#([A-Fa-f0-9]{6})$|^#([A-Fa-f0-9]{8})$");
    }
}

