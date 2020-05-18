package com.cxyzy.viewpager.showneighbour;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public final class FlipFragment extends Fragment {

    private ViewGroup card;
    private String mContent = "";

    public static FlipFragment newInstance(String content) {
        FlipFragment fragment = new FlipFragment();
        fragment.mContent = content;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_flip,
                container, false);
        int bg = getRandomBgColor();

        card = rootView.findViewById(R.id.card);
        card.setBackgroundColor(bg);
        TextView title = rootView.findViewById(R.id.title);
        title.setText("" + mContent);
        title.setTextColor(Color.WHITE);
        return rootView;
    }

    private int getRandomBgColor() {
        return Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                    (int) Math.floor(Math.random() * 128) + 64,
                    (int) Math.floor(Math.random() * 128) + 64);
    }
}
