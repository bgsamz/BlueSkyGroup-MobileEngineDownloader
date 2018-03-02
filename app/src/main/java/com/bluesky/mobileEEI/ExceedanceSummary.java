package com.bluesky.mobileEEI;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Robert on 2/15/2018.
 */

public class ExceedanceSummary implements Serializable
{
    private String excID;
    private Date date;
//    private Time time;
    private float peak;
    private int duration;
    private int mc;

    public ExceedanceSummary(String excID, Date date, Time time, float peak,
                             int duration, int mc)
    {
        this.excID = excID;
        this.date = date;
//        this.time = time;
        this.peak = peak;
        this.duration = duration;
        this.mc = mc;
    }

    public ExceedanceSummary() {

    }

    @Override
    public String toString() {
        return "\nExceedanceSummary: excID = " + excID + ", date = " + date + ", peak = " + peak +
                ", duration = " + duration + ", mc = " + mc;
    }
}
