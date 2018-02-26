package com.bluesky.mobileEEI;

/**
 * Created by bgsamz on 2/19/18.
 */

public class DownloadFile {
    private AllEventsChart allEventsChart;
    private Chart chart;
    private EngineData engineData;
    private EngineMaintenanceData engineMaintenanceData;
    private Event event;
    private EventSummary eventSummary;
    private ExceedanceDetail exceedanceDetail;
    private ExceedanceSummary exceedanceSummary;
    private Fault fault;

    public DownloadFile () {

    }

    @Override
    public String toString() {
        return "\nDownloadFile: "+ allEventsChart + chart + engineData + engineMaintenanceData +
                event + eventSummary + exceedanceDetail + exceedanceSummary + fault;
    }
}
