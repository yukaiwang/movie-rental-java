package movierental;

import static movierental.MovieType.NEW_RELEASE;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

     public int calculateFrequentRenterPoints() {
        if ((movie.getType() == NEW_RELEASE) && daysRented > 1) {
            return 2;
        }
        return 1;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}
