package org.example.model;

public class Info {
    Hotel hotel;
    Hotel.HotelInfo hotelInfo;

    public Info(Hotel hotel, Hotel.HotelInfo hotelInfo) {
        this.hotel = hotel;
        this.hotelInfo = hotelInfo;
    }

    public String getName() {
        return hotel.name;
    }

    public Hotel.HotelInfo getInfo() {
        return hotelInfo;
    }
}