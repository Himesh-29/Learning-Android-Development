package com.example.playingtwovideossimulataneously;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaplayer;
    private MediaPlayer mediaplayer2;
    private SurfaceView surfaceView;
    private SurfaceView surfaceView2;
    private Button button;
    private Button button2;
    private Handler mHandler = new Handler();
    private Handler mHandler2 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        surfaceView=findViewById(R.id.surfaceView);
        surfaceView2=findViewById(R.id.surfaceView2);

        mediaplayer=MediaPlayer.create(this,R.raw.vid1);
        mediaplayer2=MediaPlayer.create(this,R.raw.vid2);

        surfaceView.setKeepScreenOn(true);//To keep the screen turned on till the video is playing
        surfaceView2.setKeepScreenOn(true);

        SurfaceHolder surfaceholder=surfaceView.getHolder();
        SurfaceHolder surfaceholder2=surfaceView2.getHolder();

        surfaceholder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaplayer.setDisplay(surfaceholder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });

        surfaceholder2.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaplayer2.setDisplay(surfaceholder2);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {      }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) { }
        });

        mediaplayer.setLooping(true);
        button.setText("Play");

        mediaplayer2.setLooping(true);
        button2.setText("Play");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer.isPlaying()) {
                    if(mediaplayer2.isPlaying()){
                        mediaplayer2.pause();
                        button2.setText("Play");}
                    mediaplayer.pause();
                    button.setText("Play");
                }
                else{
                    if(mediaplayer2.isPlaying()){
                        mediaplayer2.pause();
                        button2.setText("Play");}
                    mediaplayer.start();
                    button.setText("Pause");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer2.isPlaying()) {
                    if(mediaplayer.isPlaying()){
                        mediaplayer.pause();
                        button.setText("Play");}
                    mediaplayer2.pause();
                    button2.setText("Play");
                }
                else{
                    if(mediaplayer.isPlaying()){
                        mediaplayer.pause();
                        button.setText("Play");}
                    mediaplayer2.start();
                    button2.setText("Pause");
                }
            }
        });

    }
}