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

public class PhrasesActivity extends AppCompatActivity {

    private final ArrayList<Words> phrases = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);


        initData();
        MyAdapter adapter = new MyAdapter(this, phrases, R.color.category_phrases);
        ListView listView = findViewById(R.id.list_phrases);
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
                Words word = phrases.get(i);
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
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
        phrases.add(new Words("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        phrases.add(new Words("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrases.add(new Words("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        phrases.add(new Words("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Words("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        phrases.add(new Words("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrases.add(new Words("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrases.add(new Words("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        phrases.add(new Words("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        phrases.add(new Words("Come here.", "әnni'nem", R.raw.phrase_come_here));


    }
}