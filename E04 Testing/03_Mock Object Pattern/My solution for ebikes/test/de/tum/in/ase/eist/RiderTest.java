package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RiderTest {

	/*
     * @formatter:off
     *
     * Helpful methods from java.time:
     *
     * Creating new LocalDateTime objects:
     * - LocalDateTime.now()
     * - LocalDateTime.of(year, month, day, hour, minute)
     * - someDateTime.plusYears(years)
     * - someDateTime.plusSeconds(seconds)
     *
     * Getting the time span between two dates:
     * - Duration.between(from, to).getSeconds()
     *
     * Comparing two LocalDateTime objects
     * - dateTimeOne.isBefore(dateTimeTwo)
     * - dateTimeOne.isAfter(dateTimeTwo)
     *
     * @formatter:on
     */

	// TODO implement the 2 tests here
    @Test
    public void testRent() {
        DriversLicense license = new DriversLicense(LocalDateTime.now().plusYears(2), "Happy");
        Rider rider  = new Rider("Lucky", 22, true, license);
        PEV pev = new EMoped(2, "MUC2020");
        rider.setPEV(pev);
        LocalDateTime start = LocalDateTime.of(2021,7, 30, 8, 0, 0);
        LocalDateTime end = start.plusHours(3);
        rider.rent(pev, start, end);
        assertEquals(1, rider.getRentals().size());
        assertEquals(1, rider.getPEV().getRentals().size());
        assertEquals(start, rider.getRentals().get(0).getFrom());
        assertEquals(end, rider.getRentals().get(0).getTo());
    }

    @Test
    public void testIfThrowException() {
        DriversLicense license = new DriversLicense(LocalDateTime.now().plusYears(2), "Happy");
        Rider rider  = new Rider("Lucky", 22, true, license);
        PEV pev = new EMoped(2, "MUC2020");
        rider.setPEV(pev);
        Rental rent = new Rental(LocalDateTime.now(), LocalDateTime.now().plusHours(3), pev, rider);
        assertThrows(UnsupportedOperationException.class, () -> rider.getRentals().add(rent));
    }
}
