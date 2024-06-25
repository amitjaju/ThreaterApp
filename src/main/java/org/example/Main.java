package org.example;

import org.example.moviebooking.model.Show;
import org.example.moviebooking.model.Seat;
import org.example.moviebooking.model.Ticket;
import org.example.moviebooking.Services.BookingService;
import org.example.moviebooking.Services.ShowService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Seat seat1 = new Seat("A1", "Platinum");
        Seat seat2 = new Seat("A2", "Platinum");
        Seat seat3 = new Seat("B1", "Gold");
        Seat seat4 = new Seat("B2", "Gold");
        Seat seat5 = new Seat("C1", "Silver");
        Seat seat6 = new Seat("C2", "Silver");

        // Add seats to the show
        Show show = new Show(1, "Audi 1");
        show.addSeat(seat1);
        show.addSeat(seat2);
        show.addSeat(seat3);
        show.addSeat(seat4);
        show.addSeat(seat5);
        show.addSeat(seat6);

        ShowService showService = new ShowService();
        BookingService bookingService = new BookingService();

        System.out.println("Available shows:");
        System.out.println("1. Show 1");

        System.out.print("Enter show number to book tickets: ");
        int showNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (showNumber == 1) {
            showService.displayAvailableSeats(show);

            System.out.print("Enter seat codes to book (comma separated): ");
            String seatCodesInput = scanner.nextLine();
            String[] seatCodes = seatCodesInput.split(",");

            Ticket ticket = bookingService.bookTickets(show, seatCodes);

            System.out.println("Successfully Booked - Show 1");
            System.out.println("Subtotal: Rs. " + ticket.getSubtotal());
            System.out.println("Service Tax @14%: Rs. " + ticket.getServiceTax());
            System.out.println("Swachh Bharat Cess @0.5%: Rs. " + ticket.getSwachhBharatCess());
            System.out.println("Krishi Kalyan Cess @0.5%: Rs. " + ticket.getKrishiKalyanCess());
            System.out.println("Total: Rs. " + ticket.getTotal());

            System.out.print("Do you want to continue booking? (Yes/No): ");
            String continueBooking = scanner.nextLine();
            if (continueBooking.equalsIgnoreCase("No")) {
                System.out.println("Thank you for using our service!");
            }
        }

        scanner.close();
    }
}
