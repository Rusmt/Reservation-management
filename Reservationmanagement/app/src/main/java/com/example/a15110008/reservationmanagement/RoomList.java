package com.example.a15110008.reservationmanagement;

import android.util.SparseBooleanArray;

import java.io.Serializable;

public class RoomList implements Serializable {
    //部屋の予約情報を収集するクラス

    int selectedYear = 0;//年
    int selectedMonth = 0;//月
    int selectedDay = 0;//日
    String selectedFloor = "";//階層
    String selectedSize = "";//部屋の大きさ
    SparseBooleanArray checked;//選択利用時間

    //setter

    public void ReserveYear(int  year){
        this.selectedYear = year;
    }

    public void ReserveMonth(int  month){
        this.selectedMonth = month;
    }

    public void ReserveDay(int  day){
        this.selectedDay = day;
    }

    public void ReserveFloor(String floor){
        this.selectedFloor = floor;
    }

    public void ReserveSize(String size){
        this.selectedSize = size;
    }

    public void ReserveHour(SparseBooleanArray checked){
        this.checked = checked;
    }

    //getter

    public String getSelectedYear(){
        String year = Integer.toString(selectedYear);
        return year;
    }

    public String getSelectedMonth(){
        String month = Integer.toString(selectedMonth);
        return month;
    }

    public String getSelectedDay(){
        String day = Integer.toString(selectedDay);
        return day;
    }

    public String getSelectedFloor(){
        return selectedFloor;
    }

    public String getSelectedSize(){
        return selectedSize;
    }

    public  String getchecked(){
        return checked;
    }

}