package movierental;

import static movierental.MovieType.NEW_RELEASE;

public class NewReleaseMovie extends Movie {
  public NewReleaseMovie(String title) {
    super(title);
  }

  @Override
  double calculatePrice(int daysRented) {
    return daysRented * 3;
  }

  @Override
  int calculateFrequentRenterPoints(int daysRented) {
    if (daysRented > 1) {
      return 1 + super.calculateFrequentRenterPoints(daysRented);
    }
    return super.calculateFrequentRenterPoints(daysRented);
  }
}
