package org.example.tripadvisorscrapers;

import org.example.model.Comment;
import org.example.model.Hotel;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Objects;

import static org.example.ConnectionHTML.*;
import static org.example.tripadvisorscrapers.NameScraper.scrapName;


public class CommentsScraper {
    public Comment scrapeComments(String url, String urlComment, int maxPagesComments) {
        ArrayList<String> reviews = new ArrayList<>();
        for (int i = 5; i < (5 * maxPagesComments); i += 5) {
            Elements entries = inspectComments(urlComment, i);
            for (Element entry : Objects.requireNonNull(entries)) reviews.add(entry.text());
        }
        return new Comment(new Hotel(scrapName(url)), new Hotel.HotelComment(reviews));
    }

    private Elements inspectComments(String urlComment, int i) {
        String urlPage = String.format(urlComment, i);
        if (getStatusConnectionCode(urlPage) == 200) {
            Document document = getHtmlDocument(urlPage);
            return document.select("a.Qwuub");
        } else {
            System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(urlPage));
            return null;
        }
    }
}