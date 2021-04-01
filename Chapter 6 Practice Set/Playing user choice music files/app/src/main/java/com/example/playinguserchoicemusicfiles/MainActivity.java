package com.example.playinguserchoicemusicfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaplayer,mediaplayer2,mediaplayer3;
    private Button playPause;
    private Button music1;
    private Button music2;
    private Button music3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaplayer=MediaPlayer.create(this,R.raw.sample1);
        mediaplayer2=MediaPlayer.create(this,R.raw.sample2);
        mediaplayer3=MediaPlayer.create(this,R.raw.sample3);
        playPause=findViewById(R.id.playPause);
        music1=findViewById(R.id.button2);
        music2=findViewById(R.id.button3);
        music3=findViewById(R.id.button4);

        playPause.setText("Play");

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaplayer.isPlaying()&&!mediaplayer2.isPlaying()&&!mediaplayer3.isPlaying()){
                    //Toast.makeText(MainActivity.this, "First select a music to play it!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        music1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaplayer2.isPlaying()) {
                    mediaplayer2.pause();
                }
                if(mediaplayer3.isPlaying()) {
                    mediaplayer3.pause();
                }

                mediaplayer.setLooping(true);
                if(mediaplayer.isPlaying()){
                    playPause.setText("Pause");
                }
                else {
                    playPause.setText("Play");
                }

                playPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mediaplayer.isPlaying()) {
                            mediaplayer.pause();
                            playPause.setText("Play");
                        }
                        else{
                            mediaplayer.start();
                            playPause.setText("Pause");
                        }
                    }
                });
            }
        });


        music2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaplayer.isPlaying()) {
                    mediaplayer.pause();
                }
                if(mediaplayer3.isPlaying()) {
                    mediaplayer3.pause();
                }

                mediaplayer2.setLooping(true);
                if(mediaplayer2.isPlaying()){
                    playPause.setText("Pause");
                }
                else {
                    playPause.setText("Play");
                }

                playPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mediaplayer2.isPlaying()) {
                            mediaplayer2.pause();
                            playPause.setText("Play");
                        }
                        else{
                            mediaplayer2.start();
                            playPause.setText("Pause");
                        }
                    }
                });
            }
        });


        music3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaplayer2.isPlaying()) {
                    mediaplayer2.pause();
                }
                if(mediaplayer.isPlaying()) {
                    mediaplayer.pause();
                }

                mediaplayer3.setLooping(true);
                if(mediaplayer3.isPlaying()){
                    playPause.setText("Pause");
                }
                else {
                    playPause.setText("Play");
                }

                playPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mediaplayer3.isPlaying()) {
                            mediaplayer3.pause();
                            playPause.setText("Play");
                        }
                        else{
                            mediaplayer3.start();
                            playPause.setText("Pause");
                        }
                    }
                });
            }
        });
    }
}