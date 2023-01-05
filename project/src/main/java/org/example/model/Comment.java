package org.example.model;

import java.util.ArrayList;

public class Comment {
    Hotel hotel;
    Hotel.HotelComment hotelComment;

    public Comment(Hotel hotel, Hotel.HotelComment hotelComment) {
        this.hotel = hotel;
        this.hotelComment = hotelComment;
    }

    public String getName() {
        return hotel.name;
    }

    public ArrayList<String> getReview() {
        return hotelComment.getReview();
    }
}