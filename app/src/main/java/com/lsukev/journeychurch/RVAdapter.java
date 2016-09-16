package com.lsukev.journeychurch;

import android.app.Activity;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by lsuke on 9/15/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder>{


    public static class EventViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView lblMonth;
        TextView lblDayNumber;
        TextView lblTitle;
        TextView lblLocation;
        TextView lblTime;
        Button saveButton;

        public String month;
        public String dayNumber;
        public String title;
        public String location;
        public String time;

        EventViewHolder(final View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            lblMonth = (TextView) itemView.findViewById(R.id.lblMonth);
            saveButton = (Button) itemView.findViewById(R.id.saveButton);
            lblDayNumber = (TextView) itemView.findViewById(R.id.lblDayNumber);
            lblTitle = (TextView) itemView.findViewById(R.id.lblTitle);
            lblLocation = (TextView) itemView.findViewById(R.id.lblLocation);
            lblTime = (TextView) itemView.findViewById(R.id.lblTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), month, Toast.LENGTH_SHORT).show();
                }
            });
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType("vnd.android.cursor.item/event");

                    Calendar cal = Calendar.getInstance();
                    long startTime = cal.getTimeInMillis();
                    long endTime = cal.getTimeInMillis()  + 60 * 60 * 1000;
                    GregorianCalendar calDate = new GregorianCalendar(2016, 11, 21, 21, 30);
                    GregorianCalendar calEndDate = new GregorianCalendar(2016, 11, 21, 22, 00);

                    intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calDate.getTimeInMillis());
                    intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,calEndDate.getTimeInMillis());
//                    intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

                    intent.putExtra(CalendarContract.Events.TITLE, title);
                    intent.putExtra(CalendarContract.Events.DESCRIPTION,  "This is a sample description");
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location);

                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    List<Event> events;

    RVAdapter(List<Event> events){
        this.events = events;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_item, viewGroup, false);
        EventViewHolder evh = new EventViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder eventViewHolder, int i) {
        eventViewHolder.lblMonth.setText(events.get(i).month);
        eventViewHolder.month = events.get(i).month;

        eventViewHolder.lblDayNumber.setText(events.get(i).dayNumber);
        eventViewHolder.dayNumber = events.get(i).dayNumber;

        eventViewHolder.lblTitle.setText(events.get(i).title);
        eventViewHolder.title = events.get(i).title;

        eventViewHolder.lblLocation.setText(events.get(i).location);
        eventViewHolder.location = events.get(i).location;

        eventViewHolder.lblTime.setText(events.get(i).time);
        eventViewHolder.time = events.get(i).time;
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
