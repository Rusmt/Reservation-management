package com.example.a15110008.reservationmanagement;

/**
 * Created by 15110014 on 2016/09/01.
 */
        import android.util.SparseBooleanArray;
        import java.io.Serializable;

public class RoomReservationInfomation implements Serializable {
    //部屋の予約情報を収集するクラス

    String user = "testUser";//ユーザー名
    int selectedYear =2015;//年
    int selectedMonth = 9;//月
    int selectedDay = 2;//日
    String selectedFloor = "1F";//階層
    String selectedSize = "大";//部屋の大きさ
    String selectedTime = "";//利用時間
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

    public void ReserveTime(String time){
        this.selectedTime = time;
    }

    //getter

    public  String getUser(){return user;}

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

    public String getSelectedTime(){
        return selectedTime;
    }

    /*public  String getchecked(){
        return checked;
    }*/

}