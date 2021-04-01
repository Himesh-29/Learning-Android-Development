package com.example.playingasonginloop;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaplayer;
    private Button button;
    private SeekBar seekBar;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaplayer=MediaPlayer.create(this,R.raw.sample);
        button=findViewById(R.id.button);
        seekBar=findViewById(R.id.seekBar);

        seekBar.setMax(mediaplayer.getDuration()/1000);

        MainActivity.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if(mediaplayer != null){
                    int mCurrentPosition = mediaplayer.getCurrentPosition() / 1000;
                    seekBar.setProgress(mCurrentPosition);
                }
                mHandler.postDelayed(this, 1000);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mediaplayer != null && fromUser){
                    mediaplayer.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }
        });

        mediaplayer.setLooping(true);
        button.setText("Play");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer.isPlaying()) {
                    mediaplayer.pause();
                    button.setText("Play");
                }
                else{
                    mediaplayer.start();
                    button.setText("Pause");
                }
            }
        });
    }
}