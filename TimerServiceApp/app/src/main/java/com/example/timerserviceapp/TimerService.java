package com.example.timerserviceapp;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
public class TimerService extends Service {
    int seconds = 0;
    boolean running = true;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(1000);
                        seconds++;
                        // Must run Toast on main thread
                        android.os.Handler handler = new android.os.Handler(
                                android.os.Looper.getMainLooper());
                        handler.post(() ->
                                Toast.makeText(getApplicationContext(),
                                        "Timer: " + seconds + " seconds",
                                        Toast.LENGTH_SHORT).show()
                        );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        running = false;
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}