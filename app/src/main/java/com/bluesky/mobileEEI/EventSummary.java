package com.bluesky.mobileEEI;

/**
 * Created by Robert on 2/15/2018.
 */

public class EventSummary
{
    private Event[] events;

    public EventSummary(Event[] events)
    {
        this.events = events;
    }

    public EventSummary() {

    }

    @Override
    public String toString() {
        return "\nEventSummary: events = " + java.util.Arrays.toString(events);
    }
}
