package com.example.multiscreenapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.multiscreenapp.Adapter.MyAdapter;
import com.example.multiscreenapp.Adapter.Words;
import com.example.multiscreenapp.R;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private final ArrayList<Words> words = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        initData();

        MyAdapter adapter = new MyAdapter(this, words, R.color.category_numbers);

        ListView listView = findViewById(R.id.parent);
        listView.setAdapter(adapter);


        PlayAudio(listView);

    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();

    }

    private void PlayAudio(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Words word = words.get(i);
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
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
        words.add(new Words("One", "lutti", R.mipmap.number_one, R.raw.number_one));
        words.add(new Words("Two", "otiiko", R.mipmap.number_two, R.raw.number_two));
        words.add(new Words("Three", "tolookosu", R.mipmap.number_three, R.raw.number_three));
        words.add(new Words("Four", "oyyisa", R.mipmap.number_four, R.raw.number_four));
        words.add(new Words("Five", "massokka", R.mipmap.number_five, R.raw.number_five));
        words.add(new Words("Six", "temmokka", R.mipmap.number_six, R.raw.number_six));
        words.add(new Words("Seven", "kenekaku", R.mipmap.number_seven, R.raw.number_seven));
        words.add(new Words("Eight", "kawinta", R.mipmap.number_eight, R.raw.number_eight));
        words.add(new Words("Nine", "wo’e", R.mipmap.number_nine, R.raw.number_nine));
        words.add(new Words("Ten", "na’aacha", R.mipmap.number_ten, R.raw.number_ten));
    }
}