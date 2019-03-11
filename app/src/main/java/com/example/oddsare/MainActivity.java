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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int result;
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

        final Button pcbutton = findViewById(R.id.playerbtn);
        pcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plcount.add(Integer.valueOf(pcount.getText().toString()));
                pcount.setText("");
                pcbutton.setVisibility(View.GONE);
                pcount.setVisibility(View.GONE);
            }
        });

        final Button button = findViewById(R.id.mainbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cc=cc+1;
                if(cc == plcount.get(0)){
                    button.setVisibility(View.GONE);
                    editText.setVisibility(View.GONE);
                }else{}

                if(cc != plcount.get(0)+1) {
                    odds.add(Integer.valueOf(editText.getText().toString()));
                    editText.setText("");
                }
                else{
                    editText.setText("");
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
        final TextView p1score;
        final TextView p2score;
        final TextView p3score;
        myDialog.setContentView(R.layout.playpopup);
        p1score = (TextView) myDialog.findViewById(R.id.p1sc);
        p2score = (TextView) myDialog.findViewById(R.id.p2sc);
        p3score = (TextView) myDialog.findViewById(R.id.p3sc);
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
                if(odds.get(0).equals(odds.get(1)) || odds.get(1).equals(odds.get(2)) || odds.get(0).equals(odds.get(2))){
                    textic.setText(String.format(Locale.getDefault(),"%s",("Yas")));
                    p1score.setText(String.format(Locale.getDefault(),"%s",Integer.valueOf(odds.get(0))));
                    p2score.setText(String.format(Locale.getDefault(),"%s",Integer.valueOf(odds.get(1))));
                    if(odds.get(2)== null){
                        p3score.setText(String.format(Locale.getDefault(),"%s",(" ")));
                    }else {
                        p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                    }
                }
                else{
                    textic.setText(String.format(Locale.getDefault(),"%s",("Nono")));
                    p1score.setText(String.format(Locale.getDefault(),"%s",Integer.valueOf(odds.get(0))));
                    p2score.setText(String.format(Locale.getDefault(),"%s",Integer.valueOf(odds.get(1))));
                    if(odds.get(2)== null){
                        p3score.setText(String.format(Locale.getDefault(),"%s",(" ")));
                    }else {
                        p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                    }
                }
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


