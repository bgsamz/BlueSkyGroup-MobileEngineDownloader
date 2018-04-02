package com.bluesky.mobileEEI;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.beardedhen.androidbootstrap.TypefaceProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Joseph on 3/24/2018.
 */

public class FaultsPage extends AppCompatActivity{
    private DownloadFile downloadFile;
    public ListView mainListView ;
    public ArrayAdapter listAdapter ;
    private Fault[] faults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.faults_activity);
        downloadFile = (DownloadFile) getIntent().getSerializableExtra("DownloadFile");
        faults = downloadFile.getFaults();

        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.faults_list );

        final ArrayList<Fault> faultItems = new ArrayList<>();
        faultItems.addAll( Arrays.asList(faults) );

        // Create ArrayAdapter using the item list.
        listAdapter = new ArrayAdapter<>(this, R.layout.simplerow, faultItems);
        mainListView.setAdapter( listAdapter );

     //   buttons();

    }
}
