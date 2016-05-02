package com.example.sushant.customfragmentstatepageradapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sushant on 2/5/16.
 */

public class QFragment extends Fragment {

    public QFragment() {

    }

    public static QFragment newInstance(String question_label, String question) {
        QFragment fragment = new QFragment();
        Bundle args = new Bundle();
        args.putString("question_label", question_label);
        args.putString("question", question);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        Bundle args = getArguments();

        // Background color always comes from arguments.
        //rootView.setBackgroundColor(args.getInt("color"));

        // If we have a saved state, we pull our label from that. Otherwise it comes from args.
        TextView label = (TextView)rootView.findViewById(R.id.text_label);
        if (savedInstanceState == null) {
            label.setText(args.getString("question_label"));
        } else {
            label.setText(savedInstanceState.getString("savedStateLabel"));
        }

        // And our "arguments label" shows what this fragment *should* be showing.
        TextView argsLabel = (TextView)rootView.findViewById(R.id.args_label);
        argsLabel.setText(getResources().getString(R.string.should_be_showing, args.getString("question_label")));

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedStateLabel", getArguments().getString("question_label"));
    }
}

