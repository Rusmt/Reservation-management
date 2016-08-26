package com.example.a15110008.reservationmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

        TabSpec sbtab1 = menutab.newTabSpec("tab1");
        sbtab1.setIndicator("予約");
        sbtab1.setContent(R.id.shTab1);
        menutab.addTab(sbtab1);

        TabSpec sbtab2 = menutab.newTabSpec("tab2");
        sbtab2.setIndicator("予約確認");
        sbtab2.setContent(R.id.shTab2);
        menutab.addTab(sbtab2);

        menutab.setCurrentTab(0);

        //ListView
        final ListView houritems = (ListView)findViewById(R.id.hourItem);
        houritems.setItemsCanFocus(false);

        final ArrayList<String> items = new ArrayList<>();
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
        houritems.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        Button cbokbtn = (Button)findViewById(R.id.sbOKbtn);

        cbokbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectHour.this, ConfirmReservation.class);
                String selecteditem = "";
                String search = "";
                int index;
                boolean consecutiveflg = false;
                //チェック済みのitemを取得する
                SparseBooleanArray checked = houritems.getCheckedItemPositions();
                int i, j;
                for (i = 0; i < items.size(); i++) {
                    for (j = i + 1; j < items.size(); j++) {
                        //連続で時間帯が選択されているかを判定する
                        if (checked.get(i) == true) {
                            if (checked.get(j) == false) {
                                //連続選択されていない場合
                                if (i == j - 1) {
                                    selecteditem = items.get(i) + "\r\n";
                                    consecutiveflg = false;
                                    break;
                                }
                            } else {
                                //連続選択されている場合
                                //前半時間帯の抜き出し
                                search = items.get(i);
                                index = search.indexOf("～");
                                selecteditem = selecteditem + search.substring(0, index);
                                //後半時間帯の抜き出し
                                search = items.get((j));
                                index = search.indexOf("～");
                                selecteditem = selecteditem + search.substring(index) + "\r\n";
                                i = j;
                                consecutiveflg = true;
                                    break;
                            }
                        }
                    }
                }
                if(checked.get((items.size()) - 1) == true) {
                    if (consecutiveflg == false) {
                        selecteditem = selecteditem + items.get(items.size() - 1);
                    } else {
                        search = items.get(items.size() - 1);
                        index = search.indexOf("～");
                        int index2 = selecteditem.lastIndexOf("～");
                        selecteditem = selecteditem.substring(0,index2) + search.substring(index) + "\r\n";
                    }
                }
                intent.putExtra("selectedhour", selecteditem);
                startActivity(intent);

            }
        });
    }
}