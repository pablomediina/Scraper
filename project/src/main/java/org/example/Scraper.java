package org.example;

import org.example.model.*;

import java.util.List;

public abstract class Scraper {
    public Hotel hotel;
    public abstract List<Comment> getComments();
    public abstract List<Rating> getRatings();
    public abstract List<Info> getInfo();
    public abstract List<Service> getServices();
}
