package org.example.moviebooking.Services;


import org.example.moviebooking.model.Seat;
import org.example.moviebooking.model.Show;
import org.example.moviebooking.model.Ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    public static final double SERVICE_TAX_RATE =0.14;
    public static final double CESS_RATE = 0.005 ;;
    private static final double SWACHH_BHARAT_CESS_RATE = 0.005;
    private static final double KRISHI_KALYAN_CESS_RATE = 0.005;

    public Ticket bookTickets(Show show, String[] seatCodes) {
        List<Seat> bookedSeats = new ArrayList<>();
        double subtotal = 0.0;

        for (String seatCode : seatCodes) {

            for (Seat seat : show.getSeats()) {
                if (seat.getSeatCode().equals(seatCode) && !seat.isBooked()) {
                    seat.book();
                    bookedSeats.add(seat);
                    subtotal += seat.getPrice();
                    break;
                }
            }
        }

        BigDecimal bdSubtotal = new BigDecimal(subtotal).setScale(2, RoundingMode.HALF_UP);
        double serviceTax = bdSubtotal.multiply(new BigDecimal(SERVICE_TAX_RATE)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double swachhBharatCess = bdSubtotal.multiply(new BigDecimal(SWACHH_BHARAT_CESS_RATE)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double krishiKalyanCess = bdSubtotal.multiply(new BigDecimal(KRISHI_KALYAN_CESS_RATE)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double total = bdSubtotal.add(new BigDecimal(serviceTax)).add(new BigDecimal(swachhBharatCess)).add(new BigDecimal(krishiKalyanCess)).setScale(2, RoundingMode.HALF_UP).doubleValue();

        return new Ticket(bookedSeats, bdSubtotal.doubleValue(), serviceTax, swachhBharatCess, krishiKalyanCess, total);
    }
}
