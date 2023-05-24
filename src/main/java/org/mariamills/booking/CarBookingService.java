package org.mariamills.booking;

import org.mariamills.car.Car;
import org.mariamills.car.CarService;
import org.mariamills.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CarBookingService {
    private final CarBookingDao carBookingDao;
    private final CarService carService;

    public CarBookingService(CarBookingDao carBookingDaoDaoDao, CarService carService) {
        this.carBookingDao = carBookingDaoDaoDao;
        this.carService = carService;
    }

    public UUID bookCar(User user, String regNumber) {
        Car car = carService.getCar(regNumber);
        if(user == null) {
            throw new NullPointerException("❌ User does not exist");
        }

        if(car == null) {
            throw new NullPointerException("❌ Car does not exist");
        }

        UUID bookingId = UUID.randomUUID();
        car.setAvailable(false);
        carBookingDao.book(new CarBooking(bookingId, user, car, LocalDateTime.now()));
        return bookingId;
    }

    public boolean cancelBooking(UUID bookingId) {
        CarBooking carBooking = getCarBooking(bookingId);
        if(carBooking == null) {
            throw new NullPointerException("❌ Booking does not exist");
        }
        carBooking.getCar().setAvailable(true);
        carBookingDao.cancel(carBooking);
        return true;
    }

    public CarBooking getCarBooking(UUID bookingId) {
        return carBookingDao.getCarBookings().stream()
                .filter(carBooking -> carBooking.getBookingId().equals(bookingId))
                .findFirst()
                .orElse(null);
    }

    public List<Car> getAvailableCars() {
        return carService.getAllCars();
    }

    public List<Car> getAvailableElectricCars() {
        return carService.getAllElectricCars();
    }

    public List<Car> getAvailableNonElectricCars() {
        return carService.getAllCars().stream().filter(car -> !car.isElectric()).toList();
    }

    public List<Car> getUserBookedCars() {
        return carService.getAllCars().stream().filter(car -> !car.isAvailable()).toList();
    }

    public List<CarBooking> getCarBookings() {
        return carBookingDao.getCarBookings();
    }
}
