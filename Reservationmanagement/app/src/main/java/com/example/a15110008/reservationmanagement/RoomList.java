package com.example.a15110008.reservationmanagement;

import java.io.Serializable;

public class RoomList implements Serializable {

    public String[][] rooms;

    public RoomList(String[][] roomList){
        this.rooms = roomList;
    }
}
