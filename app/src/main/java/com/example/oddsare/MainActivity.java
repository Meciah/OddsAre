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
import android.text.InputFilter;
import android.view.View;
import android.view.Window;
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
        getSupportActionBar().setDisplayShowTitleEnabled(false);



            final AlertDialog.Builder p5builder = new AlertDialog.Builder(this, R.style.AlertDialog);
            LinearLayout layout6 = new LinearLayout(this);
            layout6.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params6 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params6.setMargins(300, 20, 300, 0);

            p5editText = new EditText(this);
            p5builder.setView(layout6);
            p5editText.setWidth(240);
            p5editText.setTextColor(getResources().getColor(android.R.color.white));
            p5editText.setFilters(new InputFilter[]{new InputFilterMinMax("1", "100")});

            layout6.addView(p5editText, params6);
            p5builder.setTitle("Player 5");
            p5builder.setCancelable(false);
            p5builder.setIcon(R.drawable.oa);
            p5builder.setMessage("Enter a Number");

            p5builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    odds.add(Integer.valueOf(p5editText.getText().toString()));
                    dialog.dismiss();
                }
            });

            final AlertDialog.Builder p4builder = new AlertDialog.Builder(this, R.style.AlertDialog);
            LinearLayout layout5 = new LinearLayout(this);
            layout5.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params5 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params5.setMargins(300, 20, 300, 0);

            p4editText = new EditText(this);
            p4builder.setView(layout5);
            p4editText.setWidth(240);
            p4editText.setTextColor(getResources().getColor(android.R.color.white));
            p4editText.setFilters(new InputFilter[]{new InputFilterMinMax("1", "100")});

            final AlertDialog p5 = p5builder.create();
            layout5.addView(p4editText, params5);
            p4builder.setTitle("Player 4");
            p4builder.setCancelable(false);
            p4builder.setIcon(R.drawable.oa);
            p4builder.setMessage("Enter a Number");

            p4builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    odds.add(Integer.valueOf(p4editText.getText().toString()));
                    if (plcount.get(0) < 6 && plcount.get(0) > 4) {
                        p5.getWindow().setBackgroundDrawableResource(android.R.color.background_dark);
                        p5.setCanceledOnTouchOutside(false);
                        p5.show();
                    }
                    dialog.dismiss();
                }
            });

            final AlertDialog.Builder p3builder = new AlertDialog.Builder(this, R.style.AlertDialog);
            LinearLayout layout4 = new LinearLayout(this);
            layout4.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params4.setMargins(300, 20, 300, 0);

            p3editText = new EditText(this);
            p3builder.setView(layout4);
            p3editText.setWidth(240);
            p3editText.setTextColor(getResources().getColor(android.R.color.white));
            p3editText.setFilters(new InputFilter[]{new InputFilterMinMax("1", "100")});

            final AlertDialog p4 = p4builder.create();
            layout4.addView(p3editText, params4);
            p3builder.setTitle("Player 3");
            p3builder.setCancelable(false);
            p3builder.setIcon(R.drawable.oa);
            p3builder.setMessage("Enter a Number");

            p3builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    odds.add(Integer.valueOf(p3editText.getText().toString()));
                    if (plcount.get(0) < 6 && plcount.get(0) > 3) {
                        p4.getWindow().setBackgroundDrawableResource(android.R.color.background_dark);
                        p4.setCanceledOnTouchOutside(false);
                        p4.show();
                    }
                    dialog.dismiss();
                }
            });

            final AlertDialog.Builder p2builder = new AlertDialog.Builder(this, R.style.AlertDialog);
            LinearLayout layout3 = new LinearLayout(this);
            layout3.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params3.setMargins(300, 20, 300, 0);

            p2editText = new EditText(this);
            layout3.addView(p2editText, params3);
            p2editText.setWidth(240);
            p2editText.setTextColor(getResources().getColor(android.R.color.white));
            p2editText.setFilters(new InputFilter[]{new InputFilterMinMax("1", "100")});

            final AlertDialog p3 = p3builder.create();
            p2builder.setView(layout3);
            p2builder.setTitle("Player 2");
            p2builder.setCancelable(false);
            p2builder.setIcon(R.drawable.oa);
            p2builder.setMessage("Enter a Number");

            p2builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    odds.add(Integer.valueOf(p2editText.getText().toString()));
                    if (plcount.get(0) < 6 && plcount.get(0) > 2) {
                        p3.getWindow().setBackgroundDrawableResource(android.R.color.background_dark);
                        p3.setCanceledOnTouchOutside(false);
                        p3.show();
                    }
                    dialog.dismiss();
                }
            });

            final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog);
            LinearLayout layout2 = new LinearLayout(this);
            layout2.setOrientation(LinearLayout.VERTICAL);
            //layout2.setBackgroundResource(android.R.color.background_dark);
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params2.setMargins(300, 20, 300, 0);

            p1editText = new EditText(this);
            layout2.addView(p1editText, params2);
            p1editText.setWidth(240);
            p1editText.setTextColor(getResources().getColor(android.R.color.white));
            p1editText.setFilters(new InputFilter[]{new InputFilterMinMax("1", "100")});

            final AlertDialog p2 = p2builder.create();
            builder.setView(layout2);
            builder.setTitle("Player 1");
            builder.setCancelable(false);
            builder.setIcon(R.drawable.oa);
            builder.setMessage("Enter a Number");

            builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    odds.add(Integer.valueOf(p1editText.getText().toString()));
                    p2.getWindow().setBackgroundDrawableResource(android.R.color.background_dark);
                    p2.setCanceledOnTouchOutside(false);
                    p2.show();
                    dialog.dismiss();
                }
            });




            final AlertDialog.Builder builderpc = new AlertDialog.Builder(this, R.style.AlertDialog);
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(300, 20, 300, 0);

            pcount = new EditText(this);
            layout.addView(pcount, params);
            pcount.setWidth(240);
            pcount.setTextColor(getResources().getColor(android.R.color.white));
            pcount.setFilters(new InputFilter[]{new InputFilterMinMax("2", "5")});

            final AlertDialog p1 = builder.create();
            builderpc.setView(layout);
            builderpc.setTitle("Number of Players");
            builderpc.setCancelable(false);
            builderpc.setIcon(R.drawable.oa);
            builderpc.setMessage("Player Limit 2-5");
            builderpc.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    plcount.add(Integer.valueOf(pcount.getText().toString()));
                    p1.getWindow().setBackgroundDrawableResource(android.R.color.background_dark);
                    p1.setCanceledOnTouchOutside(false);
                    p1.show();
                    dialog.dismiss();
                }
            });

        Button sbutton = findViewById(R.id.startbtn);
        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog pc = builderpc.create();
                pc.getWindow().setBackgroundDrawableResource(android.R.color.background_dark);
                pc.setCanceledOnTouchOutside(false);
                pc.show();
            }
        });





        Button pbutton = findViewById(R.id.playbtn);
        pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v);
            }
        });



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


