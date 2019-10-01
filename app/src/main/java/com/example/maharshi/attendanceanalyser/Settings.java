package com.example.maharshi.attendanceanalyser;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Settings extends Fragment{
    private Button viewall;
    private TextView display;
    Context context;
    DatabaseHelper mydb = new DatabaseHelper(context);



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        viewall = (Button)view.findViewById(R.id.btnviewall);
        display = (TextView)view.findViewById(R.id.tvviewall);
        display.setText("Hello");



        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = mydb.getAllData();
                if (res.getCount() == 0) {

                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID" + res.getString(0));
                    buffer.append("pre" + res.getString(1));
                    buffer.append("total" + res.getString(2));
                    buffer.append("tar" + res.getString(3));
                    buffer.append("name" + res.getString(4));
                    display.setText("hi"+buffer);
                }


            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}

