package com.example.cputtestapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class Activity6 extends AppCompatActivity {

    String GetIntent, TextInput, PutExtra, TextViewHeader;
    TextView textInput, textView;
    EditText editText6;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        TextViewHeader = "Messages from Activity 5";
        textInput = findViewById(R.id.editTextAct6);
        TextInput = textInput.getText().toString();
        textView = findViewById(R.id.textViewPg6);
        GetIntent = Objects.requireNonNull(getIntent().getExtras()).getString("Page5Value");
        PutExtra = String.format("%s\n %s", GetIntent, TextInput);
        textView.setText(String.format("%s\n %s", TextViewHeader, PutExtra));

        /*editText6 = findViewById(R.id.editTextAct6);
        getIntent().getStringExtra("previousText");*/

        Button button6 = findViewById(R.id.goToAct7);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act6Intent = new Intent(getApplicationContext(), Activity7.class);
                act6Intent.putExtra("Page6Value", PutExtra);
                startActivity(act6Intent);
                finish();
            }
        });
    }

    public void onViewAct7(View view){
        Intent intent = new Intent(this, Activity7.class);
        startActivity(intent);
    }
}
