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

        btnSearchGroup = (ImageButton) findViewById(R.id.btnSearchGroup);
        btnProfile = (ImageButton) findViewById(R.id.btnProfile);
        btnSetting = findViewById(R.id.btnSettings);

        recyclerView = findViewById(R.id.recyclerViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        rootView = findViewById(R.id.main);
        user1 = findViewById(R.id.imgUser1);
        user2 = findViewById(R.id.imgUser2);
        user3 = findViewById(R.id.imgUser3);
        user4 = findViewById(R.id.imgUser4);
        user5 = findViewById(R.id.imgUser5);
        user6 = findViewById(R.id.imgUser6);
        user7 = findViewById(R.id.imgUser7);
        header = findViewById(R.id.textView10);
        adapter = new MessageAdapter(messages);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


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
        btnSearchGroup.setBackgroundColor(Color.parseColor(bgcolor));
        buttonSend.setBackgroundColor(Color.parseColor(fcolor));
        buttonSend.setBackgroundColor(Color.parseColor(bgcolor));


        btnSearchGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardPage.this, SearchPage.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_BIO", bio);
                intent.putExtra("EXTRA_STATUS", intStatus);
                intent.putExtra("EXTRA_BGCOLOR", bgcolor);
                intent.putExtra("EXTRA_FCOLOR", fcolor);
                startActivity(intent);
                finish();
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextMessage.getText().toString();
                if (!text.isEmpty()) {
                    Message newMessage = new Message(text);
                    messages.add(newMessage);
                    adapter.notifyItemInserted(messages.size() - 1);
                    recyclerView.scrollToPosition(messages.size() - 1);
                    editTextMessage.setText("");
                }
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardPage.this, EditUserPage.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_BIO", bio);
                intent.putExtra("EXTRA_STATUS", intStatus);
                intent.putExtra("EXTRA_BGCOLOR", bgcolor);
                intent.putExtra("EXTRA_FCOLOR", fcolor);
                startActivity(intent);
                finish();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardPage.this, SettingsPage.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_BIO", bio);
                intent.putExtra("EXTRA_STATUS", intStatus);
                intent.putExtra("EXTRA_BGCOLOR", bgcolor);
                intent.putExtra("EXTRA_FCOLOR", fcolor);
                startActivity(intent);
                finish();
            }
        });
    }
}