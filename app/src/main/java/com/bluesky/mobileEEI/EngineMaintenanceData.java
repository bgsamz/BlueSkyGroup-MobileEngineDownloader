package com.bluesky.mobileEEI;

import java.io.Serializable;

/**
 * Created by Robert on 2/15/2018.
 */

public class EngineMaintenanceData implements Serializable
{
    private int numberConditions;
    private int numberTypeOne;
    private int numberTypeTwo;
    private int numberEvents;
    private int numberChips;
    private int numberOilBypass;

    public EngineMaintenanceData( int numberConditions, int numberTypeOne, int numberTypeTwo,
                                  int numberEvents, int numberChips, int numberOilBypass)
    {
        this.numberConditions = numberConditions;
        this.numberTypeOne = numberTypeOne;
        this.numberTypeTwo = numberTypeTwo;
        this.numberEvents = numberEvents;
        this.numberChips = numberChips;
        this.numberOilBypass = numberOilBypass;
    }

    public EngineMaintenanceData () {

    }

    public int getNumberConditions() {
        return numberConditions;
    }

    public int getNumberTypeOne() {
        return numberTypeOne;
    }

    public int getNumberTypeTwo() {
        return numberTypeTwo;
    }

    public int getNumberEvents() {
        return numberEvents;
    }

    public int getNumberChips() {
        return numberChips;
    }

    public int getNumberOilBypass() {
        return numberOilBypass;
    }

    @Override
    public String toString() {
        return "\nEngineMaintenanceData: numberConditions =  " + numberConditions + ", numberTypeOne = " + numberTypeOne +
                ", numberTypeTwo = " + numberTypeTwo + ", numberEvents = " + numberEvents +
                ", numberChips = " + numberChips + ", numberOilBypass = " + numberOilBypass;
    }
}
