package com.example.travelb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;

public class Kalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalendar);
        //
        Button buttonK = (Button) findViewById(R.id.backkkal);

        buttonK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Kalendar.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }

        });
   /* ImageView buttonS = (ImageView) findViewById(R.id.imageView4);

        buttonS.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            try {
                Intent intent = new Intent(Kalendar.this, HomeActivity.class);
                startActivity(intent);
                finish();

            } catch (Exception e) {

            }
        }

    });*/

}
}