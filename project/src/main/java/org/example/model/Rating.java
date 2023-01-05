package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Rating {
    Hotel hotel;
    ArrayList<Hotel.HotelRating> hotelRatings;

    public Rating(Hotel hotel, ArrayList<Hotel.HotelRating> hotelRatings) {
        this.hotel = hotel;
        this.hotelRatings = hotelRatings;
    }

    public String getName() {
        return hotel.name;
    }

    public List<Hotel.HotelRating> getRatings() {
        return hotelRatings;
    }
}