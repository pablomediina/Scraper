package org.example;

public class Main {
    public static void main(String[] args) {
        // names available: [lopesan, riu, caybeach, seaside, solmogan]
        // http://localhost:4567/hotels/:name
        // http://localhost:4567/hotels/:name/ratings
        // http://localhost:4567/hotels/:name/services
        // http://localhost:4567/hotels/:name/comments
        TripAdvisor tripAdvisor = new TripAdvisor();
        SparkWebService api = new SparkWebService();
        api.start(tripAdvisor.getInfo(), tripAdvisor.getRatings(), tripAdvisor.getServices(), tripAdvisor.getComments());
    }
}