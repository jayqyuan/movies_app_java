package site.jayqyuan.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//The service class is where most of the business logics will go for backend
//Service class uses the repository class to talk to the database and return to the API layer
@Service
public class MovieService {
    // auto inject MovieRepository dependencies
    @Autowired
    private MovieRepository movieRepository;

    // This method retrieves all the movies from database where @return a list of all movies
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    //Optional because it could potentially return Null
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
