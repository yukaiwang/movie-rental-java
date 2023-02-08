package movierental;

public class RegularMovie extends Movie {
  public RegularMovie(String title) {
    super(title);
  }

  @Override
  double calculatePrice(int daysRented) {
    if (daysRented > 2) {
      return 2 + (daysRented - 2) * 1.5;
    }
    return 2;
  }
}
