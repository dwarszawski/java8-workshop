package model;

import junit.framework.Assert;
import org.junit.Test;

import java.time.*;
import java.util.Calendar;

public class TimeApiTest {

    @Test
    public void getNewYorkTime() {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println(time);
    }

    @Test
    public void numberOfDaysBetweenTwoDates() {
        LocalDate startDate = LocalDate.now().minusDays(10);
        LocalDate endDate = LocalDate.now();

        long days = Period.between(startDate, endDate).getDays();

        Assert.assertEquals(4, days);
    }


    @Test
    public void countNumberOfDaysInApril2015() {
        int lengthOfApril = 0;

        //FIXME

        Assert.assertEquals(30, lengthOfApril);
    }

    @Test
    public void getNextMonday() {
        LocalDateTime nextMonday = LocalDateTime.now();

        //FIXME

        Assert.assertEquals(nextMonday.getDayOfWeek(), DayOfWeek.MONDAY);
    }

    @Test
    public void countNumberOfSundaysInJune2015() {
        Calendar c = Calendar.getInstance();
        int maxDaysInMonth = c.getMaximum(Calendar.DAY_OF_MONTH);
        int firstSunday = c.get(Calendar.SUNDAY);

        int sundays = 0;
        int i = firstSunday;
        ;
        while (i < maxDaysInMonth) {
            sundays++;
            i += 7;
        };
        System.out.println(sundays);
    }
}
