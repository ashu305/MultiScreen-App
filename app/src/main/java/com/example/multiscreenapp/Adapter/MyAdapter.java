package com.example.multiscreenapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.multiscreenapp.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Words> {

    private int backgroundColorId;
    public MyAdapter(@NonNull Context context, @NonNull ArrayList<Words> objects, int color) {
        super(context, 0, objects);
        backgroundColorId = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.words_list, parent, false);
        }

        ConstraintLayout parrent = listItemView.findViewById(R.id.parrentView);
        Words currentWord = getItem(position);
        TextView EngWord = listItemView.findViewById(R.id.EngWord);
        TextView MiworkWord = listItemView.findViewById(R.id.miworkWord);

        EngWord.setText(currentWord.getEngWord().toString());
        MiworkWord.setText(currentWord.getMiworkWord().toString());
        ImageView imageView = listItemView.findViewById(R.id.imgValues);
        if(!currentWord.isPhraseActivity()) {
            imageView.setImageResource(currentWord.getImageid());
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        int color = ContextCompat.getColor(getContext(), backgroundColorId);
        parrent.setBackgroundColor(color);




        return listItemView;
    }

}
