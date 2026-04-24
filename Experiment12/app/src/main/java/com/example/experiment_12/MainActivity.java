package com.example.experiment_12;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.database.Cursor;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    EditText editName;
    Button btnInsert, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        editName = findViewById(R.id.editName);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);

        // Insert Data
        btnInsert.setOnClickListener(v -> {
            String name = editName.getText().toString();

            boolean isInserted = db.insertData(name);
            if (isInserted)
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        });

        // View Data
        btnView.setOnClickListener(v -> {
            Cursor cursor = db.getData();

            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder buffer = new StringBuilder();
            while (cursor.moveToNext()) {
                buffer.append("ID: ").append(cursor.getInt(0)).append("\n");
                buffer.append("Name: ").append(cursor.getString(1)).append("\n\n");
            }

            // Using AlertDialog instead of Toast for better visibility
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Student Data");
            builder.setMessage(buffer.toString());
            builder.show();
        });
    }
}