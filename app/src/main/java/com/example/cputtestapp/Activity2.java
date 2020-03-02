package com.example.cputtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        editText = findViewById(R.id.editText);
        getIntent().getStringExtra("previousText");
    }

    public void onViewAct3(View view){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}
