package com.bluesky.mobileEEI;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.beardedhen.androidbootstrap.TypefaceProvider;

import java.util.ArrayList;
import java.util.Arrays;

public class ExceedancePage extends AppCompatActivity {
    private DownloadFile downloadFile;
    private ExceedanceSummary[] exceedanceSummary;
    public Button home;
//    private ExceedanceDetail exceedanceDetail;

    public void buttons() {
        home = findViewById(R.id.exceedancesToHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(ExceedancePage.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        downloadFile = (DownloadFile) getIntent().getSerializableExtra("DownloadFile");
        exceedanceSummary = downloadFile.getExceedanceSummary();
//        exceedanceDetail = downloadFile.getExceedanceDetail();

        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.exceedance_activity);

        final ListView exceedancesListView = (ListView) findViewById(R.id.exceedancesListView);

        final ArrayList<ExceedanceSummary> exceedances = new ArrayList<>();
        exceedances.addAll(Arrays.asList(exceedanceSummary));

        ArrayAdapter exceedancesAdapter = new ArrayAdapter<>(this, R.layout.simplerow, exceedances);
        exceedancesListView.setAdapter(exceedancesAdapter);

        exceedancesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                FragmentManager fm = getFragmentManager();
                ExceedanceDialogFragment exceedanceDialogFragment = new ExceedanceDialogFragment();
                exceedanceDialogFragment.show(fm, "Selected Exceedance");
            }
        });

        buttons();

    }

}
