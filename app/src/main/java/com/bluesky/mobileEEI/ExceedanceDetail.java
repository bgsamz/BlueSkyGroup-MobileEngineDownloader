package com.bluesky.mobileEEI;

import java.io.Serializable;

/**
 * Created by Robert on 2/15/2018.
 */

public class ExceedanceDetail implements Serializable
{
    private String parameter;
    private float value;
    private String unit;

    public ExceedanceDetail(String parameter, float value, String unit)
    {
        this.parameter = parameter;
        this.value = value;
        this.unit = unit;
    }

    public ExceedanceDetail() {

    }

    public String getParameter() {
        return parameter;
    }

    public float getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Parameter -- Value -- Unit\n\n" + parameter + " -- " + value + " -- " + unit;
    }
}
