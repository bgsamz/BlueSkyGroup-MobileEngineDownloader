package com.bluesky.mobileEEI;

import java.io.Serializable;

/**
 * Created by bgsamz on 2/19/18.
 */

public class DownloadFile implements Serializable {
    private AllEventsChart allEventsChart;
    private Chart chart;
    private EngineData engineData;
    private EngineMaintenanceData engineMaintenanceData;
    private Event event;
    private EventSummary eventSummary;
//    private ExceedanceDetail exceedanceDetail;
    private ExceedanceSummary[] exceedanceSummary;
    private Fault[] faults;

    public DownloadFile () {

    }

    public EngineData getEngineData() {
        return engineData;
    }

    public AllEventsChart getAllEventsChart() {
        return allEventsChart;
    }

    public Chart getChart() {
        return chart;
    }

    public EngineMaintenanceData getEngineMaintenanceData() {
        return engineMaintenanceData;
    }

    public Event getEvent() {
        return event;
    }

    public EventSummary getEventSummary() {
        return eventSummary;
    }

//   // public ExceedanceDetail getExceedanceDetail() {
//        return exceedanceDetail;
//    }

    public ExceedanceSummary[] getExceedanceSummary() {
        return exceedanceSummary;
    }

    public Fault[] getFaults() {
        return faults;
    }

    @Override
    public String toString() {
        return "\nDownloadFile: "+ allEventsChart + chart + engineData + engineMaintenanceData +
                event + eventSummary + exceedanceSummary.toString() + faults.toString();
    }
}
