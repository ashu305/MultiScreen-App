package com.example.multiscreenapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.multiscreenapp.Adapter.MyAdapter;
import com.example.multiscreenapp.Adapter.Words;
import com.example.multiscreenapp.R;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private final ArrayList<Words> colours = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);


        initData();
        MyAdapter adapter = new MyAdapter(this, colours, R.color.category_colors);
        ListView listView = findViewById(R.id.list_colors);
        listView.setAdapter(adapter);

        PlayAudio(listView);
    }

    private void PlayAudio(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Words word = colours.get(i);
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    }
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void initData() {
        colours.add(new Words("red", "weṭeṭṭi", R.mipmap.color_red, R.raw.color_red));
        colours.add(new Words("green", "chokokki", R.mipmap.color_green, R.raw.color_green));
        colours.add(new Words("brown", "ṭakaakki", R.mipmap.color_brown, R.raw.color_brown));
        colours.add(new Words("gray", "ṭopoppi", R.mipmap.color_gray, R.raw.color_gray));
        colours.add(new Words("black", "kululli", R.mipmap.color_black, R.raw.color_black));
        colours.add(new Words("white", "kelelli", R.mipmap.color_white, R.raw.color_white));
        colours.add(new Words("dusty yellow", "ṭopiisә", R.mipmap.color_dusty_yellow, R.raw.color_dusty_yellow));
        colours.add(new Words("mustard yellow", "chiwiiṭә", R.mipmap.color_mustard_yellow, R.raw.color_mustard_yellow));

    }
}