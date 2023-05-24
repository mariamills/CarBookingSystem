package org.mariamills.booking;

import org.mariamills.car.Car;
import org.mariamills.user.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class CarBooking {
    private UUID bookingId;
    private User user;
    private Car car;
    private LocalDateTime bookingTime;

    public CarBooking(UUID bookingId, User user, Car car, LocalDateTime bookingTime) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.bookingTime = bookingTime;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }


    @Override
    public String toString() {
        return "CarBooking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", car=" + car +
                ", bookingTime=" + bookingTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking that = (CarBooking) o;
        return Objects.equals(bookingId, that.bookingId) && Objects.equals(user, that.user) && Objects.equals(car, that.car) && Objects.equals(bookingTime, that.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, user, car, bookingTime);
    }
}
