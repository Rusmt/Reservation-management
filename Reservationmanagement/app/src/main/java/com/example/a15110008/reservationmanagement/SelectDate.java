package com.example.a15110008.reservationmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TabHost;

import java.util.Calendar;

public class SelectDate extends AppCompatActivity {
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);

        //TabHost
        TabHost menutab = (TabHost) findViewById(R.id.tabHost4);
        menutab.setup();

        TabHost.TabSpec sbtab1 = menutab.newTabSpec("shtab1");
        sbtab1.setIndicator("予約");
        sbtab1.setContent(R.id.shTab1);
        menutab.addTab(sbtab1);

        TabHost.TabSpec sbtab2 = menutab.newTabSpec("shtab2");
        sbtab2.setIndicator("予約確認");
        sbtab2.setContent(R.id.shTab2);
        menutab.addTab(sbtab2);

        menutab.setCurrentTab(0);

        //DatePicker
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        //日付の選択範囲を設定
        Calendar today = Calendar.getInstance();//下限値(当日)
        Calendar maxday = Calendar.getInstance();//上限値(翌月)
        maxday.add(Calendar.MONTH, 1);

        if(datePicker != null) {
            //下限値(当日)の指定
            datePicker.setMinDate(today.getTimeInMillis());
            //上限値(翌月)の指定
            datePicker.setMaxDate(maxday.getTimeInMillis());
        }

        //決定ボタン入力でDatePickerの日付を取得する
        Button sdOKbtn = (Button) findViewById(R.id.sdOKbtn);

        //決定ボタンを押した時の処理
        sdOKbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int inputYear = datePicker.getYear();//年を取得
                int inputMonth = datePicker.getMonth();//月を取得
                int inputDay = datePicker.getDayOfMonth();//日を取得
                Intent intent = new Intent(SelectDate.this, floorActivity.class);
                intent.putExtra("selectedyear",inputYear);
                intent.putExtra("selectedmonth",inputMonth);
                intent.putExtra("selectedday",inputDay);
                startActivity(intent);
            }
        });
    }
}

