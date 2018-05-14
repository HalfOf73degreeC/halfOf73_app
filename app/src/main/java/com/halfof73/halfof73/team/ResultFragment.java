package com.halfof73.halfof73.team;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.halfof73.halfof73.R;

public class ResultFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        ImageView ivTeam = view.findViewById(R.id.ivTeam);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPrice = view.findViewById(R.id.tvPrice);
        TextView tvHistory = view.findViewById(R.id.tvHistory);
        Bundle bundle = getArguments();
        if(bundle != null){
            Team team = (Team) bundle.getSerializable("team");
            ivTeam.setImageResource(team.getImageId());
            tvName.setText(team.getName());
            tvPrice.setText(team.getPrice());
            tvHistory.setText(team.getHistory());
        }

        return view;
    }
}

