package com.example.a15110008.reservationmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import java.util.ArrayList;
import android.widget.AdapterView.OnItemClickListener;

public class SelectHour extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_hour);

        //タブメニューの作成
       /* TabHost tabhost = (TabHost)findViewById(android.R.id.tabhost);
        tabhost.setup();

        TabSpec tab1 = tabhost.newTabSpec("tab1");
        tab1.setIndicator("予約");
        tab1.setContent(R.id.tab1);
        tabhost.addTab(tab1);

        TabSpec tab2 = tabhost.newTabSpec("tab2");
        tab2.setIndicator("検索");
        tab2.setContent(R.id.tab2);
        tabhost.addTab(tab2);

        tabhost.setCurrentTab(0);   */
        //タブメニューの作成
        //リストビューの作成
        ArrayList<String>item = new ArrayList<String>();
        item.add("9:00～10:00");
        item.add("10:00～11:00");
        item.add("11:00～12:00");
        item.add("12:00～13:00");
        item.add("13:00～14:00");
        item.add("14:00～15:00");
        item.add("15:00～16:00");
        item.add("16:00～17:00");
        item.add("17:00～18:00");
        item.add("18:00～19:00");

        //adapterの作成,
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, item);
        ListView timelist = (ListView) findViewById(R.id.timeList);
        timelist.setAdapter(adapter);

        //クリック時の処理
       //Button
       // timelist.setOnItemClickListener(listViewOnItemClickListener);


        //リストビューの作成
    }



   /* private OnItemClickListener listViewOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            ListView listView = (ListView)adapterView;
            SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
            Log.d("", String.format("position:%d checked:%b", position, checkedItemPositions.get(position)));
        }
    };

    private OnClickListener infoButtonOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            ListView listView = (ListView)findViewById(R.id.timeList);
            SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();       //リストの各行が選択されているかを判断するboolean型の配列
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < checkedItemPositions.size(); i++) {
                int itemIndex = checkedItemPositions.keyAt(i);
                sb.append(String.format("index:%d value:%b\n", itemIndex, checkedItemPositions.get(itemIndex)));
            }
            //ログの排出
            Log.d("", sb.toString());
            Log.d("", "---");
            sb.setLength(0);
            for (int position = 0; position < adapter.getCount(); position++) {
                sb.append(String.format("position:%d checked:%b\n", position, checkedItemPositions.get(position)));
            }
            Log.d("", sb.toString());
        }
    };*/
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
}
