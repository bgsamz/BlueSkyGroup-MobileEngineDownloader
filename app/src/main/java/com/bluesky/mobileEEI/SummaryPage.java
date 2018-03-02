package com.bluesky.mobileEEI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by bgsamz on 3/1/18.
 */

public class SummaryPage extends AppCompatActivity {
    private DownloadFile downloadFile;
    private EngineData engineData;
    private EngineMaintenanceData engineMaintenanceData;
    public Button home;

    public void buttons() {
        TextView serialNum = (TextView) findViewById(R.id.serialNum);
        serialNum.setText(engineData.getEngineSerial());

        TextView aircraftID = (TextView) findViewById(R.id.aircraftID);
        aircraftID.setText(engineData.getAircraftID());

        TextView downloadData = (TextView) findViewById(R.id.downloadDate);
        downloadData.setText(engineData.getDateTime().toString());

        TextView enginePos = (TextView) findViewById(R.id.enginePos);
        enginePos.setText(engineData.getEnginePosition());

        TextView operator = (TextView) findViewById(R.id.operator);
        operator.setText(engineData.getOperator());

        TextView maintCond = (TextView) findViewById(R.id.maintCond);
        maintCond.setText(engineMaintenanceData.getNumberConditions());

        TextView exceedences = (TextView) findViewById(R.id.exceedences);
        exceedences.setText(engineMaintenanceData.getNumberTypeOne());

        TextView events = (TextView) findViewById(R.id.events);
        events.setText(engineMaintenanceData.getNumberEvents());

        TextView chips = (TextView) findViewById(R.id.chips);
        chips.setText(engineMaintenanceData.getNumberChips());

        TextView oilBypasses = (TextView) findViewById(R.id.oilBypasses);
        oilBypasses.setText(engineMaintenanceData.getNumberOilBypass());

        home = findViewById(R.id.summaryToHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(SummaryPage.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.summary_activity);
        downloadFile = (DownloadFile) getIntent().getSerializableExtra("DownloadFile");
        engineData = downloadFile.getEngineData();
        engineMaintenanceData = downloadFile.getEngineMaintenanceData();

        buttons();

    }
}
