package com.example.practical_8;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    // Declare UI elements
    Button btnDialog, btnDate, btnTime;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Connect XML views to Java variables
        btnDialog  = findViewById(R.id.btnDialog);
        btnDate    = findViewById(R.id.btnDate);
        btnTime    = findViewById(R.id.btnTime);
        txtResult  = findViewById(R.id.txtResult);
        btnDialog.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Confirmation");
            builder.setMessage("Do you want to continue?");
            // YES button
            builder.setPositiveButton("Yes", (dialog, which) -> {
                Toast.makeText(MainActivity.this,
                        "You clicked YES",
                        Toast.LENGTH_SHORT).show();
                txtResult.setText("You clicked: YES");
            });
            // NO button
            builder.setNegativeButton("No", (dialog, which) -> {
                Toast.makeText(MainActivity.this,
                        "You clicked NO",
                        Toast.LENGTH_SHORT).show();
                txtResult.setText("You clicked: NO");
            });
            builder.show();
        });
        btnDate.setOnClickListener(v -> {
            // Get today's date as default
            Calendar calendar = Calendar.getInstance();
            int year  = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day   = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (view, year1, month1, dayOfMonth) -> {
                        // month1 is 0-based so add 1
                        String selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                        txtResult.setText("Selected Date: " + selectedDate);
                    },
                    year, month, day
            );
            datePickerDialog.show();
        });
        btnTime.setOnClickListener(v -> {
            // Get current time as default
            Calendar calendar = Calendar.getInstance();
            int hour   = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    MainActivity.this,
                    (view, hourOfDay, minute1) -> {
                        // Format minute to always show 2 digits e.g. 9:05 not 9:5
                        String formattedTime = hourOfDay + ":"
                                + String.format("%02d", minute1);
                        txtResult.setText("Selected Time: " + formattedTime);
                    },
                    hour,
                    minute,
                    true   // true = 24 hour format
            );

            timePickerDialog.show();
        });
    }
}
