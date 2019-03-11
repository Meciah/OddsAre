package com.example.oddsare;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Dialog myDialog;
    EditText pcount;
    EditText editText;
    ArrayList<Integer> plcount = new ArrayList<Integer>();
    ArrayList<Integer> odds = new ArrayList<Integer>();
    int cc=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);

        pcount = findViewById(R.id.editTextpl);
        editText = findViewById(R.id.editText);

        Button pcbutton = findViewById(R.id.playerbtn);
        pcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plcount.add(Integer.valueOf(pcount.getText().toString()));
                pcount.setText("");
            }
        });

        final Button button = findViewById(R.id.mainbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cc=cc+1;
                if(cc != plcount.get(0)+1) {
                    odds.add(Integer.valueOf(editText.getText().toString()));
                    editText.setText("");
                }
                else{
                    editText.setText("");
                    button.setVisibility(View.GONE);
                }
            }
        });

        Button pbutton = findViewById(R.id.playbtn);
        pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v);
                //if(odds.get(0)== odds.get(1)){
                    //showToast("Odds Match");
                    //recreate();
                //}
                //else{
                    //showToast("No Match");
                    //recreate();
                //}
            }
        });


    }
    private void showToast(String text){
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    public void ShowPopup(View v) {
        long countDown = 3000;
        long interval = 1000;
        final CountDownTimer countDownTimer;
        final TextView textic;
        TextView txtclose;
        final Button btnPlay;
        myDialog.setContentView(R.layout.playpopup);
        textic = (TextView) myDialog.findViewById(R.id.textView2);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        btnPlay = (Button) myDialog.findViewById(R.id.btnplay);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                recreate();
            }
        });

        countDownTimer = new CountDownTimer(countDown, interval) {

            @Override
            public void onTick(long millisUntilFinished) {
                textic.setText(String.format(Locale.getDefault(),"%s", Long.toString(millisUntilFinished/1000)));
            }

            @Override
            public void onFinish() {
            }
        };
        textic.setText(String.format(Locale.getDefault(),"%s",Long.toString(countDown/1000)));
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });
        myDialog.show();
    }





}


