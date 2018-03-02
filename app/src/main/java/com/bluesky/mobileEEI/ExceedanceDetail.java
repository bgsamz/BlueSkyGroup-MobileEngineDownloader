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

    @Override
    public String toString() {
        return "\nExceedanceDetail: parameter = " + parameter + ", value = " + value + ", unit = " + unit;
    }
}
