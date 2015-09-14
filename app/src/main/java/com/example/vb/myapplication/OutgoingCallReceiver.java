package com.example.vb.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by VB on 9/14/15.
 */
public class OutgoingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String oldNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);          // 3
//        this.setResultData("0123456789");                                                   // 4
//        final String newNumber = this.getResultData();
        String msg = "Intercepted outgoing call. Old number " + oldNumber;
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        SharedPreferences pref = context.getSharedPreferences("LAST_CALL",0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("last_dialed_number",oldNumber);
        editor.commit();
    }
}
