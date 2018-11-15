package com.example.admin.quizx;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import java.util.ArrayList;

public class Delay {

    public interface DelayCallback{
        void afterDelay();
    }

    public static void delay(int millis, final DelayCallback delayCallback){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                delayCallback.afterDelay();
            }
        }, millis);
    }
}
