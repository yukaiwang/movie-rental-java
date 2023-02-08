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

    double calculatePrice() {
        double price = 0;

        //determine amounts for rental line
        return switch (movie.getType()) {
            case REGULAR -> {
                price += 2;
                if (daysRented > 2)
                    price += (daysRented - 2) * 1.5;
                yield price;
            }
            case NEW_RELEASE -> {

                price += daysRented * 3;
                yield price;
            }
            case CHILDRENS -> {
                price += 1.5;
                if (daysRented > 3)
                    price += (daysRented - 3) * 1.5;
             yield price;
            }

        };
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
