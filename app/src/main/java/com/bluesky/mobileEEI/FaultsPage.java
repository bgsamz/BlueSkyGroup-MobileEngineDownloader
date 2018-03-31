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
    String[] faults = new String[]{};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.faults_activity);
        downloadFile = (DownloadFile) getIntent().getSerializableExtra("DownloadFile");
        for(int i=0; i<downloadFile.getFaults().length; i++){
            faults[i] = downloadFile.getFaults()[i].toString();
        }
        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.faults_list );

        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.addAll( Arrays.asList(faults) );

        // Create ArrayAdapter using the item list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, itemsList);
        mainListView.setAdapter( listAdapter );

     //   buttons();

    }
}
