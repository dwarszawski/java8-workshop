package model;

import junit.framework.Assert;
import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class TimeApiTest {

    @Test
    public void getNewYorkTime() {
        ZonedDateTime time =
                ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(time);
    }

    @Test
    public void numberOfDaysBetweenTwoDates() {
        LocalDate startDate = LocalDate.now().minusDays(10);
        LocalDate endDate = LocalDate.now();

        long days = Period.between(startDate, endDate).getDays();

        Assert.assertEquals(10, days);
    }


    @Test
    public void countNumberOfDaysInApril2015() {

        int lengthOfApril =
                YearMonth.of(2015, Month.APRIL.getValue())
                        .lengthOfMonth();

        Assert.assertEquals(30, lengthOfApril);
    }

    @Test
    public void getNextThursday() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextThrusday =
                now.with(
                        TemporalAdjusters.
                                nextOrSame(DayOfWeek.THURSDAY));

        Assert.assertEquals(nextThrusday.getDayOfWeek(), DayOfWeek.THURSDAY);
    }

    @Test
    public void countNumberOfSundaysInJune2015() {
        //FIXME
    }
}
