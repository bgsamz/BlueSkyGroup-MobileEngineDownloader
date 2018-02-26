package com.bluesky.mobileEEI;

import java.util.Date;

/**
 * Created by Robert on 2/15/2018.
 */

public class EngineData
{
    private String engineSerial;
    private String aircraftID;
    private Date dateTime;
    private String enginePosition;
    private String userName;
    private String operator;

    public EngineData(String engineSerial, String aircraftID, Date dateTime,
                      String enginePosition, String userName, String operator)
    {
        this.engineSerial = engineSerial;
        this.aircraftID = aircraftID;
        this.dateTime = dateTime;
        this.enginePosition = enginePosition;
        this.userName = userName;
        this.operator = operator;
    }

    public EngineData() {

    }

    @Override
    public String toString() {
        return "\nEngineData: engineSerial = " + engineSerial + ", aircraftID = " + aircraftID + ", dateTime = "
                + dateTime + ", enginePosition = " + enginePosition + ", userName = " + userName + ", operator = " + operator;
    }
}
