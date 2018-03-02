package com.bluesky.mobileEEI;

import java.io.Serializable;

/**
 * Created by Robert on 2/15/2018.
 */

public class Chart implements Serializable
{
    private String eventType;
    private Event events;
    private String chartType;

    public Chart(String eventType, Event events, String chartType)
    {
        this.eventType = eventType;
        this.events = events;
        this.chartType = chartType;
    }

    public Chart() {

    }

    @Override
    public String toString() {
        return "\nChart: eventType = " + eventType + ", event = " + events + ", chartType = " + chartType;
    }
}
