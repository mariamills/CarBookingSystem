package org.mariamills;

import org.mariamills.booking.CarBookingDao;
import org.mariamills.booking.CarBookingService;
import org.mariamills.car.CarDao;
import org.mariamills.car.CarService;
import org.mariamills.user.User;
import org.mariamills.user.UserArrayDataAccessService;
import org.mariamills.user.UserFakerDataAccessService;
import org.mariamills.user.UserService;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UserArrayDataAccessService userArrayDataAccessService = new UserArrayDataAccessService();
        UserService userService = new UserService(userArrayDataAccessService);
        CarDao carDao = new CarDao();
        CarService carService = new CarService(carDao);
        CarBookingDao carBookingDao = new CarBookingDao();
        CarBookingService carBookingService = new CarBookingService(carBookingDao, carService);

        // Was used for testing purposes
        UserFakerDataAccessService userFakerDataAccessService = new UserFakerDataAccessService();

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while(running) {

            displayMenu();

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> bookCar(userService, carBookingService, scanner);
                case "2" -> System.out.println(carBookingService.getUserBookedCars());
                case "3" -> System.out.println(carBookingService.getCarBookings());
                case "4" -> System.out.println(carBookingService.getAvailableCars());
                case "5" -> System.out.println(carBookingService.getAvailableElectricCars());
                case "6" -> System.out.println(userService.getUsers());
                case "7" -> cancelBooking(carBookingService,scanner);
                case "8" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println(input + "is not a valid option ❌");
            }
        }
    }

    private static void bookCar(UserService userService, CarBookingService carBookingService, Scanner scanner) {
        displayAvailableCars(carBookingService);

        System.out.println("➡️ Enter the car Reg Number you would like to book:");
        String regNumber = scanner.nextLine();

        displayAllUsers(userService);

        System.out.println("➡️ Enter the user ID you would like to book the car for:");
        String userId = scanner.nextLine();

        try {
            User user = userService.getUserById(UUID.fromString(userId));
            if(user == null) {
                System.out.println("User not found ❌");
            } else {
                UUID bookingID = carBookingService.bookCar(user, regNumber);
                String confirmationMessage = String.format("🎉 Successfully book car with Reg Number %s for user %s with booking ID %s", regNumber, user.getName(), bookingID);
                System.out.println(confirmationMessage);
            }
        } catch (Exception e) {
            System.out.println("Invalid UUID ❌");
        }
    }

    private static void cancelBooking(CarBookingService carBookingService, Scanner scanner) {
        displayAllBookings(carBookingService);

        System.out.println("➡️ Enter the booking ID you would like to cancel:");
        String bookingId = scanner.nextLine();

        try {
            if(carBookingService.cancelBooking(UUID.fromString(bookingId))) {
                System.out.println("✅ Successfully cancelled booking with ID " + bookingId);
            } else {
                System.out.println("Booking not found ❌");
            }
        } catch (Exception e) {
            System.out.println("Invalid UUID ❌");
        }
    }

    private static void displayAllUsers(UserService userService) {
        if(userService.getUsers().isEmpty()) {
            System.out.println("No users found ❌");
        } else {
            System.out.println("➡️ All Users:");
            System.out.println(userService.getUsers());
        }
    }

    private static void displayAllBookings(CarBookingService carBookingService) {
        System.out.println("All Bookings:");
        System.out.println(carBookingService.getCarBookings());
    }

    private static void displayAvailableCars(CarBookingService carBookingService) {
        System.out.println("Available Cars:");
        System.out.println(carBookingService.getAvailableCars());
    }

    private static void displayMenu() {
        System.out.println("Hello! What would you like to do?");

        System.out.println("1️⃣ - Book Car");
        System.out.println("2️⃣ - View All User Booked Cars");
        System.out.println("3️⃣ - View All Bookings");
        System.out.println("4️⃣ - View Available Cars");
        System.out.println("5️⃣ - View Available Electric Cars");
        System.out.println("6️⃣ - View all users");
        System.out.println("7️⃣ - Cancel Booking");
        System.out.println("8️⃣ - Exit");
    }
}