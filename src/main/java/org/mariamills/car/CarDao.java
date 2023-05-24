package org.mariamills.car;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CarDao {

    private static final List<Car> CARS = Arrays.asList(
            new Car("ABC123", new BigDecimal("89.00"), Brand.TOYOTA, true, true),
            new Car("DEF456", new BigDecimal("100.00"), Brand.BMW, false, true),
            new Car("GHI789", new BigDecimal("120.00"), Brand.MERCEDES, false, true),
            new Car("JKL012", new BigDecimal("150.00"), Brand.JEEP, true, true),
            new Car("MNO345", new BigDecimal("200.00"), Brand.BMW, false, true),
            new Car("PQR678", new BigDecimal("250.00"), Brand.FERRARI, false, true),
            new Car("STU901", new BigDecimal("300.00"), Brand.DODGE, true, true),
            new Car("VWX234", new BigDecimal("350.00"), Brand.BMW, false, true),
            new Car("YZA567", new BigDecimal("400.00"), Brand.LEXUS, false, true),
            new Car("BCD890", new BigDecimal("450.00"), Brand.LAMBORGHINI, true, true)
    );
    public List<Car> getCars() {
        return CARS;
    }
}
