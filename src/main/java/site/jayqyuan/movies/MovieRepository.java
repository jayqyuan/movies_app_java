package site.jayqyuan.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//Repository layer is the data access, it does the job of actually talking to the database
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //MongoRepository provides basic CRUD functionalities so no additional methods are needed
}
