package com.example.cputtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {

    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        editText2 = findViewById(R.id.editText2);
    }

    public void onViewAct2(View view){
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("previousText", editText2.getText().toString());
        startActivity(intent);
    }
}
