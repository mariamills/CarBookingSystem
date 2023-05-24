package org.mariamills.booking;

import java.util.ArrayList;
import java.util.List;

public class CarBookingDao {
    private static final List<CarBooking> carBookings;

    static {
        carBookings = new ArrayList<CarBooking>();
    }

    public List<CarBooking> getCarBookings() {
        return carBookings;
    }

    public void book(CarBooking carBooking) {
        carBookings.add(carBooking);
    }

    public void cancel(CarBooking carBooking) {
        carBookings.remove(carBooking);
    }

}
