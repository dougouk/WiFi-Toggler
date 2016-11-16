package com.dan190.wifitoggler;

import android.net.wifi.WifiManager;
import android.util.Log;

public class WifiHelper {
    private WifiHelper() {}

    public static void toggle(WifiManager wifiManager){
//        Log.d("current_mode", "toggle starting");
        wifiManager.setWifiEnabled(current_mode(wifiManager));
//        Log.d("current_mode", "toggle complete");
//        Log.d("current_mode", "NEW status: " + wifiManager.getWifiState());
    }

    public static int get_state(WifiManager wifiManager){
//        Log.d("updateUI", "get_state: " + wifiManager.getWifiState());
        return wifiManager.getWifiState();
    }

    public static boolean current_mode(WifiManager wifiManager){
        int status = get_state(wifiManager);
//        Log.d("current_mode", "status: " + wifiManager.getWifiState());
        if (status == 0 || status == 1){
//            Log.d("current_mode", "Wifi is disabled. turning on");

            return true;
        }
        else{
//            Log.d("current_mode", "Enabled. Turning Off.");
            return false;
        }
    }
}
