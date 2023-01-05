package org.example;

import org.example.model.Comment;
import org.example.model.Info;
import org.example.model.Rating;
import org.example.model.Service;

import java.util.List;

import static spark.Spark.get;

public class SparkWebService {

    public void start(List<Info> infos, List<Rating> ratings, List<Service> services, List<Comment> comments) {
        ServiceResolver serviceResolver = new ServiceResolver();

        get("/hotels/:name", (req, res) ->
                serviceResolver.infoResolver(infos, req.params("name")));

        get("/hotels/:name/ratings", (req, res) ->
                serviceResolver.ratingResolver(ratings, req.params("name")));

        get("/hotels/:name/services", (req, res) ->
                serviceResolver.serviceResolver(services, req.params("name")));

        get("/hotels/:name/comments", (req, res) ->
                serviceResolver.commentResolver(comments, req.params("name")));
    }
}