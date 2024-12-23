package site.jayqyuan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    //MongoTemplate dependency is a more flexible way to interact with mongoDB compared to repository
    @Autowired
    private MongoTemplate mongoTemplate;
    //locate the movie with imdbId to and use the reviewBody to create review for the movie
    public Review createReview(String reviewBody, String imdbId){
        //step 1 create review with given reviewBody and insert into the review collection
        Review review = repository.insert(new Review(reviewBody));

        //step 3: use MongoTemplate to locate movie and associate the review with it
        mongoTemplate.update(Movie.class)// specify the entity type we will be updating (Movie class)
                .matching( //define criteria for selecting the movie to update.
                        Criteria.where("imdbId").is(imdbId) // locate movie by the imdbId
                )
                .apply(new Update().push("reviewIds").value(review.getId())) //add the review's ID to the movie's reviewIDs array field
                .first(); //apply update to the first matching document (or only one in this case)

        //return the created Review object for further use or confirmation
        return review;
    }
}
