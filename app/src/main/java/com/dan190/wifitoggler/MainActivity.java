package com.dan190.wifitoggler;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    static final String ACTIVITY_NAME = "MainActivity";

    WifiManager wifiManager;
    ImageButton stateImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stateImageButton = (ImageButton) findViewById(R.id.imageButton);
        wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

        stateImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                WifiHelper.toggle(wifiManager);
                int state = wifiManager.getWifiState();
                if(state <= 1){

                    //enable Wifi
                    if(!wifiManager.setWifiEnabled(true)){
                        Log.e(ACTIVITY_NAME, "Wifi is not toggled" );
                    }else{
                        stateImageButton.setImageDrawable(getDrawable(R.drawable.on));
                    }
                }
                else{
                    if(!wifiManager.setWifiEnabled(false)){
                        Log.e(ACTIVITY_NAME, "Wifi is not toggled" );
                    }else{
                        stateImageButton.setImageDrawable(getDrawable(R.drawable.off));
                    }
                }

                Log.d(ACTIVITY_NAME, "Wifi State: " + String.valueOf(wifiManager.getWifiState()));
            }
        });
    }
}
