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

public class Activity3 extends AppCompatActivity {

    String GetIntent, TextInput, PutExtra, TextViewHeader;
    TextView textInput, textView;
    EditText editText3;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        TextViewHeader = "Messages from Activity 2";
        textInput = findViewById(R.id.editTextAct3);
        TextInput = textInput.getText().toString();
        textView = findViewById(R.id.textViewPg3);
        GetIntent = Objects.requireNonNull(getIntent().getExtras()).getString("Page2Value");
        PutExtra = String.format("%s\n %s", GetIntent, TextInput);
        textView.setText(String.format("%s\n %s", TextViewHeader, PutExtra));

        /*editText3 = findViewById(R.id.editTextAct3);
        getIntent().getStringExtra("previousText");*/

        Button button3 = findViewById(R.id.goToAct4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act3Intent = new Intent(getApplicationContext(), Activity4.class);
                act3Intent.putExtra("Page3Value", PutExtra);
                startActivity(act3Intent);
                finish();
            }
        });
    }

        public void onViewAct4(View view){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
}
