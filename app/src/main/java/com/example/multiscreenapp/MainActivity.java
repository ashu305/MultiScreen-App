package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.multiscreenapp.Activities.ColorsActivity;
import com.example.multiscreenapp.Activities.FamilyActivity;
import com.example.multiscreenapp.Activities.NumbersActivity;
import com.example.multiscreenapp.Activities.PhrasesActivity;

public class MainActivity extends AppCompatActivity {
    private TextView txtNumbers, txtfamily, txtcolor, txtphrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitViews();
        OnClickMethods();

    }

    private void OnClickMethods() {
        txtNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                intent.putExtra("Colour", "#FD8E09");
                startActivity(intent);
            }
        });

        txtphrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(intent);
            }
        });

        txtfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(intent);
            }
        });

        txtcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void InitViews() {
        txtcolor = findViewById(R.id.txtcolors);
        txtfamily = findViewById(R.id.txtfamily);
        txtNumbers = findViewById(R.id.txtnumbers);
        txtphrase = findViewById(R.id.txtphrases);
    }


}