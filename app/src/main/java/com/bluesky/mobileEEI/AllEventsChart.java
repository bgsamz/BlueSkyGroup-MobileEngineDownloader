package com.bluesky.mobileEEI;

/**
 * Created by Robert on 2/15/2018.
 */

public class AllEventsChart
{
    private String[] parameter;
    private int[] value;
    private String[] unit;

    public AllEventsChart(String[] parameter, int[] value, String[] unit)
    {
        this.parameter = parameter;
        this.value = value;
        this.unit = unit;
    }

    public AllEventsChart() {

    }

    @Override
    public String toString() {
        return "\nAllEventsChart: parameter = " + java.util.Arrays.toString(parameter) +
                ", value = " + java.util.Arrays.toString(value) + ", unit = " +
                java.util.Arrays.toString(unit);
    }
}
