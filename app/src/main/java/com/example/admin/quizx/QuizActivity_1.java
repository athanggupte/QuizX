package com.example.admin.quizx;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity_1 extends AppCompatActivity implements View.OnClickListener{

    Button opt1, opt2, opt3, opt4;
    TextView Question;
    public static int Q_no = 1, progress = 0;
    int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBarCustom = (ProgressBar) findViewById(R.id.progressBar);
        progressBarCustom.setProgress(progress*100/5);

        Question = (TextView) findViewById(R.id.question_view);
        opt1 = (Button) findViewById(R.id.opt_1);
        opt2 = (Button) findViewById(R.id.opt_2);
        opt3 = (Button) findViewById(R.id.opt_3);
        opt4 = (Button) findViewById(R.id.opt_4);

        final Animation button_animation = AnimationUtils.loadAnimation(this, R.anim.button_anim);

        opt1.setVisibility(View.INVISIBLE);
        opt2.setVisibility(View.INVISIBLE);
        opt3.setVisibility(View.INVISIBLE);
        opt4.setVisibility(View.INVISIBLE);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);

        Delay.delay(500, new Delay.DelayCallback() {
            @Override
            public void afterDelay() {
                opt1.setVisibility(View.VISIBLE);
                opt1.startAnimation(button_animation);
                opt2.setVisibility(View.VISIBLE);
                opt2.startAnimation(button_animation);
                opt3.setVisibility(View.VISIBLE);
                opt3.startAnimation(button_animation);
                opt4.setVisibility(View.VISIBLE);
                opt4.startAnimation(button_animation);
            }
        });

        if (Q_no >= 6){
            Bundle progreess_bundle = new Bundle();
            progreess_bundle.putString("Progress", Integer.toString(progress));
            Intent get_result = new Intent(this, ResultActivity.class);
            get_result.putExtras(progreess_bundle);
            startActivity(get_result);
            finish();
        }

        set_text();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.opt_1:
                choice = 1;
                break;
            case R.id.opt_2:
                choice = 2;
                break;
            case R.id.opt_3:
                choice = 3;
                break;
            case R.id.opt_4:
                choice = 4;
                break;
        }
        Check_ans(choice);
    }

    public void Check_ans(int choice){
        switch (Q_no){

            case 1:
                if (choice == 2){
                    Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
                    progress++;
                }
                else {
                    Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                if (choice == 1){
                    Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
                    progress++;
                }
                else {
                    Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                if (choice == 3){
                    Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
                    progress++;
                }
                else {
                    Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                }
                break;
            case 4:
                if (choice == 2){
                    Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
                    progress++;
                }
                else {
                    Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                }
                break;
            case 5:
                if (choice == 1){
                    Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
                    progress++;
                }
                else {
                    Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                }
                break;
            default:

        }
        Q_no ++;
        Intent intent = new Intent(this, QuizActivity_1.class);
        startActivity(intent);
        finish();
    }

    public void set_text(){
            Question.setText("Question" +  Integer.toString(Q_no));
    }

}
