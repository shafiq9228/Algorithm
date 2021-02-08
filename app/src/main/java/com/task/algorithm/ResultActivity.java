package com.task.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Result = findViewById(R.id.result);

        int R1 = getIntent().getIntExtra("Result",0);

        Result.setText(""+R1);
    }
}