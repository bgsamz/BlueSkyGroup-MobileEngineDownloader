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
    private ExceedanceDetail exceedanceDetail;

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

    public String getExcID() {
        return excID;
    }

    public Date getDate() {
        return date;
    }

    public float getPeak() {
        return peak;
    }

    public int getDuration() {
        return duration;
    }

    public int getMc() {
        return mc;
    }

    public ExceedanceDetail getExceedanceDetail() {
        return exceedanceDetail;
    }

    @Override
    public String toString() {
        return excID + "    " + date + "    " + peak +
                "    " + duration + "    " + mc;
    }
}
