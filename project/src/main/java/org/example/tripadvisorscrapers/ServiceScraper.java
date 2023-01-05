package org.example.tripadvisorscrapers;

import org.example.model.Hotel;
import org.example.model.Service;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Objects;

import static org.example.ConnectionHTML.*;
import static org.example.tripadvisorscrapers.NameScraper.scrapName;

public class ServiceScraper {

    public Service scrapService(String url) {
        ArrayList<String> propertyServices = new ArrayList<>();
        ArrayList<String> roomServices = new ArrayList<>();
        ArrayList<String> roomTypes = new ArrayList<>();
        int i = 0;
        String urlPage = String.format(url);

        if (getStatusConnectionCode(urlPage) == 200) {
            Document document = getHtmlDocument(urlPage);
            Elements entradas = document.select("div.OsCbb.K");
            for (Element entrada : Objects.requireNonNull(entradas)) {
                String review = entrada.text();
                if (i == 0) propertyServices.add(review);
                if (i == 1) roomServices.add(review);
                if (i == 2) roomTypes.add(review);
                i++;
            }
            return new Service(new Hotel(scrapName(url)), new Hotel.HotelService(propertyServices, roomServices, roomTypes));
        } else {
            System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(urlPage));
            return null;
        }
    }
}