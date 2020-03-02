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

public class Activity4 extends AppCompatActivity {

    String GetIntent, TextInput, PutExtra, TextViewHeader;
    TextView textInput, textView;
    EditText editText4;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        TextViewHeader = "Messages from Activity 3";
        textInput = findViewById(R.id.editTextAct4);
        TextInput = textInput.getText().toString();
        textView = findViewById(R.id.textViewPg4);
        GetIntent = Objects.requireNonNull(getIntent().getExtras()).getString("Page3Value");
        PutExtra = String.format("%s\n %s", GetIntent, TextInput);
        textView.setText(String.format("%s\n %s", TextViewHeader, PutExtra));

        /*editText4 = findViewById(R.id.editTextAct4);
        getIntent().getStringExtra("previousText");*/

        Button button4 = findViewById(R.id.goToAct5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act4Intent = new Intent(getApplicationContext(), Activity5.class);
                act4Intent.putExtra("Page4Value", PutExtra);
                startActivity(act4Intent);
                finish();
            }
        });
    }

    public void onViewAct5(View view){
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent);
    }
}
