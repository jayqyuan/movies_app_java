package site.jayqyuan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// purpose of a controller is just to get a request form the user and returning a response
@RestController //indicate this class is a REST API controller
@RequestMapping("/api/v1/movies") //Maps all requests starting with "/api/v1/movies"
public class MovieController {
    //handle GET requests
    @Autowired
    private MovieService movieService;
    //GetMapping Maps HTTP Get requests
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

}
