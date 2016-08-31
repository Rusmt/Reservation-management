package com.example.a15110008.reservationmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class ConfirmReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_reservation);


        //利用時間の取得
        TextView srselectedhour =(TextView)findViewById((R.id.selectedHour));
        srselectedhour.setText(getIntent().getExtras().getString("selectedhour"));


        //確定ボタンを御した時の処理
        Button crOKBtn = (Button)findViewById(R.id.crOKButton);

        crOKBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Intent intent = new Intent(ConfirmReservation.this, Reservation.class);
                startActivity(intent);
            }
        });
    }
}
