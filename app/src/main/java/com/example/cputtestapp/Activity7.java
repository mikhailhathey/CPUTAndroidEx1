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

public class Activity7 extends AppCompatActivity {

    String GetIntent, TextInput, PutExtra, TextViewHeader;
    TextView textInput, textView;
    EditText editText7;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);

        TextViewHeader = "Messages from Activity 6";
        textInput = findViewById(R.id.editTextAct7);
        TextInput = textInput.getText().toString(); //Move this to OnClick Method - Line 1
        textView = findViewById(R.id.textViewEnd);
        GetIntent = Objects.requireNonNull(getIntent().getExtras()).getString("Page6Value");
        PutExtra = String.format("%s\n %s", GetIntent, TextInput); //Move this to OnClick Method - Line 2
        textView.setText(String.format("%s\n %s", TextViewHeader, PutExtra));

        /*editText7 = findViewById(R.id.editTextAct7);
        getIntent().getStringExtra("previousText");*/

        Button button7 = findViewById(R.id.goToEnd);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act7Intent = new Intent(getApplicationContext(), MainActivity.class);
                act7Intent.putExtra("Page7Value", PutExtra);
                startActivity(act7Intent);
                finish();
            }
        });
    }


}
