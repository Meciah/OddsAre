package com.example.oddsare;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
    Dialog myDialog;
    EditText pcount;
    EditText p1editText;
    EditText p2editText;
    EditText p3editText;
    EditText p4editText;
    EditText p5editText;
    ArrayList<Integer> plcount = new ArrayList<Integer>();
    ArrayList<Integer> odds = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);

        final AlertDialog.Builder p5builder = new AlertDialog.Builder(this);
        p5builder.setTitle("Player 5");
        p5builder.setIcon(R.drawable.ic_launcher_background);
        p5builder.setMessage("Enter a Number");

        p5editText = new EditText(this);
        p5builder.setView(p5editText);

        p5builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                odds.add(Integer.valueOf(p5editText.getText().toString()));
                dialog.dismiss();
            }
        });

        final AlertDialog.Builder p4builder = new AlertDialog.Builder(this);
        p4builder.setTitle("Player 4");
        p4builder.setIcon(R.drawable.ic_launcher_background);
        p4builder.setMessage("Enter a Number");

        p4editText = new EditText(this);
        p4builder.setView(p4editText);

        p4builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                odds.add(Integer.valueOf(p4editText.getText().toString()));
                if (plcount.get(0) < 6 && plcount.get(0) > 4) {
                    p5builder.create().show();
                }
                dialog.dismiss();
            }
        });

        final AlertDialog.Builder p3builder = new AlertDialog.Builder(this);
        p3builder.setTitle("Player 3");
        p3builder.setIcon(R.drawable.ic_launcher_background);
        p3builder.setMessage("Enter a Number");

        p3editText = new EditText(this);
        p3builder.setView(p3editText);

        p3builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                odds.add(Integer.valueOf(p3editText.getText().toString()));
                if (plcount.get(0) < 6 && plcount.get(0) > 3) {
                    p4builder.create().show();
                }
                dialog.dismiss();
            }
        });

        final AlertDialog.Builder p2builder = new AlertDialog.Builder(this);
        p2builder.setTitle("Player 2");
        p2builder.setIcon(R.drawable.ic_launcher_background);
        p2builder.setMessage("Enter a Number");

        p2editText = new EditText(this);
        p2builder.setView(p2editText);

        p2builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                odds.add(Integer.valueOf(p2editText.getText().toString()));
                if (plcount.get(0) < 6 && plcount.get(0) > 2) {
                    p3builder.create().show();
                }
                dialog.dismiss();
            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Player 1");
        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setMessage("Enter a Number");

        p1editText = new EditText(this);
        builder.setView(p1editText);
        p1editText.requestFocus();
        //p1editText.getFocusable();


        builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                odds.add(Integer.valueOf(p1editText.getText().toString()));
                p2builder.create().show();
                dialog.dismiss();
            }
        });


        AlertDialog.Builder builderpc = new AlertDialog.Builder(this);
        builderpc.setTitle("Number of Players");
        builderpc.setIcon(R.drawable.ic_launcher_background);
        builderpc.setMessage("2-5");
        pcount = new EditText(this);
        builderpc.setView(pcount);

        builderpc.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                plcount.add(Integer.valueOf(pcount.getText().toString()));
                builder.create().show();
                dialog.dismiss();
            }
        });




        AlertDialog pc = builderpc.create();
        pc.show();



        Button pbutton = findViewById(R.id.playbtn);
        pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v);
                //ArrayList<Integer> result = new ArrayList<>(set);
            }
        });


    }


    private void showToast(String text) {
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
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        btnPlay = (Button) myDialog.findViewById(R.id.btnplay);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                recreate();
            }
        });

        if (plcount.get(0) < 3) {
            p3layout.setVisibility(View.GONE);
            p4layout.setVisibility(View.GONE);
            p5layout.setVisibility(View.GONE);
            p6layout.setVisibility(View.GONE);
        } else if (plcount.get(0) < 4) {
            p4layout.setVisibility(View.GONE);
            p5layout.setVisibility(View.GONE);
            p6layout.setVisibility(View.GONE);
        } else if (plcount.get(0) < 5) {
            p5layout.setVisibility(View.GONE);
            p6layout.setVisibility(View.GONE);
        } else if (plcount.get(0) < 6) {
            p6layout.setVisibility(View.GONE);
        } else {
            return;
        }


        countDownTimer = new CountDownTimer(countDown, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                textic.setText(String.format(Locale.getDefault(), "%s", Long.toString(millisUntilFinished / 1000)));
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
                } else {
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

                btnPlay.setText(String.format(Locale.getDefault(), "%s", ("Reset")));
            }
        };

        textic.setText(String.format(Locale.getDefault(), "%s", Long.toString(countDown / 1000)));
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showFirst == true) {
                    countDownTimer.start();
                    showFirst = false;
                } else {
                    myDialog.dismiss();
                    recreate();
                    showFirst = true;
                }

            }
        });
        myDialog.show();
    }


}


