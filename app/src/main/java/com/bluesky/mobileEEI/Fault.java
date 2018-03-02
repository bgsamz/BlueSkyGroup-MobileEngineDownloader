package com.bluesky.mobileEEI;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Robert on 2/15/2018.
 */

public class Fault implements Serializable
{
    private int ffFaultID;
    private String description;
    private Date date;

    public Fault(int ffFaultID, String description, Date date)
    {
        this.ffFaultID = ffFaultID;
        this.description = description;
        this.date = date;
    }

    public Fault() {

    }

    @Override
    public String toString() {
        return "\nFault: ffFaultID = " + ffFaultID + ", description = " + description + ", date = " + date;
    }
}
