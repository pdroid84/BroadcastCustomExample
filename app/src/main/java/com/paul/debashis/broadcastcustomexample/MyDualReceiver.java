package com.paul.debashis.broadcastcustomexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Admin on 02/03/2015.
 */
public class MyDualReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle mBundle = intent.getExtras();
        String mType = mBundle.getString("type");
        Log.d("DEB", "This broadcaast is triggered as "+mType);
        Toast.makeText(context,"The broadcast is called as "+mType,Toast.LENGTH_LONG).show();
    }
}
