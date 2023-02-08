package movierental;

enum MovieType {
    CHILDRENS,
    NEW_RELEASE,
    REGULAR
}

public class Movie {

    private final String title;
    private final MovieType type;

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public MovieType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }


}
