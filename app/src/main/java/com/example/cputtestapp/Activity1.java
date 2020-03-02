package com.example.cputtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Activity1 extends AppCompatActivity {

    String GetIntent, TextInput, PutExtra, TextViewHeader;
    TextView textInput, textView;
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //editText1 = findViewById(R.id.editTextAct1);
        textInput = findViewById(R.id.editTextAct1);
        TextInput = textInput.getText().toString();
        textView = findViewById(R.id.textViewPg1);
        GetIntent = getIntent().getStringExtra("MainPageValue");
        TextViewHeader = "No values from Main Page";

        if(getIntent().getStringExtra("MainPageValue") == null){
            textView.setText(TextViewHeader);
            Toast.makeText(this, "NULL", Toast.LENGTH_LONG).show();
        } else {
            PutExtra = String.format("%s \n %s", TextViewHeader,GetIntent);
            textView.setText(PutExtra);
        }

        Button button1 = findViewById(R.id.goToAct2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act1Intent = new Intent(getApplicationContext(), Activity2.class);
                act1Intent.putExtra("Page1Value", TextInput);
                startActivity(act1Intent);
                finish();
            }
        });
    }

    public void onViewAct2(View view){
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("previousText", editText1.getText().toString());
        startActivity(intent);
    }
}
