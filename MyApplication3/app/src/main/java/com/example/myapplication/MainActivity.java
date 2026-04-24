package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practical_3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "MainActivity: onCreate");

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }

    @Override protected void onStart() { super.onStart(); Log.d("Lifecycle", "MainActivity: onStart"); }
    @Override protected void onResume() { super.onResume(); Log.d("Lifecycle", "MainActivity: onResume"); }
    @Override protected void onPause() { super.onPause(); Log.d("Lifecycle", "MainActivity: onPause"); }
    @Override protected void onStop() { super.onStop(); Log.d("Lifecycle", "MainActivity: onStop"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d("Lifecycle", "MainActivity: onDestroy"); }
}
