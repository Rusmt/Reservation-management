package com.example.a15110008.reservationmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectHour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_hour);

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

        //決定ボタンを押した時の動作
        Button cbokbtn = (Button)findViewById(R.id.shOKbtn);

        cbokbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selecteditem = "";
                String search = "";
                int index;
                int i ,firstlocate = 0,count = 0;
                boolean checkflg = false;           //時間帯が選択されているか
                //itemの真偽を判定するためのbolean型の配列
                SparseBooleanArray checked = houritems.getCheckedItemPositions();

                for(i = 0; i <= items.size(); i ++){
                    if(checked.get(i)){
                        count ++;
                        if(count == 1) {
                            firstlocate = i;
                        }
                    }else{
                        switch (count){
                            case 0 :
                                break;
                            case 1 :
                                //単体時間の取得
                                selecteditem = selecteditem + items.get(firstlocate) + "\r\n";
                                count = 0;
                                checkflg = true;
                                break;
                            default:
                                //連続時間の取得
                                //前半時間帯の抜き出し
                                search = items.get(firstlocate);
                                index = search.indexOf("～");
                                selecteditem = selecteditem + search.substring(0, index);

                                //後半時間帯の抜き出し
                                search = items.get(i - 1);
                                index = search.indexOf("～");
                                selecteditem = selecteditem + search.substring(index) + "\r\n";
                                checkflg = true;
                                count = 0;
                                break;
                        }
                    }
                }
                if (checkflg){
                    //画面遷移処理
                    RoomList reserveInfo = new RoomList();
                    reserveInfo.ReserveHour(checked);
                    Intent intent = new Intent(SelectHour.this, ConfirmReservation.class);
                    intent.putExtra("selectedhour", selecteditem);
                    intent.putExtra("reserve_info",reserveInfo);
                    startActivity(intent);
                }else{
                    //時間帯が選択されていない場合Toastで警告
                    Toast toast = Toast.makeText(getApplicationContext(),"時間が選択されていません。",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        //予約情報確認ボタンを押した時の処理
        Button shReserveBtn = (Button)findViewById(R.id.shReserveButton);
        shReserveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Intent intent = new Intent(SelectHour.this, Reservation.class);
                startActivity(intent);
            }

        });
    }
}