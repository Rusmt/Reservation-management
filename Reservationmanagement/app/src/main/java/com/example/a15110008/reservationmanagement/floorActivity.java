package com.example.a15110008.reservationmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class floorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("1F");
        adapter.add("2F");
        adapter.add("3F");
        adapter.add("4F");
        adapter.add("5F");
        adapter.add("6F");

        ListView list = (ListView) findViewById(R.id.listView);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(floorActivity.this, RoomActivity.class);
                intent.putExtra("room_list",getroom_list());
                startActivity(intent);
            }
        });
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent(floorActivity.this,Reservation.class);
                startActivity(intent);
            }
        });
    }
    private RoomList getroom_list(){
        String[][] room_list;
        room_list = new String[7][2];

        String sum[];
        sum=new String[2];
        sum[0]="101号室";
        sum[1]="大";

        String sum2[];
        sum2=new String[2];
        sum2[0]="102号室";
        sum2[1]="大";

        String sum3[];
        sum3=new String[2];
        sum3[0]="103号室";
        sum3[1]="中";

        String sum4[];
        sum4=new String[2];
        sum4[0]="104号室";
        sum4[1]="中";

        String sum5[];
        sum5=new String[2];
        sum5[0]="105号室";
        sum5[1]="小";

        String sum6[];
        sum6=new String[2];
        sum6[0]="106号室";
        sum6[1]="小";

        String  sum7[];
        sum7=new String[2];
        sum7[0]="107号室";
        sum7[1]="大";

        room_list[0]=sum;
        room_list[1]=sum2;
        room_list[2]=sum3;
        room_list[3]=sum4;
        room_list[4]=sum5;
        room_list[5]=sum6;
        room_list[6]=sum7;

        return new RoomList(room_list);
    }
}