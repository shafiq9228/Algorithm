package com.task.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView Add;
    ListView Lst;
    public ArrayList<String> ST = new ArrayList<>();
    public ArrayList<String> SUBJECT = new ArrayList<>();
    public ArrayList<String> ET= new ArrayList<>();
    public ArrayList<String> Profit= new ArrayList<>();
    LAdapter adapter;

    FrameLayout Dialog;
    ImageView Cancel;

    Button AddData;
    Button Calculate;

    EditText FST,FET,FProfit,FSB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Add = findViewById(R.id.Add);
        Lst = findViewById(R.id.Lst);
        adapter = new LAdapter(MainActivity.this, SUBJECT,ST,ET, Profit);
        Dialog = findViewById(R.id.Dialog_Layout);
        Cancel = findViewById(R.id.cancel);
        AddData = findViewById(R.id.fadd2);
        Calculate = findViewById(R.id.Calculate);

        FST =  findViewById(R.id.fst2);
        FET = findViewById(R.id.fet2);
        FProfit = findViewById(R.id.fprofit2);
        FSB = findViewById(R.id.fsb2);

        Lst.setAdapter(adapter);

        Toast.makeText(this, "Toast Added is changed", Toast.LENGTH_SHORT).show();

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                ST.add("he");
                ET.add("Wdsf");
                Profit.add("Dsf");
                adapter.notifyDataSetChanged();
                */

                Dialog.setVisibility(View.VISIBLE);

              //  Lst.notify();

            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog.setVisibility(View.GONE);
            }
        });

        AddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog.setVisibility(View.GONE);

                String Fsb = FSB.getText().toString();
                String Fst = FST.getText().toString();
                String Fet = FET.getText().toString();
                String Fprofit = FProfit.getText().toString();

                SUBJECT.add(""+Fsb);
                ST.add(""+Fst);
                ET.add(""+Fet);
                Profit.add(""+Fprofit);

                adapter.notifyDataSetChanged();

                FET.setText("");
                FST.setText("");
                FSB.setText("");
                FProfit.setText("");
            }
        });

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("Result",30);
                startActivity(intent);

            }
        });
    }
}