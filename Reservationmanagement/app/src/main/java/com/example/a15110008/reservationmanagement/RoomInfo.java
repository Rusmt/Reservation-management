package com.example.a15110008.reservationmanagement;

public class RoomInfo {
    public String floor;
    public String name;
    public String id;
    public String size;

    @Override
    public String toString() {
        return String.format("room { id : %s , name : %s , floor : %s , size :  %s }" , id , name , floor , size);
    }
}
