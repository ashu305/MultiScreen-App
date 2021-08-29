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

public class FamilyActivity extends AppCompatActivity {

    private final ArrayList<Words> family = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


        initData();
        MyAdapter adapter = new MyAdapter(this, family, R.color.category_family);
        ListView listView = findViewById(R.id.list_family);
        listView.setAdapter(adapter);

        PlayAudio(listView);
    }

    private void PlayAudio(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Words word = family.get(i);
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
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
        family.add(new Words("father", "әpә", R.mipmap.family_father, R.raw.family_father));
        family.add(new Words("mother", "әṭa", R.mipmap.family_mother, R.raw.family_mother));
        family.add(new Words("son", "angsi", R.mipmap.family_son, R.raw.family_son));
        family.add(new Words("daughter", "tune", R.mipmap.family_daughter, R.raw.family_daughter));
        family.add(new Words("older brother", "taachi", R.mipmap.family_older_brother, R.raw.family_older_brother));
        family.add(new Words("younger brother", "chalitti", R.mipmap.family_younger_brother, R.raw.family_younger_brother));
        family.add(new Words("older sister", "teṭe", R.mipmap.family_older_sister, R.raw.family_older_sister));
        family.add(new Words("younger sister", "kolliti", R.mipmap.family_younger_sister, R.raw.family_younger_sister));
        family.add(new Words("grandmother", "ama", R.mipmap.family_grandmother, R.raw.family_grandmother));
        family.add(new Words("grandfather", "paapa", R.mipmap.family_grandfather, R.raw.family_grandfather));
    }
}