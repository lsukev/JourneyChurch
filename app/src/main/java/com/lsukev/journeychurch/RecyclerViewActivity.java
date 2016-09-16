package com.lsukev.journeychurch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends BaseActivity {

    private List<Event> events;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rv = (RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        events = new ArrayList<>();
        events.add(new Event("Aug","22","Grow Class","Journey Church", "9:00 am - 12:00 pm"));
        events.add(new Event("Sep", "26","Serve Class", "Journey Church", "5:00 pm - 7:00 pm"));


    }
    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(events);
        rv.setAdapter(adapter);
    }
}
