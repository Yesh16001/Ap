package com.example.timerserviceapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    Button startService, stopService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService = findViewById(R.id.startService);
        stopService = findViewById(R.id.stopService);
        startService.setOnClickListener(v ->
                startService(new Intent(MainActivity.this, TimerService.class))
        );
        stopService.setOnClickListener(v ->
                stopService(new Intent(MainActivity.this, TimerService.class))
        );
    }
}