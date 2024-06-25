package org.example.moviebooking.model;

public class Seat {
    private String seatCode;
    private String category;
    private boolean booked;

    public Seat(String seatCode, String category) {
        this.seatCode = seatCode;
        this.category = category;
        this.booked = false;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }

    public double getPrice() {
        switch (category) {
            case "Platinum":
                return 300.0;
            case "Gold":
                return 200.0;
            case "Silver":
                return 100.0;
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}
