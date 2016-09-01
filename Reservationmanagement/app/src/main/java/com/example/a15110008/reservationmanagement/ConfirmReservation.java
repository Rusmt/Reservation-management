package com.example.a15110008.reservationmanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class ConfirmReservation extends AppCompatActivity {

    public static Intent getStartActivityIntent(Context context) {
        Intent intent = new Intent(context, ConfirmReservation.class);
        return intent;
    }

    private static final String TAG = ConfirmReservation.class.getSimpleName();

    //FIreBaseのURL
    private final static String BASE_URL = "https://reservationmanagement-161c6.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_reservation);

        //firebase設定
        Firebase.setAndroidContext(getApplicationContext());

        //利用時間の取得
        TextView srselectedhour =(TextView)findViewById((R.id.selectedHour));
        srselectedhour.setText(getIntent().getExtras().getString("selectedhour"));
        final RoomReservationInfomation reserveInfo = (RoomReservationInfomation)getIntent().getSerializableExtra("reserve_info");

        Button crOKBtn = (Button)findViewById(R.id.crOKButton);

        crOKBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Intent intent = new Intent(ConfirmReservation.this, Reservation.class);
                addresetrvation(reserveInfo);
                startActivity(intent);
            }
        });
    }

    //予約データをFireBaseに入力するメソッド
    private void addresetrvation(RoomReservationInfomation reserveinfo){

        //classから取得したデータをFireBaseに登録できるように整理
        String date = reserveinfo.getSelectedYear() + reserveinfo.getSelectedMonth() + reserveinfo.getSelectedDay();
        String floor = reserveinfo.getSelectedFloor();
        String size = reserveinfo.getSelectedSize();

        String time = reserveinfo.getSelectedTime();

        int index = time.indexOf("～");
        String startTime = time.substring(0,index - 1);
        String endTime = time.substring(index);

        //予約データ
        Firebase messages = new Firebase(BASE_URL + "Test");//値を設定するDBを決める
        messages.push().setValue(
                new ReservationInfo(date,floor,size,startTime,endTime),//設定する項目数
                new Firebase.CompletionListener(){
            @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase){
                if (firebaseError != null) {
                    Log.e(TAG, firebaseError.getMessage(), firebaseError.toException());
                    return;
                }

                Log.d(TAG, "data successfully saved!");
            }
        }

        );

    }


}
