package com.example.kinoticketreservierungssystem.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.Gson;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;


@Container(containerName = "Seats", ru= "400" )
public class Seat {
    // seatID naming convention: EventRoomID + Row + SeatNumber
    @Id
    private String seatID;
    private EventRoom eventRoomInfo;
    // row naming convention: A,B,C,D...
    @PartitionKey
    private char row;
    private int seatNumber;
    private boolean booked;

    public Seat(String seatID, EventRoom eventRoomInfo, char row, int seatNumber, boolean booked) {
        this.seatID = seatID;
        this.eventRoomInfo = eventRoomInfo;
        this.row = row;
        this.seatNumber = seatNumber;
        this.booked = booked;
    }

    public Seat() {

    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this, Seat.class);
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public EventRoom getEventRoomInfo() {
        return eventRoomInfo;
    }

    public void setEventRoomInfo(EventRoom eventRoomInfo) {
        this.eventRoomInfo = eventRoomInfo;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
