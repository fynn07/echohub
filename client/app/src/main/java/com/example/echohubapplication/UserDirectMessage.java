package com.example.echohubapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserDirectMessage extends AppCompatActivity {

    View rootview;
    ImageView profile;
    TextView title;
    private List<Message> messageList = new ArrayList<>();
    private MessageAdapter messageAdapter;
    private RecyclerView recyclerView;
    private EditText editTextMessage;
    private Button buttonSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_group_chat_page);

        profile = findViewById(R.id.imgProfile);
        title = findViewById(R.id.txtGroupName);

        Intent fetchIntent = getIntent();
        String user = fetchIntent.getStringExtra("EXTRA_USER");
        String bgcolor = fetchIntent.getStringExtra("EXTRA_BGCOLOR");
        String fcolor = fetchIntent.getStringExtra("EXTRA_FCOLOR");

        rootview = findViewById(R.id.main);

        rootview.setBackgroundColor(Color.parseColor(bgcolor));
        title.setTextColor(Color.parseColor(fcolor));

        if (user.equals("Mike Morales")) {
            profile.setImageResource(R.drawable.young_dark_haired_man_icon_flat_illustration_young_dark_haired_man_vector_icon_web_isolated_yellow_background_96318_25361);
            title.setText("Mike Morales");
        }else if (user.equals("John Doe")) {
            profile.setImageResource(R.drawable.user_icon_flat_style_any_design_96318_12149);
            title.setText("John Doe");
        }else if (user.equals("Mark Carter")) {
            profile.setImageResource(R.drawable.user_icon_flat_style_any_design_96318_12151);
            title.setText("Mark Carter");
        }else if (user.equals("Arthur Morgan")) {
            profile.setImageResource(R.drawable.user_icon_flat_style_any_design_96318_12137);
            title.setText("Arthur Morgan");
        }else if (user.equals("Dutch")) {
            profile.setImageResource(R.drawable.boy_icon_flat_style_any_design_96318_12145);
            title.setText("Dutch");
        }else if (user.equals("Micah Bell")) {
            profile.setImageResource(R.drawable.soldier_icon_flat_style_with_long_shadow_military_symbol_vector_illustration_96318_21620);
            title.setText("Micah Bell");
        }else if (user.equals("James Band")) {
            profile.setImageResource(R.drawable.military_helmet_icon_flat_style_with_long_shadow_96318_16006);
            title.setText("James Band");
        }

        recyclerView = findViewById(R.id.recyclerViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = editTextMessage.getText().toString();
                if (!messageText.isEmpty()) {
                    Message message = new Message(messageText);
                    messageList.add(message);
                    messageAdapter.notifyItemInserted(messageList.size() - 1);
                    editTextMessage.setText("");
                    recyclerView.scrollToPosition(messageList.size() - 1);
                }
            }
        });
    }
}