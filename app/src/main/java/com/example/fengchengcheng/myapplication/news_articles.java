package com.example.fengchengcheng.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

public class news_articles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_articles);
        /*Intent intent=getIntent();
        String message =intent.getStringExtra(MyActivity.EXTRA__MY_MESSAGE);
        TextView textview = new TextView(this);
        textview.setTextSize(40);
        textview.setText(message);
        FrameLayout framelayout = (FrameLayout)this.findViewById(R.id.fragment_content);
        framelayout.addView(textview);*/
    }
}
