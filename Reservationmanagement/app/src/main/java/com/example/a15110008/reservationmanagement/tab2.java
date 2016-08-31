package com.example.a15110008.reservationmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Locale;

public class tab2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);



        Intent get_room_list=getIntent();
        RoomList room_list= (RoomList) get_room_list.getSerializableExtra("room_list");

        // TableLayoutのグループを取得
        ViewGroup vg = (ViewGroup)findViewById(R.id.table_layout);

        for (int i=0; i<room_list.rooms.length; i++) {
            // 行を追加
            getLayoutInflater().inflate(R.layout.table_layout_row, vg);
            // 文字設定
            TableRow tr = (TableRow)vg.getChildAt(i);
            String str = String.format(Locale.getDefault(), "raw%d", i+1);
            ((TextView)(tr.getChildAt(0))).setText(str);
            ((TextView)(tr.getChildAt(1))).setText(str);
            String room_name=room_list.rooms[i][0];
            String room_size=room_list.rooms[i][1];
            TextView room_name_text_view= (TextView) tr.getChildAt(0);
            TextView room_size_text_view= (TextView) tr.getChildAt(1);
            room_name_text_view .setText(room_name);
            room_size_text_view.setText(room_size);
        }
//        room_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Intent intent = new Intent(RoomActivity.this, RoomActivity.class);
//                startActivity(intent);
//                Toast.makeText(getApplicationContext(), "Test OK!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
