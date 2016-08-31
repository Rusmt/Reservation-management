package com.example.a15110008.reservationmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;


//参考URL:http://gihyo.jp/dev/serial/01/firebase/0002?page=2
public class FirebaseTestActivity extends AppCompatActivity {

    private static final String TAG = FirebaseTestActivity.class.getSimpleName();

    public static Intent getStartActivityIntent(Context context) {
        Intent intent = new Intent(context, FirebaseTestActivity.class);
        return intent;
    }

    private final static String BASE_URL = "https://reservationmanagement-161c6.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_test);


        //データベース利用準備（必須）
        Firebase.setAndroidContext(getApplicationContext());

        {
            //部屋マスタ取得
            Button button = (Button) findViewById(R.id.getRoomMasterButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getRoomMaster();
                }
            });
        }
        {
            //予約作成
            Button button = (Button) findViewById(R.id.addReservationButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addReservation("room01" , "test_user" , "20160101" , "1700" , "1800");
                }
            });
        }
        {
            //自分の予約一覧取得
            Button button = (Button) findViewById(R.id.getMyReservation);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getMyReservations();
                }
            });
        }
        {
            //部屋のその日の予約一覧取得
            Button button = (Button) findViewById(R.id.search_room_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getRoomReservations("room02" , "20160831");
                }
            });
        }
    }


    private void getRoomMaster(){
        Firebase messages = new Firebase(BASE_URL + "rooms");
        //初回のみ動作するイベント
        messages.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Log.d(TAG , "RoomMaster : " + dataSnapshot.getValue(RoomInfo.class).toString());
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                //nothing
            }
        });
    }

    private void addReservation(String roomId , String userId , String date , String startTime , String endTime){
        {
            //予約データ
            Firebase messages = new Firebase(BASE_URL + "reservations_data");
            messages.push().setValue(
                    new ReservationInfo(roomId, userId, date, startTime, endTime),
                    new Firebase.CompletionListener() {
                        @Override
                        public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                            if (firebaseError != null) {
                                Log.e(TAG, firebaseError.getMessage(), firebaseError.toException());
                                return;
                            }

                            Log.d(TAG, "data successfully saved!");
                        }
                    }
            );
        }
        {
            //部屋ごとの予約データ
            Firebase messages = new Firebase(BASE_URL + "room_reservations");
            messages.child(roomId).child(date).setValue(
                    new ReservationInfo(roomId , userId , date , startTime , endTime),
                    new Firebase.CompletionListener() {
                        @Override
                        public void onComplete(FirebaseError firebaseError, Firebase firebase) {
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

    private void getMyReservations(){
        Firebase messages = new Firebase(BASE_URL + "reservations_data");

        Query query = messages.orderByChild("user").equalTo("test_user");

        //初回のみ動作するイベント
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ReservationInfo reservationInfo
                            = new ReservationInfo(
                            (String)dataSnapshot.child("room").getValue(),
                            (String)dataSnapshot.child("user").getValue(),
                            (String)dataSnapshot.child("date").getValue(),
                            (String)dataSnapshot.child("starttime").getValue(),
                            (String)dataSnapshot.child("endtime").getValue()
                    );
                    Log.d(TAG , "MyReservations : " + reservationInfo.toString());
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                //nothing
            }
        });
    }

    private void getRoomReservations(String roomId , String date){
        Firebase messages = new Firebase(BASE_URL + "room_reservations");

        //初回のみ動作するイベント
        messages.child(roomId).child(date).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ReservationInfo reservationInfo
                            = new ReservationInfo(
                            (String)dataSnapshot.child("room").getValue(),
                            (String)dataSnapshot.child("user").getValue(),
                            (String)dataSnapshot.child("date").getValue(),
                            (String)dataSnapshot.child("starttime").getValue(),
                            (String)dataSnapshot.child("endtime").getValue()
                    );
                    Log.d(TAG , "MyReservations : " + reservationInfo.toString());
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                //nothing
            }
        });
    }
}
