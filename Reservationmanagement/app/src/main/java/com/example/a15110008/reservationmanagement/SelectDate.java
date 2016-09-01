package com.example.a15110008.reservationmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class SelectDate extends AppCompatActivity {
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);

        //DatePicker
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        //日付の選択範囲を設定
        Calendar today = Calendar.getInstance();//下限値(当日)
        Calendar maxday = Calendar.getInstance();//上限値(翌月)
        maxday.add(Calendar.MONTH, 1);

        if(datePicker != null) {
            //上限値(翌月)の指定
            maxday.set(Calendar.HOUR_OF_DAY, maxday.getMaximum(Calendar.HOUR_OF_DAY));
            maxday.set(Calendar.MINUTE, maxday.getMaximum(Calendar.MINUTE));
            maxday.set(Calendar.SECOND, maxday.getMaximum(Calendar.SECOND));
            maxday.set(Calendar.MILLISECOND, maxday.getMaximum(Calendar.MILLISECOND));
            datePicker.setMaxDate(maxday.getTimeInMillis());

            //下限値(当日)の指定
            today.set(Calendar.HOUR_OF_DAY, today.getMinimum(Calendar.HOUR_OF_DAY));
            today.set(Calendar.MINUTE, today.getMinimum(Calendar.MINUTE));
            today.set(Calendar.SECOND, today.getMinimum(Calendar.SECOND));
            today.set(Calendar.MILLISECOND, today.getMinimum(Calendar.MILLISECOND));
            datePicker.setMinDate(today.getTimeInMillis());
        }

        //決定ボタン入力でDatePickerの日付を取得する
        Button sdOKbtn = (Button) findViewById(R.id.sdOKbtn);

        //決定ボタンを押した時の処理
        sdOKbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomList reserveInfo = new RoomList();
                reserveInfo.ReserveYear(datePicker.getYear());
                reserveInfo.ReserveMonth(datePicker.getMonth());
                reserveInfo.ReserveDay(datePicker.getDayOfMonth());
                Intent intent = new Intent(SelectDate.this, floorActivity.class);
                intent.putExtra("reserve_info",reserveInfo);
                startActivity(intent);
            }
        });

        //予約情報確認ボタンを押した時の処理
        Button shReserveBtn = (Button)findViewById(R.id.sdReservationBTN);
        shReserveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Intent intent = new Intent(SelectDate.this, Reservation.class);
                startActivity(intent);
            }
        });
    }
}

