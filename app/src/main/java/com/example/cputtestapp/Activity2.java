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

import org.w3c.dom.Text;

import java.util.Objects;

public class Activity2 extends AppCompatActivity {

    String GetIntent, TextInput, PutExtra, TextViewHeader;
    TextView textInput, textView;
    EditText editText2;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextViewHeader = "Messages from Activity 1";
        textInput = findViewById(R.id.editTextAct2);
        TextInput = textInput.getText().toString();
        textView = findViewById(R.id.textViewPg2);
        GetIntent = Objects.requireNonNull(getIntent().getExtras()).getString("Page1Value");
        PutExtra = String.format("%s\n %s", GetIntent, TextInput);
        textView.setText(String.format("%s\n %s", TextViewHeader, PutExtra));

        /*editText2 = findViewById(R.id.editTextAct2);
        getIntent().getStringExtra("previousText");*/

        Button button2 = findViewById(R.id.goToAct3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act2Intent = new Intent(getApplicationContext(), Activity3.class);
                act2Intent.putExtra("Page2Value", PutExtra);
                startActivity(act2Intent);
                finish();
            }
        });
    }

    public void onViewAct3(View view){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}
