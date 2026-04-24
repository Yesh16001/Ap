package com.example.contentproviderdemo;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnInsert, btnShow;
    Uri uri = Uri.parse("content://com.example.provider");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        btnInsert.setOnClickListener(v -> {
            ContentValues values = new ContentValues();
            values.put("name", editText.getText().toString());
            getContentResolver().insert(uri, values);
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
            editText.setText("");
        });
        btnShow.setOnClickListener(v -> {
            Cursor cursor = getContentResolver().query(
                    uri, null, null, null, null);
            String result = "";
            while (cursor.moveToNext()) {
                result += cursor.getString(0) + "\n";
            }
            // Show all names in AlertDialog
            new AlertDialog.Builder(this)
                    .setTitle("Names List")
                    .setMessage(result)
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}