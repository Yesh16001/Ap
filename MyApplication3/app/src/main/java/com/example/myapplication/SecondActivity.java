package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practical_3.R;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("Lifecycle", "SecondActivity: onCreate");
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(SecondActivity.this, WelcomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
    @Override protected void onStart() { super.onStart(); Log.d("Lifecycle", "SecondActivity: onStart"); }
    @Override protected void onResume() { super.onResume(); Log.d("Lifecycle", "SecondActivity: onResume"); }
    @Override protected void onPause() { super.onPause(); Log.d("Lifecycle", "SecondActivity: onPause"); }
    @Override protected void onStop() { super.onStop(); Log.d("Lifecycle", "SecondActivity: onStop"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d("Lifecycle", "SecondActivity: onDestroy"); }
}
