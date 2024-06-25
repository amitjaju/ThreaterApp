package org.example.moviebooking.model;

import java.util.List;

public class Ticket {
    private List<Seat> bookedSeats;
    private double subtotal;
    private double serviceTax;
    private double swachhBharatCess;
    private double krishiKalyanCess;
    private double total;

    public Ticket(List<Seat> bookedSeats, double subtotal, double serviceTax, double swachhBharatCess, double krishiKalyanCess, double total) {
        this.bookedSeats = bookedSeats;
        this.subtotal = subtotal;
        this.serviceTax = serviceTax;
        this.swachhBharatCess = swachhBharatCess;
        this.krishiKalyanCess = krishiKalyanCess;
        this.total = total;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getServiceTax() {
        return serviceTax;
    }

    public double getSwachhBharatCess() {
        return swachhBharatCess;
    }

    public double getKrishiKalyanCess() {
        return krishiKalyanCess;
    }

    public double getTotal() {
        return total;
    }

    public String[] getSeatCodes() {
        return bookedSeats.stream().map(Seat::getSeatCode).toArray(String[]::new);
    }
}
