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

public class LoginPage extends AppCompatActivity {

    Button btnLogin;

    EditText user, pass;

    public static final String[][] USER_CREDENTIALS = new String[][] {
            {"username1", "password1", "A Senior Financial Analyst at EchoHub with a knack for streamlining financial operations and improving profitability. He holds an MBA from CIT and is a certified public accountant."},
            {"username2", "password2", "Shares her global adventures and travel tips on her blog inspiring others to explore the world."},
            {"username3", "password3", "NYC-based captures urban life and cultural diversity in vibrant digital art, featured in various publications and galleries. DM for collaborations."}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        user = findViewById(R.id.usernameEditText);
        pass = findViewById(R.id.passwordEditText);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String status = "active";

                String bio = isValidCredentials(username, password);

                if (bio != null) {
                    Intent intent = new Intent(LoginPage.this, DashBoardPage.class);
                    intent.putExtra("EXTRA_USERNAME", username);
                    intent.putExtra("EXTRA_BIO", bio);
                    intent.putExtra("EXTRA_STATUS", status);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginPage.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String isValidCredentials(String username, String password) {
        for (String[] credentials : USER_CREDENTIALS) {
            if (credentials[0].equals(username) && credentials[1].equals(password)) {
                return credentials[2];
            }
        }
        return null;
    }
}