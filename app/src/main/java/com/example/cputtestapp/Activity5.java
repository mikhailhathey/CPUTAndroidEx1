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

public class Activity5 extends AppCompatActivity {

    String GetIntent, TextInput, PutExtra, TextViewHeader;
    TextView textInput, textView;
    EditText editText5;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        TextViewHeader = "Messages from Activity 4";
        textInput = findViewById(R.id.editTextAct5);
        TextInput = textInput.getText().toString(); //Move this to OnClick Method - Line 1
        textView = findViewById(R.id.textViewPg5);
        GetIntent = Objects.requireNonNull(getIntent().getExtras()).getString("Page4Value");
        PutExtra = String.format("%s\n %s", GetIntent, TextInput); //Move this to OnClick Method - Line 2
        textView.setText(String.format("%s\n %s", TextViewHeader, PutExtra));

        /*editText5 = findViewById(R.id.editTextAct5);
        getIntent().getStringExtra("previousText");*/

        Button button5 = findViewById(R.id.goToAct6);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act5Intent = new Intent(getApplicationContext(), Activity6.class);
                act5Intent.putExtra("Page5Value", PutExtra);
                startActivity(act5Intent);
                finish();
            }
        });
    }

    public void onViewAct6(View view){
        Intent intent = new Intent(this, Activity6.class);
        startActivity(intent);
    }
}
