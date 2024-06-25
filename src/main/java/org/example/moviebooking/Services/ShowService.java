package org.example.moviebooking.Services;

import org.example.moviebooking.model.Show;
import org.example.moviebooking.model.Seat;


public class ShowService {
    public void displayAvailableSeats(Show show) {
        System.out.println("All Seats:");
        for (Seat seat : show.getSeats()) {
            String status = seat.isBooked() ? "Booked" : "Available";
            System.out.println(seat.getSeatCode() + " - " + status);
        }
    }

    public void calculateAndDisplayTotalData(Show[] shows) {
        double totalRevenue = 0;
        double totalServiceTax = 0;
        double totalSwachhBharatCess = 0;
        double totalKrishiKalyanCess = 0;

        for (Show show : shows) {
            for (Seat seat : show.getSeats()) {
                if (seat.isBooked()) {
                    double seatPrice = calculateSeatPrice(seat);
                    double serviceTax = seatPrice * BookingService.SERVICE_TAX_RATE;
                    double cess = seatPrice * BookingService.CESS_RATE;

                    totalRevenue += seatPrice;
                    totalServiceTax += serviceTax;
                    totalSwachhBharatCess += cess;
                    totalKrishiKalyanCess += cess;
                }
            }
        }

        System.out.println("Total Sales:");
        System.out.println("Revenue: Rs. " + totalRevenue);
        System.out.println("Service Tax: Rs. " + totalServiceTax);
        System.out.println("Swachh Bharat Cess: Rs. " + totalSwachhBharatCess);
        System.out.println("Krishi Kalyan Cess: Rs. " + totalKrishiKalyanCess);
    }

    private double calculateSeatPrice(Seat seat) {
        String category = seat.getCategory();
        switch (category) {
            case "Platinum":
                return 320.0;
            case "Gold":
                return 280.0;
            case "Silver":
                return 240.0;
            default:
                return 0.0;
        }
    }
}
