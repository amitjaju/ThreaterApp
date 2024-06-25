package com.test.moviebooking.model;


import org.example.moviebooking.model.Seat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeatTest {

    @Test
    public void testSeatBooking() {
        Seat seat = new Seat("A1", "Platinum");

        // Check initial state
        assertFalse(seat.isBooked());

        // Book the seat
        seat.book();

        // Check state after booking
        assertTrue(seat.isBooked());
    }

    @Test
    public void testSeatDetails() {
        Seat seat = new Seat("B2", "Gold");

        // Check seat details
        assertEquals("B2", seat.getSeatCode());
        assertEquals("Gold", seat.getCategory());
    }
}
