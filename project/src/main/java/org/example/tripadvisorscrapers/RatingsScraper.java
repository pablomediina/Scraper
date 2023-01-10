package org.example.tripadvisorscrapers;

import org.example.model.Hotel;
import org.example.model.Rating;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.example.ConnectionHTML.*;
import static org.example.tripadvisorscrapers.NameScraper.scrapName;

public class RatingsScraper {
    public Rating scrapRating(String url) {
        ArrayList<Hotel.HotelRating> ratings = new ArrayList<>();
        int i = 0;
        List<Double> stars = scrapeStars(url);
        Elements sections = scrapeFields(url);
        for (Element section : Objects.requireNonNull(sections)) {
            assert stars != null;
            ratings.add(new Hotel.HotelRating(inspectFields(section), stars.get(i)));
            i++;
        }
        return new Rating(new Hotel(scrapName(url)), new ArrayList<>(ratings));
    }

    private List<Double> scrapeStars(String url) {
        String urlPage = String.format(url);
        if (getStatusConnectionCode(urlPage) == 200) {
            Document document = getHtmlDocument(urlPage);
            Elements elements = document.select("span.ui_bubble_rating");
            if (!elements.isEmpty()) {
                List<Double> starsSelected = new ArrayList<>();
                List<Double> doubles = elementToDouble(elements);
                starsSelected.add(doubles.get(2));
                starsSelected.add(doubles.get(3));
                starsSelected.add(doubles.get(4));
                starsSelected.add(doubles.get(5));
                return starsSelected;
            }
        } else {
            System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(urlPage));
        }
        return null;
    }

    private Elements scrapeFields(String url) {
        String urlPage = String.format(url);
        if (getStatusConnectionCode(urlPage) == 200) {
            Document document = getHtmlDocument(urlPage);
            return document.select("div.HXCfp");
        } else {
            System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(urlPage));
            return null;
        }
    }

    private String inspectFields(Element elem) {
        return elem.getElementsByClass("hLoRK").text();
    }

    private List<Double> elementToDouble(Elements elements) {
        ArrayList<Double> doubles = new ArrayList<>();
        for (Element element : elements) {
            String string = element.toString();
            if (string.equals("<span class=\"ui_bubble_rating bubble_50\"></span>")) doubles.add(5.0);
            if (string.equals("<span class=\"ui_bubble_rating bubble_45\"></span>")) doubles.add(4.5);
            if (string.equals("<span class=\"ui_bubble_rating bubble_40\"></span>")) doubles.add(4.0);
            if (string.equals("<span class=\"ui_bubble_rating bubble_35\"></span>")) doubles.add(3.5);
            if (string.equals("<span class=\"ui_bubble_rating bubble_30\"></span>")) doubles.add(3.0);
            if (string.equals("<span class=\"ui_bubble_rating bubble_25\"></span>")) doubles.add(2.5);
            if (string.equals("<span class=\"ui_bubble_rating bubble_20\"></span>")) doubles.add(2.0);
            if (string.equals("<span class=\"ui_bubble_rating bubble_15\"></span>")) doubles.add(1.5);
            if (string.equals("<span class=\"ui_bubble_rating bubble_10\"></span>")) doubles.add(1.0);
            if (string.equals("<span class=\"ui_bubble_rating bubble_05\"></span>")) doubles.add(0.5);
            if (string.equals("<span class=\"ui_bubble_rating bubble_00\"></span>")) doubles.add(0.0);
        }
        return doubles;
    }
}