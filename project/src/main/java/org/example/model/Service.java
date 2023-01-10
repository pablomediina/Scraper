package org.example.model;

public class Service {
    Hotel hotel;
    Hotel.HotelService hotelService;

    public Service(Hotel hotel, Hotel.HotelService hotelService) {
        this.hotel = hotel;
        this.hotelService = hotelService;
    }

    public String getName() {
        return hotel.name;
    }

    public Hotel.HotelService getServices() {
        return hotelService;
    }
}