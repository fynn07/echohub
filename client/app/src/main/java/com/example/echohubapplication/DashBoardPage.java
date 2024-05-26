package com.example.echohubapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DashBoardPage extends AppCompatActivity {

    ImageButton btnSearchGroup, btnProfile, btnSetting, user1, user2, user3, user4, user5, user6, user7;
    private List<Message> messages = new ArrayList<>();
    private RecyclerView recyclerView;
    private MessageAdapter adapter;
    private EditText editTextMessage;
    private Button buttonSend;

    private TextView uname1, uname2, uname3, uname4, uname5, uname6, uname7, sGroup, settings;
    View rootView;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dash_board_page);

        Intent fetchIntent = getIntent();
        String username = fetchIntent.getStringExtra("EXTRA_USERNAME");
        String bio = fetchIntent.getStringExtra("EXTRA_BIO");
        String intStatus = fetchIntent.getStringExtra("EXTRA_STATUS");
        String bgcolor = fetchIntent.getStringExtra("EXTRA_BGCOLOR");
        String fcolor = fetchIntent.getStringExtra("EXTRA_FCOLOR");

        btnSearchGroup = findViewById(R.id.btnSearchGroup);
        btnProfile = findViewById(R.id.btnProfile);
        btnSetting = findViewById(R.id.btnSettings);

//        recyclerView = findViewById(R.id.recyclerViewMessages);
//        editTextMessage = findViewById(R.id.editTextMessage);
//        buttonSend = findViewById(R.id.buttonSend);

        rootView = findViewById(R.id.main);
        user1 = findViewById(R.id.imgUser1);
        user2 = findViewById(R.id.imgUser2);
        user3 = findViewById(R.id.imgUser3);
        user4 = findViewById(R.id.imgUser4);
        user5 = findViewById(R.id.imgUser5);
        user6 = findViewById(R.id.imgUser6);
        user7 = findViewById(R.id.imgUser7);
        header = findViewById(R.id.textView10);

        uname1 = findViewById(R.id.userName1);
        uname2 = findViewById(R.id.userName2);
        uname3 = findViewById(R.id.userName3);
        uname4 = findViewById(R.id.userName4);
        uname5 = findViewById(R.id.userName5);
        uname6 = findViewById(R.id.userName6);
        uname7 = findViewById(R.id.userName7);
        sGroup = findViewById(R.id.searchGroup);
        settings = findViewById(R.id.settings);


//        adapter = new MessageAdapter(messages);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);

        // Set background and text colors
        rootView.setBackgroundColor(Color.parseColor(bgcolor));
        header.setBackgroundColor(Color.parseColor(bgcolor));
        header.setTextColor(Color.parseColor(fcolor));
        user1.setBackgroundColor(Color.parseColor(bgcolor));
        user2.setBackgroundColor(Color.parseColor(bgcolor));
        user3.setBackgroundColor(Color.parseColor(bgcolor));
        user4.setBackgroundColor(Color.parseColor(bgcolor));
        user5.setBackgroundColor(Color.parseColor(bgcolor));
        user6.setBackgroundColor(Color.parseColor(bgcolor));
        user7.setBackgroundColor(Color.parseColor(bgcolor));

        uname1.setTextColor(Color.parseColor(fcolor));
        uname2.setTextColor(Color.parseColor(fcolor));
        uname3.setTextColor(Color.parseColor(fcolor));
        uname4.setTextColor(Color.parseColor(fcolor));
        uname5.setTextColor(Color.parseColor(fcolor));
        uname6.setTextColor(Color.parseColor(fcolor));
        uname7.setTextColor(Color.parseColor(fcolor));
        sGroup.setTextColor(Color.parseColor(fcolor));
        settings.setTextColor(Color.parseColor(fcolor));
        btnSearchGroup.setBackgroundColor(Color.parseColor(bgcolor));
//        buttonSend.setBackgroundColor(Color.parseColor(fcolor));

        // Set click listeners
        btnSearchGroup.setOnClickListener(v -> {
            Intent intent = new Intent(DashBoardPage.this, SearchPage.class);
            intent.putExtra("EXTRA_USERNAME", username);
            intent.putExtra("EXTRA_BIO", bio);
            intent.putExtra("EXTRA_STATUS", intStatus);
            intent.putExtra("EXTRA_BGCOLOR", bgcolor);
            intent.putExtra("EXTRA_FCOLOR", fcolor);
            startActivity(intent);
            finish();
        });

//        buttonSend.setOnClickListener(v -> {
//            String text = editTextMessage.getText().toString();
//            if (!text.isEmpty()) {
//                Message newMessage = new Message(text);
//                messages.add(newMessage);
//                adapter.notifyItemInserted(messages.size() - 1);
//                recyclerView.scrollToPosition(messages.size() - 1);
//                editTextMessage.setText("");
//            }
//        });

        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(DashBoardPage.this, EditUserPage.class);
            intent.putExtra("EXTRA_USERNAME", username);
            intent.putExtra("EXTRA_BIO", bio);
            intent.putExtra("EXTRA_STATUS", intStatus);
            intent.putExtra("EXTRA_BGCOLOR", bgcolor);
            intent.putExtra("EXTRA_FCOLOR", fcolor);
            startActivity(intent);
            finish();
        });

        btnSetting.setOnClickListener(v -> {
            Intent intent = new Intent(DashBoardPage.this, SettingsPage.class);
            intent.putExtra("EXTRA_USERNAME", username);
            intent.putExtra("EXTRA_BIO", bio);
            intent.putExtra("EXTRA_STATUS", intStatus);
            intent.putExtra("EXTRA_BGCOLOR", bgcolor);
            intent.putExtra("EXTRA_FCOLOR", fcolor);
            startActivity(intent);
            finish();
        });

        String name1 = "Mike Morales";
        String name2 = "John Doe";
        String name3 = "Mark Carter";
        String name4 = "Arthur Morgan";
        String name5 = "Dutch";
        String name6 = "Micah Bell";
        String name7 = "James Band";

        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(DashBoardPage.this, UserDirectMessage.class);
                newIntent.putExtra("EXTRA_USERNAME", username);
                newIntent.putExtra("EXTRA_BIO", bio);
                newIntent.putExtra("EXTRA_STATUS", intStatus);
                newIntent.putExtra("EXTRA_BGCOLOR", bgcolor);
                newIntent.putExtra("EXTRA_FCOLOR", fcolor);
                newIntent.putExtra("EXTRA_USER", name1);
                startActivity(newIntent);
            }
        });

        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(DashBoardPage.this, UserDirectMessage.class);
                newIntent.putExtra("EXTRA_USERNAME", username);
                newIntent.putExtra("EXTRA_BIO", bio);
                newIntent.putExtra("EXTRA_STATUS", intStatus);
                newIntent.putExtra("EXTRA_BGCOLOR", bgcolor);
                newIntent.putExtra("EXTRA_FCOLOR", fcolor);
                newIntent.putExtra("EXTRA_USER", name2);
                startActivity(newIntent);
            }
        });

        user3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(DashBoardPage.this, UserDirectMessage.class);
                newIntent.putExtra("EXTRA_USERNAME", username);
                newIntent.putExtra("EXTRA_BIO", bio);
                newIntent.putExtra("EXTRA_STATUS", intStatus);
                newIntent.putExtra("EXTRA_BGCOLOR", bgcolor);
                newIntent.putExtra("EXTRA_FCOLOR", fcolor);
                newIntent.putExtra("EXTRA_USER", name3);
                startActivity(newIntent);
            }
        });

        user4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(DashBoardPage.this, UserDirectMessage.class);
                newIntent.putExtra("EXTRA_USERNAME", username);
                newIntent.putExtra("EXTRA_BIO", bio);
                newIntent.putExtra("EXTRA_STATUS", intStatus);
                newIntent.putExtra("EXTRA_BGCOLOR", bgcolor);
                newIntent.putExtra("EXTRA_FCOLOR", fcolor);
                newIntent.putExtra("EXTRA_USER", name4);
                startActivity(newIntent);
            }
        });

        user5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(DashBoardPage.this, UserDirectMessage.class);
                newIntent.putExtra("EXTRA_USERNAME", username);
                newIntent.putExtra("EXTRA_BIO", bio);
                newIntent.putExtra("EXTRA_STATUS", intStatus);
                newIntent.putExtra("EXTRA_BGCOLOR", bgcolor);
                newIntent.putExtra("EXTRA_FCOLOR", fcolor);
                newIntent.putExtra("EXTRA_USER", name5);
                startActivity(newIntent);
            }
        });

        user6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(DashBoardPage.this, UserDirectMessage.class);
                newIntent.putExtra("EXTRA_USERNAME", username);
                newIntent.putExtra("EXTRA_BIO", bio);
                newIntent.putExtra("EXTRA_STATUS", intStatus);
                newIntent.putExtra("EXTRA_BGCOLOR", bgcolor);
                newIntent.putExtra("EXTRA_FCOLOR", fcolor);
                newIntent.putExtra("EXTRA_USER", name6);
                startActivity(newIntent);
            }
        });

        user7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(DashBoardPage.this, UserDirectMessage.class);
                newIntent.putExtra("EXTRA_USERNAME", username);
                newIntent.putExtra("EXTRA_BIO", bio);
                newIntent.putExtra("EXTRA_STATUS", intStatus);
                newIntent.putExtra("EXTRA_BGCOLOR", bgcolor);
                newIntent.putExtra("EXTRA_FCOLOR", fcolor);
                newIntent.putExtra("EXTRA_USER", name7);
                startActivity(newIntent);
            }
        });

    }
}
