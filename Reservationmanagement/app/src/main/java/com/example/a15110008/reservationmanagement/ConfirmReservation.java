package com.example.a15110008.reservationmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

public class ConfirmReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_reservation);

        //TabHost
        TabHost menutab =(TabHost)findViewById(R.id.tabHost3);
        menutab.setup();

        TabHost.TabSpec crtab1 = menutab.newTabSpec("tab1");
        crtab1.setIndicator("予約");
        crtab1.setContent(R.id.crTab1);
        menutab.addTab(crtab1);

        TabHost.TabSpec crtab2 = menutab.newTabSpec("tab2");
        crtab2.setIndicator("予約確認");
        crtab2.setContent(R.id.crTab2);
        menutab.addTab(crtab2);

        menutab.setCurrentTab(0);

        TextView srselectedhour =(TextView)findViewById((R.id.selectedHour));
        srselectedhour.setText(getIntent().getExtras().getString("selectedhour"));


    }
}
