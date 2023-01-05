package org.example.tripadvisorscrapers;

import org.example.model.Hotel;
import org.example.model.Info;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import static org.example.ConnectionHTML.*;
import static org.example.tripadvisorscrapers.NameScraper.scrapName;

public class InfoScraper {

    public Info scrapLocation(String url) {
        String urlPage = String.format(url);
        if (getStatusConnectionCode(urlPage) == 200) {
            Document document = getHtmlDocument(urlPage);
            Elements elements = document.select("span.fHvkI.PTrfg");
            if (!elements.isEmpty()) return new Info(new Hotel(scrapName(url)), new Hotel.HotelInfo(elements.get(0).text()));
            System.out.println("location not available");
        } else {
            System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(urlPage));
        }
        return null;
    }
}