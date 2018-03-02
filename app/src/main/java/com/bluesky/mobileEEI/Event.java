package com.bluesky.mobileEEI;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Robert on 2/15/2018.
 */

public class Event implements Serializable
{
    private String type;
    private Date startTime;
    private Date endTime;
//    private Date date;
    private int[] values;
    private String units;

    public Event(String type, Time startTime, Time endTime, Date date,
                 int[] values, String units)
    {
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
//        this.date = date;
        this.values = values;
        this.units = units;
    }

    public Event() {

    }

    @Override
    public String toString() {
        return "\nEvent: type = " + type + ", startTime = " + startTime + ", endTime = " + endTime +
                ", values = " + java.util.Arrays.toString(values) + ", units = " + units;
    }
}
