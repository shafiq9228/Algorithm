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
    public ArrayList<Integer> ST = new ArrayList<>();
    public ArrayList<String> SUBJECT = new ArrayList<>();
    public ArrayList<Integer> ET= new ArrayList<>();
    public ArrayList<Integer> Profit= new ArrayList<>();
    LAdapter adapter;

    FrameLayout Dialog;
    ImageView Cancel,Clear;

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

        Clear = findViewById(R.id.Clear);

        Lst.setAdapter(adapter);

       // Toast.makeText(this, "Toast Added is changed", Toast.LENGTH_SHORT).show();

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



                if(FST.getText().toString().length()<1 || FET.getText().toString().length()<1 || FProfit.getText().toString().length()<1 || FSB.getText().toString().length()<1)
                {
                    Toast.makeText(MainActivity.this, "Inputs Cannot be Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Dialog.setVisibility(View.GONE);

                    String Fsb = FSB.getText().toString();
                    int Fst = Integer.parseInt(FST.getText().toString());
                    int Fet = Integer.parseInt(FET.getText().toString());
                    int Fprofit = Integer.parseInt(FProfit.getText().toString());

                    SUBJECT.add("" + Fsb);
                    ST.add(Fst);
                    ET.add(Fet);
                    Profit.add(Fprofit);
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



                Job joblist[] = new Job[ST.size()];

                if(joblist.length==0)
                {
                    Toast.makeText(getApplicationContext(),"Empty subjects",Toast.LENGTH_SHORT).show();
                    return;
                }

                for(int i=0;i<ST.size();i++)
                {
                    joblist[i] = new Job(ST.get(i),ET.get(i),Profit.get(i));
                }

                int Result = WeightedIntervalScheduling.schedule(joblist);


                  Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                  intent.putExtra("Result",Result);
                  startActivity(intent);


             //   Job jobs[] = {new Job(2, 100, 200),new Job(3, 5, 20),new Job(1, 2, 50), new Job(6, 19, 100)};



            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ST.add(0);
                ET.add(1);
                SUBJECT.add("dcv");
                Profit.add(2);

                ST.removeAll(ST);
                ET.removeAll(ET);
                SUBJECT.removeAll(SUBJECT);
                Profit.removeAll(Profit);

                adapter.notifyDataSetChanged();
            }
        });
    }
}