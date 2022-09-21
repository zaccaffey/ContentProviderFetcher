package com.example.contentproviderfetcher;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle, tvSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getData(View view) {
      //  try {

            tvTitle = findViewById(R.id.tvTitle);
            tvSubtitle = findViewById(R.id.tvSubtitle);

            Uri uri = Uri.parse("content://cognizant.todo/entry");
            //Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        // THIS IS RETURNING NULL FOR SOME REASON (NEED TO FIND A WORK AROUND)
        Cursor cursor = getContentResolver().query(uri,null,null,null,null,null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow("title");
        int subtitleIndex = cursor.getColumnIndexOrThrow("subtitle");

        String result = cursor.getString(titleIndex)+"\n"+ cursor.getString(subtitleIndex);

          /*  if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                         tvTitle.setText(cursor.getColumnIndex("title"));
                         tvSubtitle.setText(cursor.getColumnIndex("subtitle"));
                        Log.i(TAG, "getData: success");
                    } while (cursor.moveToNext());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i(TAG, "getData: failed");
        }*/
        }


}