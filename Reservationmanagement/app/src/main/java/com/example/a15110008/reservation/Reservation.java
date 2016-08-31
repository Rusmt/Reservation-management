package com.example.a15110008.reservation;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;


import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;

import de.timroes.android.listview.EnhancedListView;

public class Reservation extends AppCompatActivity {


    // 最初のリスト
    private static final String[] INITIAL_LIST = {
            "最初に", "表示される", "リストの", "項目で", "あります", "あ", "い", "う", "え",
            "お", "か", "き", "く",
    };

    String tag = "DialogTest";


    // リストビュー
    private EnhancedListView mListView;

    // リストビューに設定するリストとアダプター
    private LinkedList<String> mItemList;
    private ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        // リストビュー
        mListView = (EnhancedListView) findViewById(R.id.listview1);

        // リストビューにアイテム追加
        mItemList = new LinkedList<String>();
        mItemList.addAll(Arrays.asList(INITIAL_LIST));
        mAdapter = new ArrayAdapter<String>(this, R.layout.list_layout, R.id.text, mItemList);
        mListView.setAdapter(mAdapter);

        // スワイプで消す設定
        mListView.setDismissCallback(new de.timroes.android.listview.EnhancedListView.OnDismissCallback() {
            @Override
            public EnhancedListView.Undoable onDismiss(EnhancedListView listView, final int position) {

                final String item = (String) mAdapter.getItem(position);
                /// 消す処理
                mItemList.remove(position);
                mAdapter.notifyDataSetChanged();
                return new EnhancedListView.Undoable() {
                    @Override
                    public void undo() {
                        // 元に戻す処理
                        mItemList.add(position, item);
                        mAdapter.notifyDataSetChanged();
                    }
                };
            }
        });
        mListView.enableSwipeToDismiss();




        Button confirmBtn = (Button)findViewById(R.id.button);

        confirmBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Reservation.this)//;や}がないので改行はしているが実際は.show()までコードがつながっている
                        .setTitle("変更を確定しますがよろしいですか？")//タイトルの設定
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {//ダイアログ内に表示するボタンの設定"YES"押した場合
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //ボタン押した時の処理内容をここに記述
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {//ダイアログ内に表示するボタンの設定"NO"押した場合
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //ボタン押した時の処理内容をここに記述
                            }
                        })
                        .show();
            }
        });


    }



}