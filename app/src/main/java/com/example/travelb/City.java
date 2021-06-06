package com.example.travelb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class City extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

    Button buttonStart = (Button) findViewById(R.id.back1);

        buttonStart.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            try {
                Intent intent = new Intent(City.this, Search.class);
                startActivity(intent);
                finish();

            } catch (Exception e) {

            }
        }

    });
}
}