package movierental;

import java.util.ArrayList;
import java.util.List;

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

    public String createReceipt() {
        String receipt = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            // show figures for this rental
            receipt += "\t" + rental.getMovie().getTitle() + "\t" + rental.calculatePrice() + "\n";
        }

        // add footer lines
        receipt += "Amount owed is " + getTotalAmount() + "\n";
        receipt += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return receipt;
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::calculateFrequentRenterPoints).sum();
    }

    private double getTotalAmount() {
        return rentals.stream().mapToDouble(Rental::calculatePrice).sum();
    }

}
