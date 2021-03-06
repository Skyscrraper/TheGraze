package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.myapplication.Abstract.ViewPatterns;
import com.example.myapplication.CustomObjects.IntSelector;

public class Help extends AppCompatActivity {



    static IntSelector helpPage = new IntSelector(1, 1, 3);



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        helpPage.setVal(1);

        ViewPatterns.generateReturnButton((ImageButton) findViewById(R.id.help_return), this);



        final ImageButton switcher_left = (ImageButton) findViewById(R.id.switcher_left);
        final ImageButton switcher_right = (ImageButton) findViewById(R.id.switcher_right);

        final ImageView switcher_page1_icon = (ImageView) findViewById(R.id.switcher_page1_icon);
        final ImageView switcher_page2_icon = (ImageView) findViewById(R.id.switcher_page2_icon);
        final ImageView switcher_page3_icon = (ImageView) findViewById(R.id.switcher_page3_icon);

        final ImageView help_txt = (ImageView) findViewById(R.id.help_text);

        updateSwitcherTextures(switcher_left, switcher_right, switcher_page1_icon, switcher_page2_icon, switcher_page3_icon);
        updateHelpPage(help_txt);



        switcher_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                helpPage.minus();
                updateSwitcherTextures(switcher_left, switcher_right, switcher_page1_icon, switcher_page2_icon, switcher_page3_icon);
                updateHelpPage(help_txt);
            }
        });

        switcher_right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                helpPage.plus();
                updateSwitcherTextures(switcher_left, switcher_right, switcher_page1_icon, switcher_page2_icon, switcher_page3_icon);
                updateHelpPage(help_txt);
            }
        });



    }

    private static void updateSwitcherTextures(ImageButton left, ImageButton right, ImageView p1, ImageView p2, ImageView p3) {
        switch (helpPage.getVal()) {
            case 1:
                left.setBackgroundResource(R.drawable.ic_help_switcher_left);
                right.setBackgroundResource(R.drawable.ic_help_switcher_rightactive);
                p1.setBackgroundResource(R.drawable.ic_help_switcher_page1active);
                p2.setBackgroundResource(R.drawable.ic_help_switcher_page2);
                p3.setBackgroundResource(R.drawable.ic_help_switcher_page3);
                break;
            case 2:
                left.setBackgroundResource(R.drawable.ic_help_switcher_leftactive);
                right.setBackgroundResource(R.drawable.ic_help_switcher_rightactive);
                p1.setBackgroundResource(R.drawable.ic_help_switcher_page1);
                p2.setBackgroundResource(R.drawable.ic_help_switcher_page2active);
                p3.setBackgroundResource(R.drawable.ic_help_switcher_page3);
                break;
            case 3:
                left.setBackgroundResource(R.drawable.ic_help_switcher_leftactive);
                right.setBackgroundResource(R.drawable.ic_help_switcher_right);
                p1.setBackgroundResource(R.drawable.ic_help_switcher_page1);
                p2.setBackgroundResource(R.drawable.ic_help_switcher_page2);
                p3.setBackgroundResource(R.drawable.ic_help_switcher_page3active);
                break;
        }
    }

    private static void updateHelpPage(ImageView txt) {
        switch (helpPage.getVal()) {
            case 1:
                txt.setBackgroundResource(R.drawable.ic_help_page1_text);
                break;
            case 2:
                txt.setBackgroundResource(R.drawable.ic_help_page2_text);
                break;
            case 3:
                txt.setBackgroundResource(R.drawable.ic_help_page3_text);
                break;
        }
    }

}
