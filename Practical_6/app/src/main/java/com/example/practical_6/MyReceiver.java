package com.example.practical_6;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context,
                    "Power Connected Broadcast Received",
                    Toast.LENGTH_LONG).show();
        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context,
                    "Power Disconnected Broadcast Received",
                    Toast.LENGTH_LONG).show();
        }
    }
}