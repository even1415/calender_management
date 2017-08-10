package com.sauce.mytablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Junyoung on 2016-06-23.
 */

public class Tab_Alarm extends Fragment {
    View view;
    FloatingActionButton addbtnalm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_alarm, container, false);
        addbtnalm = (FloatingActionButton) view.findViewById(R.id.addbtnalm);


        addbtnalm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Insert_Schedule.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
