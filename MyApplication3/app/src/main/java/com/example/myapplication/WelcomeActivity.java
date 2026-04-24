package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practical_3.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Log.d("Lifecycle", "WelcomeActivity: onCreate");

        TextView tvWelcome = findViewById(R.id.tvWelcome);
        String username = getIntent().getStringExtra("username");
        tvWelcome.setText("Welcome, " + username + "!");
    }

    @Override protected void onStart() { super.onStart(); Log.d("Lifecycle", "WelcomeActivity: onStart"); }
    @Override protected void onResume() { super.onResume(); Log.d("Lifecycle", "WelcomeActivity: onResume"); }
    @Override protected void onPause() { super.onPause(); Log.d("Lifecycle", "WelcomeActivity: onPause"); }
    @Override protected void onStop() { super.onStop(); Log.d("Lifecycle", "WelcomeActivity: onStop"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d("Lifecycle", "WelcomeActivity: onDestroy"); }
}
