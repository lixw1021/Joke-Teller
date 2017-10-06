package com.xianwei.jokedisplay;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JokeFragment extends Fragment {


    public JokeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);
        Intent intent = getActivity().getIntent();
        if (intent.hasExtra(JokeActivity.JOKE_KEY)) {
            String joke = intent.getStringExtra(JokeActivity.JOKE_KEY);
            TextView textView = (TextView) rootView.findViewById(R.id.tv_joke_display);
            if (!TextUtils.isEmpty(joke)) {
                textView.setText(joke);
            }
        }
        return rootView;
    }
}
