package com.example.a15110008.reservationmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import java.util.ArrayList;

public class SelectHour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_hour);

        //TabHost
        TabHost menutab =(TabHost)findViewById(R.id.tabHost2);
        menutab.setup();

        TabSpec tab1 = menutab.newTabSpec("tab1");
        tab1.setIndicator("タブ１");
        tab1.setContent(R.id.shTab1);
        menutab.addTab(tab1);

        TabSpec tab2 = menutab.newTabSpec("tab2");
        tab2.setIndicator("タブ2");
        tab2.setContent(R.id.shTab2);
        menutab.addTab(tab2);

        menutab.setCurrentTab(0);

        //ListView
        ListView houritems = (ListView)findViewById(R.id.hourItem);
        houritems.setItemsCanFocus(false);

        ArrayList<String> items = new ArrayList<>();
        items.add("9:00～10:00");
        items.add("10:00～11:00");
        items.add("11:00～12:00");
        items.add("12:00～13:00");
        items.add("13:00～14:00");
        items.add("14:00～15:00");
        items.add("15:00～16:00");
        items.add("16:00～17:00");
        items.add("17:00～18:00");
        items.add("18:00～19:00");

        houritems.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_checked,items ));
        houritems.setChoiceMode(ListView.CHOICE_MODE_NONE);

    }
}