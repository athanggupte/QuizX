package com.example.admin.quizx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity{

    ImageView star_left, star_center, star_right;
    ImageView home_image;
    TextView score;
    Button home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String progress_string = getIntent().getExtras().getString("Progress");
        int progress = Integer.parseInt(progress_string);

        score = (TextView) findViewById(R.id.score_view);
        star_left = (ImageView) findViewById(R.id.star_left);
        star_center = (ImageView) findViewById(R.id.star_center);
        star_right = (ImageView) findViewById(R.id.star_right);
        home_button = (Button) findViewById(R.id.home_button);
        home_image = (ImageView) findViewById(R.id.home_image);

        score.setText(progress_string);
        star_left.setVisibility(View.INVISIBLE);
        star_center.setVisibility(View.INVISIBLE);
        star_right.setVisibility(View.INVISIBLE);
        home_image.setVisibility(View.INVISIBLE);

        final Animation star_animation = AnimationUtils.loadAnimation(this, R.anim.stars_anim);
        final Animation menu_animation = AnimationUtils.loadAnimation(this, R.anim.menu_buttons_anim);

  /*      Delay.delay(500, new Delay.DelayCallback() {
            @Override
            public void afterDelay() {
                star_center.startAnimation(star_animation);
                star_center.setVisibility(View.VISIBLE);
                star_right.startAnimation(star_animation);
                star_right.setVisibility(View.VISIBLE);
                star_left.startAnimation(star_animation);
                star_left.setVisibility(View.VISIBLE);
            }
        });
*/
        if ((progress*100/5) >= 80){
            Delay.delay(500, new Delay.DelayCallback() {
                @Override
                public void afterDelay() {
                    star_center.startAnimation(star_animation);
                    star_center.setVisibility(View.VISIBLE);
                    star_right.startAnimation(star_animation);
                    star_right.setVisibility(View.VISIBLE);
                    star_left.startAnimation(star_animation);
                    star_left.setVisibility(View.VISIBLE);
                    Delay.delay(1000, new Delay.DelayCallback() {
                        @Override
                        public void afterDelay() {
                            home_image.startAnimation(menu_animation);
                            home_image.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });
        }
        else if (((progress*100/5) >= 60)&&((progress*100/5) < 80)){
            Delay.delay(500, new Delay.DelayCallback() {
                @Override
                public void afterDelay() {
                    star_right.startAnimation(star_animation);
                    star_right.setVisibility(View.VISIBLE);
                    star_left.startAnimation(star_animation);
                    star_left.setVisibility(View.VISIBLE);
                    Delay.delay(1000, new Delay.DelayCallback() {
                        @Override
                        public void afterDelay() {
                            home_image.startAnimation(menu_animation);
                            home_image.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });
        }
        else if (((progress*100/5) >= 40)&&((progress*100/5) < 60)){
            Delay.delay(500, new Delay.DelayCallback() {
                @Override
                public void afterDelay() {
                    star_center.startAnimation(star_animation);
                    star_center.setVisibility(View.VISIBLE);
                    Delay.delay(1000, new Delay.DelayCallback() {
                        @Override
                        public void afterDelay() {
                            home_image.startAnimation(menu_animation);
                            home_image.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });
        }

    }
}
