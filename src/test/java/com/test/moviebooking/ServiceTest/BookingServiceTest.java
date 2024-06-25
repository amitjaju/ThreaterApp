package com.test.moviebooking.ServiceTest;

import org.example.moviebooking.Services.BookingService;
import org.example.moviebooking.model.Seat;
import org.example.moviebooking.model.Show;
import org.example.moviebooking.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceTest {

    @Test
    public void testBookTickets() {
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("A1", "Platinum"));
        seats.add(new Seat("A2", "Platinum"));
        seats.add(new Seat("B1", "Gold"));
        seats.add(new Seat("B2", "Gold"));
        seats.add(new Seat("C1", "Silver"));
        seats.add(new Seat("C2", "Silver"));

        // Create show and add seats to the show
        Show show = new Show(1, "Audi 1");
        for (Seat seat : seats) {
            show.addSeat(seat);
        }

        // Create BookingService and book tickets
        BookingService bookingService = new BookingService();
        Ticket ticket = bookingService.bookTickets(show, new String[]{"A1", "B1", "C1"});

        // Check if tickets are booked
        assertArrayEquals(new String[]{"A1", "B1", "C1"}, ticket.getSeatCodes());
        assertTrue(show.getSeats().get(0).isBooked());
        assertTrue(show.getSeats().get(2).isBooked());
        assertTrue(show.getSeats().get(4).isBooked());

        // Check subtotal, taxes, and total
        assertEquals(600.0, ticket.getSubtotal(), 0.001);
        assertEquals(84.0, ticket.getServiceTax(), 0.001);
        assertEquals(3.0, ticket.getSwachhBharatCess(), 0.001);
        assertEquals(3.0, ticket.getKrishiKalyanCess(), 0.001);
        assertEquals(690.0, ticket.getTotal(), 0.001);
    }
}
