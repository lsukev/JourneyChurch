package com.lsukev.journeychurch.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lsukev.journeychurch.R;

import org.w3c.dom.Text;

public class OurStaffFragment extends Fragment implements View.OnClickListener {

    private ImageView colemanImage;
    private ImageView sullivanImage;
    private ImageView quintiniImage;
    private TextView lblBio;
    View view;
    public OurStaffFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_our_staff, container, false);

        colemanImage = (ImageView)view.findViewById(R.id.colemanImage);
        sullivanImage = (ImageView)view.findViewById(R.id.sullivanImage);
        quintiniImage = (ImageView) view.findViewById(R.id.quintiniImage);

        lblBio = (TextView)view.findViewById(R.id.lblBio);

        colemanImage.setOnClickListener(this);
        sullivanImage.setOnClickListener(this);
        quintiniImage.setOnClickListener(this);
        return view;
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.colemanImage:
                lblBio.setVisibility(View.VISIBLE);
                lblBio.setText(R.string.coleman_bio);
                break;
            case R.id.sullivanImage:
                lblBio.setVisibility(View.VISIBLE);
                lblBio.setText(R.string.sullivan_bio);
                break;
            case R.id.quintiniImage:
                lblBio.setVisibility(View.VISIBLE);
                lblBio.setText(R.string.quintini_bio);
                break;
        }
    }
}
