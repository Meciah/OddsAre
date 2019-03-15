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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    boolean showFirst = true;
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
                //ArrayList<Integer> result = new ArrayList<>(set);
            }
        });


    }


    private void showToast(String text){
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }



    public void ShowPopup(View v) {
        final HashSet<Integer> set = new HashSet<Integer>(odds);
        long countDown = 3000;
        long interval = 1000;
        final CountDownTimer countDownTimer;
        final TextView textic;
        TextView txtclose;
        final Button btnPlay;
        final TextView p1score;
        final TextView p2score;
        final TextView p3score;
        final TextView p4score;
        final TextView p5score;
        final TextView p6score;
        final LinearLayout p3layout;
        final LinearLayout p4layout;
        final LinearLayout p5layout;
        final LinearLayout p6layout;
        myDialog.setContentView(R.layout.playpopup);
        p3layout = (LinearLayout) myDialog.findViewById(R.id.p3layout);
        p4layout = (LinearLayout) myDialog.findViewById(R.id.p4layout);
        p5layout = (LinearLayout) myDialog.findViewById(R.id.p5layout);
        p6layout = (LinearLayout) myDialog.findViewById(R.id.p6layout);
        p1score = (TextView) myDialog.findViewById(R.id.p1sc);
        p2score = (TextView) myDialog.findViewById(R.id.p2sc);
        p3score = (TextView) myDialog.findViewById(R.id.p3sc);
        p4score = (TextView) myDialog.findViewById(R.id.p4sc);
        p5score = (TextView) myDialog.findViewById(R.id.p5sc);
        p6score = (TextView) myDialog.findViewById(R.id.p6sc);
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

        if(plcount.get(0) < 3){
            p3layout.setVisibility(View.GONE);
            p4layout.setVisibility(View.GONE);
            p5layout.setVisibility(View.GONE);
            p6layout.setVisibility(View.GONE);
        }else if (plcount.get(0) < 4) {
            p4layout.setVisibility(View.GONE);
            p5layout.setVisibility(View.GONE);
            p6layout.setVisibility(View.GONE);
        }
        else if (plcount.get(0) < 5) {
            p5layout.setVisibility(View.GONE);
            p6layout.setVisibility(View.GONE);
        }
        else if (plcount.get(0) < 6) {
            p6layout.setVisibility(View.GONE);
        } else {
            return;
        }


        countDownTimer = new CountDownTimer(countDown, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                textic.setText(String.format(Locale.getDefault(),"%s", Long.toString(millisUntilFinished/1000)));
            }

            @Override
            public void onFinish() {
                        if (set.size() < odds.size()) {
                            textic.setText(String.format(Locale.getDefault(), "%s", ("Yas")));
                            p1score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(0))));
                            p2score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(1))));
                            if (plcount.get(0) < 4 && plcount.get(0) > 2) {
                                p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                            } else if (plcount.get(0) < 5 && plcount.get(0) > 3) {
                                p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                                p4score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(3))));
                            } else if (plcount.get(0) < 6 && plcount.get(0) > 4) {
                                p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                                p4score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(3))));
                                p5score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(4))));
                            } else if (plcount.get(0) < 7 && plcount.get(0) > 5) {
                                p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                                p4score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(3))));
                                p5score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(4))));
                                p6score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(5))));
                            }
                        }
                            else {
                                textic.setText(String.format(Locale.getDefault(), "%s", ("Nono")));
                                p1score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(0))));
                                p2score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(1))));
                                if (plcount.get(0) < 4 && plcount.get(0) > 2) {
                                    p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                                } else if (plcount.get(0) < 5 && plcount.get(0) > 3) {
                                    p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                                    p4score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(3))));
                                } else if (plcount.get(0) < 6 && plcount.get(0) > 4) {
                                    p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                                    p4score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(3))));
                                    p5score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(4))));
                                } else if (plcount.get(0) < 7 && plcount.get(0) > 5) {
                                    p3score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(2))));
                                    p4score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(3))));
                                    p5score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(4))));
                                    p6score.setText(String.format(Locale.getDefault(), "%s", Integer.valueOf(odds.get(5))));
                                }

                }

                btnPlay.setText(String.format(Locale.getDefault(),"%s",("Reset")));
            }
        };

        textic.setText(String.format(Locale.getDefault(),"%s",Long.toString(countDown/1000)));
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showFirst == true){
                    countDownTimer.start();
                    showFirst = false;
                }else {
                    myDialog.dismiss();
                    recreate();
                    showFirst = true;
                }

            }
        });
        myDialog.show();
    }





}


