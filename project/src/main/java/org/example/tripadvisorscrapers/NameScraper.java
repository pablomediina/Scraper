package org.example.tripadvisorscrapers;

import org.jsoup.nodes.Document;

import static org.example.ConnectionHTML.getHtmlDocument;
import static org.example.ConnectionHTML.getStatusConnectionCode;

public class NameScraper {

    public static String scrapName(String url){
        String urlPage = String.format(url);
        if (getStatusConnectionCode(urlPage) == 200) {
            Document document = getHtmlDocument(urlPage);
            return document.select("h1.QdLfr.b.d.Pn").text();
        } else{
            return "El Status Code no es OK es: " + getStatusConnectionCode(urlPage);
        }
    }
}