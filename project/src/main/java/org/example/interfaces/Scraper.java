package org.example.interfaces;

import org.example.model.*;

import java.util.List;

public interface Scraper {
    public abstract List<Comment> getComments();
    public abstract List<Rating> getRatings();
    public abstract List<Info> getInfo();
    public abstract List<Service> getServices();
}
