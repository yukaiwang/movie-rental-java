package movierental;

public abstract class Movie {

    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    abstract double calculatePrice(int daysRented);

    int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
