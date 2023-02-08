package movierental;

import java.util.ArrayList;
import java.util.List;

import static movierental.MovieType.NEW_RELEASE;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : rentals) {
            double thisAmount = getAmountFor(each);

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getType() == NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";

        return result;
    }

    private static double getAmountFor(Rental rental) {
        double amount = 0;

        //determine amounts for rental line
        return switch (rental.getMovie().getType()) {
            case REGULAR -> {
                amount += 2;
                if (rental.getDaysRented() > 2)
                    amount += (rental.getDaysRented() - 2) * 1.5;
                yield amount;
            }
            case NEW_RELEASE -> {

                amount += rental.getDaysRented() * 3;
                yield amount;
            }
            case CHILDRENS -> {
                amount += 1.5;
                if (rental.getDaysRented() > 3)
                    amount += (rental.getDaysRented() - 3) * 1.5;
             yield amount;
            }

        };
    }
}
