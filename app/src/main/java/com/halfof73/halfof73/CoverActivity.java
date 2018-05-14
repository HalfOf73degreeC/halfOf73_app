package com.halfof73.halfof73;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        Runnable rab = new Runnable() {
            @Override
            public void run() {
                finish();
                overridePendingTransition(R.anim.push_in,R.anim.push_out);

            }
        };
        new Handler().postDelayed(rab,5000);
    }

    @Override
    public void onBackPressed() {

    }
}
