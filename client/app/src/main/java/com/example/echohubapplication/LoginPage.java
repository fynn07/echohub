package com.example.echohubapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends AppCompatActivity {

    Button btnLogin;
    EditText user, pass;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        initializeUsers();

        user = findViewById(R.id.usernameEditText);
        pass = findViewById(R.id.passwordEditText);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String bgcolor = "#4A36DB";
                String fcolor = "#FFFFFF";

                String bio = isValidCredentials(username, password);
                if (bio != null) {
                    Intent intent = new Intent(LoginPage.this, DashBoardPage.class);
                    intent.putExtra("EXTRA_USERNAME", username);
                    intent.putExtra("EXTRA_BIO", bio);
                    intent.putExtra("EXTRA_STATUS", "active");
                    intent.putExtra("EXTRA_BGCOLOR", bgcolor);
                    intent.putExtra("EXTRA_FCOLOR", fcolor);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginPage.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String isValidCredentials(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getBio();
            }
        }
        return null;
    }

    private void initializeUsers() {
        users = new ArrayList<>();
        users.add(new User("Zotic", "password1", "A Senior Financial Analyst at EchoHub with a knack for streamlining financial operations and improving profitability. He holds an MBA from CIT and is a certified public accountant."));
        users.add(new User("Grahams123", "password2", "Shares her global adventures and travel tips on her blog inspiring others to explore the world."));
        users.add(new User("Euphoria456", "password3", "NYC-based captures urban life and cultural diversity in vibrant digital art, featured in various publications and galleries. DM for collaborations."));
        users.add(new User("FamilyMatters", "password4", "Tech enthusiast and software developer specializing in modern web and mobile applications."));
        users.add(new User("NawtLaikeOus", "password5", "Professional photographer who captures the beauty of urban landscapes and natural wonders."));
        users.add(new User("ArtVandelay", "password6", "Architect and art enthusiast with a deep appreciation for modern design and sustainability."));
        users.add(new User("MasterChefJulia", "password7", "Renowned chef and food critic who explores culinary delights and innovative cooking techniques."));
        users.add(new User("TheRealSherlock", "password8", "Private detective with a keen eye for detail, solving mysteries with unconventional methods."));
        users.add(new User("OceanDiver", "password9", "Marine biologist dedicated to the conservation of marine ecosystems and passionate about deep-sea exploration."));
        users.add(new User("QuantumLeap", "password10", "Physicist researching quantum mechanics and theoretical particles at a leading tech institute."));
        users.add(new User("DaisyGardener", "password11", "Horticulturist who specializes in sustainable gardening practices and rare plant cultivation."));
        users.add(new User("DigitalNomad", "password12", "Freelance graphic designer who travels the world while working remotely, showcasing a portfolio of diverse, vibrant projects."));
    }

}
