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

public class GroupChatPage extends AppCompatActivity {

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
        String group = fetchIntent.getStringExtra("EXTRA_GROUP");
        String bgcolor = fetchIntent.getStringExtra("EXTRA_BGCOLOR");
        String fcolor = fetchIntent.getStringExtra("EXTRA_FCOLOR");

        rootview = findViewById(R.id.main);

        rootview.setBackgroundColor(Color.parseColor(bgcolor));
        title.setTextColor(Color.parseColor(fcolor));

        if (group.equals("LeagueOfGeeks")) {
            profile.setImageResource(R.drawable.geekimage);
            title.setText("LEAGUE OF GEEKS");
        }else if (group.equals("CatLovers")) {
            profile.setImageResource(R.drawable.catsimage);
            title.setText("CAT LOVERS");
        }else if (group.equals("OnlyGym")) {
            profile.setImageResource(R.drawable.gymimage);
            title.setText("ONLY GYM");
        }else if (group.equals("Cutters")) {
            profile.setImageResource(R.drawable.cuttersimage);
            title.setText("CUTTERS");
        }else if (group.equals("BeautyKids")) {
            profile.setImageResource(R.drawable.beautykidsimage);
            title.setText("BEAUTY KIDS");
        }else if (group.equals("TheGrahams")) {
            profile.setImageResource(R.drawable.grahamsimage);
            title.setText("THE GRAHAMS");
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