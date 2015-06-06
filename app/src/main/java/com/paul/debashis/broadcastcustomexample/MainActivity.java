package com.paul.debashis.broadcastcustomexample;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    MyDualReceiver mMyDualReceiver = new MyDualReceiver();
  //  MyDualReceiver mLocalReceiver = new MyDualReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //The Intent filter is register dynamically
        registerReceiver(mMyDualReceiver,new IntentFilter("com.paul.debashis.broadcastdualexample.DYNAMIC_BROADCAST"));

        //register the LocalBroadcastManager
        LocalBroadcastManager.getInstance(this).registerReceiver(mMyDualReceiver,
                new IntentFilter("com.paul.debashis.broadcastdualexample.LOCAL_BROADCAST"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mMyDualReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMyDualReceiver);
    }

    public void staticBroadcast (View view){
        Intent mIntent = new Intent();
        //for static, intent filter is added in Manifest. e.g. "com.paul.debashis.broadcastdualexample.STATIC_BROADCAST" is added
        //in the Manifest file
        mIntent.setAction("com.paul.debashis.broadcastdualexample.STATIC_BROADCAST");
        mIntent.putExtra("type","Static Type");
        sendBroadcast(mIntent);
    }

    public void dynamicBroadcast (View view){
        Intent mIntent = new Intent();
        mIntent.setAction("com.paul.debashis.broadcastdualexample.DYNAMIC_BROADCAST");
        mIntent.putExtra("type","Dynamic Type");
        sendBroadcast(mIntent);
    }

    public void localBroadcastManager (View view){
        Intent mIntent = new Intent();
        mIntent.setAction("com.paul.debashis.broadcastdualexample.LOCAL_BROADCAST");
        mIntent.putExtra("type","LocalBroadcastManager Type");
        LocalBroadcastManager.getInstance(this).sendBroadcast(mIntent);
    }
}
