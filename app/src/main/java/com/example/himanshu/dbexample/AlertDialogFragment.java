package com.example.himanshu.dbexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by HIMANSHU on 6/11/2017.
 */

public class AlertDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher_round).setMessage("Fire Missiles?").setPositiveButton("fire", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Missiles Fired! "+which,Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("abort", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Missiles still fired! "+which,Toast.LENGTH_LONG).show();

            }
        }).setTitle("Your only Power");
        return builder.create();

    }
}
