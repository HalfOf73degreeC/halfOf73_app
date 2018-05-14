package com.halfof73.halfof73.phone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.halfof73.halfof73.R;

public class ResultFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reslt, container,false);
        Bundle bundle = getArguments();

        final Phone phone = (Phone)bundle.getSerializable("phone");

        ImageView imageView = view.findViewById(R.id.iv_pic);
        imageView.setImageResource(phone.getImageId());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(phone.getImageId());
                Toast toast = new Toast(getActivity());
                toast.setView(imageView);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        TextView tvName = view.findViewById(R.id.tv_name);
        tvName.setText(phone.getName());
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),phone.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        TextView tvMS = view.findViewById(R.id.tv_ms);
        tvMS.setText(phone.getMs());
        tvMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),phone.getMs(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
