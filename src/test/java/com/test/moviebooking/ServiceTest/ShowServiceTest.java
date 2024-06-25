package com.test.moviebooking.ServiceTest;

import org.example.moviebooking.Services.ShowService;
import org.example.moviebooking.model.Seat;
import org.example.moviebooking.model.Show;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShowServiceTest {

    @Test
    public void testDisplayAvailableSeats() {
        // Create seats for a show
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("A1", "Platinum"));
        seats.add(new Seat("A2", "Platinum"));
        seats.add(new Seat("B1", "Gold"));
        seats.add(new Seat("B2", "Gold"));
        seats.add(new Seat("C1", "Silver"));
        seats.add(new Seat("C2", "Silver"));

        // Create show and add seats to the show
        Show show = new Show(1, "Audi 1");  // Use an integer for the show ID
        for (Seat seat : seats) {
            show.addSeat(seat);  // Add each seat to the show
        }

        // Mark some seats as booked
        seats.get(0).book();
        seats.get(3).book();

        // Create ShowService and display available seats
        ShowService showService = new ShowService();
        showService.displayAvailableSeats(show);
    }
}
