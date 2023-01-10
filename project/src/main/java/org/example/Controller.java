package org.example;

public class Controller {
    public void run() {
        TripAdvisorScraper tripAdvisorScraper = new TripAdvisorScraper();
        SparkWebService api = new SparkWebService();
        api.start(tripAdvisorScraper.getInfo(), tripAdvisorScraper.getRatings(), tripAdvisorScraper.getServices(), tripAdvisorScraper.getComments());
    }
}
