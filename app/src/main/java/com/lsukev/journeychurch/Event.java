package com.lsukev.journeychurch;

/**
 * Created by lsuke on 9/15/2016.
 */
public class Event {
    String month;

    String dayNumber;
    String title;
    String location;
    String time;

    Event(String month, String dayNumber, String title, String location, String time){
        this.month = month;

        this.dayNumber = dayNumber;
        this.title = title;
        this.location = location;
        this.time = time;
    }

    public String getMonth() {
        return month;
    }
}
