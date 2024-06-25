package org.example.moviebooking.model;


import java.util.ArrayList;
import java.util.List;

public class Show {
    private int showId;
    private String auditorium;
    private List<Seat> seats;

    public Show(int showId, String auditorium) {
        this.showId = showId;
        this.auditorium = auditorium;
        this.seats = new ArrayList<>();
    }

    public int getShowId() {
        return showId;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }
}


