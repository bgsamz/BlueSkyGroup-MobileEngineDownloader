package com.bluesky.mobileEEI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by bgsamz on 3/26/18.
 */

public class ExceedanceDialogFragment extends DialogFragment {
    private ExceedanceDetail exceedanceDetail;
    private ExceedanceSummary exceedanceSummary;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        exceedanceSummary = (ExceedanceSummary) getArguments().getSerializable("exceedanceDetail");
        exceedanceDetail = exceedanceSummary.getExceedanceDetail();

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(exceedanceDetail.toString())
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
