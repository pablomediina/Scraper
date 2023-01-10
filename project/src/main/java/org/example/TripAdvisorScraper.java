package org.example;

import org.example.interfaces.Scraper;
import org.example.model.*;
import org.example.tripadvisorscrapers.CommentsScraper;
import org.example.tripadvisorscrapers.InfoScraper;
import org.example.tripadvisorscrapers.RatingsScraper;
import org.example.tripadvisorscrapers.ServiceScraper;

import java.util.ArrayList;
import java.util.List;

public class TripAdvisorScraper implements Scraper {
    public static final ArrayList<String> urls = new ArrayList<>(List.of(
            "https://www.tripadvisor.es/Hotel_Review-g2089121-d241729-Reviews-Lopesan_Costa_Meloneras_Resort_Spa-Meloneras_Gran_Canaria_Canary_Islands.html",
            "https://www.tripadvisor.es/Hotel_Review-g230095-d530762-Reviews-Hotel_Riu_Gran_Canaria-Maspalomas_Gran_Canaria_Canary_Islands.html",
            "https://www.tripadvisor.es/Hotel_Review-g230095-d577914-Reviews-Caybeach_Meloneras-Maspalomas_Gran_Canaria_Canary_Islands.html",
            "https://www.tripadvisor.es/Hotel_Review-g230095-d238903-Reviews-Seaside_Palm_Beach-Maspalomas_Gran_Canaria_Canary_Islands.html",
            "https://www.tripadvisor.es/Hotel_Review-g1177808-d12675467-Reviews-Sol_Mogan_Suites-Mogan_Gran_Canaria_Canary_Islands.html"
    ));
    public static final ArrayList<String> urlsForComments = new ArrayList<>(List.of(
            "https://www.tripadvisor.es/Hotel_Review-or%s-g2089121-d241729-Reviews-Lopesan_Costa_Meloneras_Resort_Spa-Meloneras_Gran_Canaria_Canary_Islands.html#REVIEWS",
            "https://www.tripadvisor.es/Hotel_Review-g230095-d530762-Reviews-or%s-Hotel_Riu_Gran_Canaria-Maspalomas_Gran_Canaria_Canary_Islands.html#REVIEWS",
            "https://www.tripadvisor.es/Hotel_Review-g230095-d577914-Reviews-or%s-Caybeach_Meloneras-Maspalomas_Gran_Canaria_Canary_Islands.html#REVIEWS",
            "https://www.tripadvisor.es/Hotel_Review-g230095-d238903-Reviews-or%s-Seaside_Palm_Beach-Maspalomas_Gran_Canaria_Canary_Islands.html#REVIEWS",
            "https://www.tripadvisor.es/Hotel_Review-g1177808-d12675467-Reviews-or%s-Sol_Mogan_Suites-Mogan_Gran_Canaria_Canary_Islands.html#REVIEWS"
    ));
    public static final int maxPagesComments = 5;

    @Override
    public List<Info> getInfo() {
        InfoScraper scraper = new InfoScraper();
        List<Info> infos = new ArrayList<>();
        for (String url : urls) infos.add(scraper.scrapLocation(url));
        return infos;
    }

    @Override
    public List<Rating> getRatings() {
        RatingsScraper scraper = new RatingsScraper();
        List<Rating> ratings = new ArrayList<>();
        for (String url : urls) ratings.add(scraper.scrapRating(url));
        return ratings;
    }

    @Override
    public List<Service> getServices() {
        ServiceScraper scraper = new ServiceScraper();
        List<Service> services = new ArrayList<>();
        for (String url : urls) services.add(scraper.scrapService(url));
        return services;
    }

    @Override
    public List<Comment> getComments() {
        CommentsScraper scraper = new CommentsScraper();
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < urls.size(); i++)
            comments.add(scraper.scrapeComments(urls.get(i), urlsForComments.get(i), maxPagesComments));
        return comments;
    }
}