package org.example;

import com.google.gson.Gson;
import org.example.model.*;

import java.util.List;
import java.util.Objects;

import static org.example.RegisteredHotels.checkName;

public class ServiceResolver {
    String infoResolver(List<Info> infos, String hotelName) {
        for (Info info : infos) {
            String realHotelName = checkName(info.getName());
            if (Objects.equals(realHotelName, hotelName)) return new Gson().toJson(info.getInfo());
        }
        return "No hotel info available";
    }

    String ratingResolver(List<Rating> ratings, String hotelName) {
        for (Rating rating : ratings) {
            String realHotelName = checkName(rating.getName());
            if (Objects.equals(realHotelName, hotelName)) return new Gson().toJson(rating.getRatings());
        }
        return "No hotel info available";
    }

    String serviceResolver(List<Service> services, String hotelName) {
        for (Service service : services) {
            String realHotelName = checkName(service.getName());
            if (Objects.equals(realHotelName, hotelName)) return new Gson().toJson(service.getServices());
        }
        return "No hotel info available";
    }

    String commentResolver(List<Comment> comments, String hotelName) {
        for (Comment comment : comments) {
            String realHotelName = checkName(comment.getName());
            if (Objects.equals(realHotelName, hotelName)) return new Gson().toJson(comment.getReview());
        }
        return "No hotel info available";
    }
}