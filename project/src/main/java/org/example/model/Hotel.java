package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public String name;

    public Hotel(String name) {
        this.name = name;
    }

    public static class HotelComment {
        public ArrayList<String> review;

        public HotelComment(ArrayList<String> review) {
            this.review = review;
        }

        public ArrayList<String> getReview() {
            return review;
        }
    }

    public static class HotelInfo {
        public String address;

        public HotelInfo(String address) {
            this.address = address;
        }
    }

    public static class HotelRating {
        String field;
        double stars;

        public HotelRating(String field, double stars) {
            this.field = field;
            this.stars = stars;
        }
    }

    public static class HotelService {
        List<String> propertyServices;
        List<String> roomServices;
        List<String> roomTypes;

        public HotelService(List<String> propertyServices, List<String> roomServices, List<String> roomTypes) {
            this.propertyServices = propertyServices;
            this.roomServices = roomServices;
            this.roomTypes = roomTypes;
        }
    }
}