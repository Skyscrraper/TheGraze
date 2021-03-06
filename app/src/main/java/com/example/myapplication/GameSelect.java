package com.example.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.Abstract.ViewPatterns;

public class GameSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameselect);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);



        ViewPatterns.generateReturnButton((ImageButton) findViewById(R.id.gameselect_return), this);



        final ImageButton btn_singleplayer = (ImageButton) findViewById(R.id.gameselect_singleplayer);
        final ImageButton btn_multiplayer = (ImageButton) findViewById(R.id.gameselect_multiplayer);

        btn_singleplayer.setBackgroundResource(R.drawable.ic_singleplayer);
        btn_multiplayer.setBackgroundResource(R.drawable.ic_multiplayer);



        btn_singleplayer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        btn_singleplayer.setBackgroundResource(R.drawable.ic_singleplayerclicked);
                        break;
                    case MotionEvent.ACTION_UP:
                        btn_singleplayer.setBackgroundResource(R.drawable.ic_singleplayer);
                        break;
                }
                return true;
            }
        });

        btn_multiplayer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        btn_multiplayer.setBackgroundResource(R.drawable.ic_multiplayerclicked);
                        break;
                    case MotionEvent.ACTION_UP:
                        btn_multiplayer.setBackgroundResource(R.drawable.ic_multiplayer);
                        Intent gs_to_sgft = new Intent(getBaseContext(), SetGameFieldType.class);
                        gs_to_sgft.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(gs_to_sgft);
                        break;
                }
                return true;
            }
        });



    }

}
