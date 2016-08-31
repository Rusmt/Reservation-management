package com.example.a15110008.reservationmanagement;

public class ReservationInfo {
    public String room;
    public String user;
    public String date;
    public String starttime;
    public String endtime;

    public ReservationInfo(String room, String user , String date, String starttime , String endtime) {
        this.room = room;
        this.user = user;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    @Override
    public String toString(){
        return String.format("ReservationInfo { room : %s , user : %s ,  date : %s ,  startdate : %s ,  enddate : %s }" , room , user , date , starttime , endtime);
    }

}