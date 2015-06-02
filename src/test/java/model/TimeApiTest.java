package model;

import junit.framework.Assert;
import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class TimeApiTest {

    @Test
    public void getNewYorkTime() {
        Clock clock = Clock.system(ZoneId.of("America/New_York"));

        //FIXME

        System.out.println(clock.instant());
    }

    @Test
    public void numberOfSecondsBetweenTwoDates() {
        long seconds = 0;

        //FIXME

        Assert.assertEquals(3600, seconds);
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
    public void countNumberOfWeeksInCurrentMonth() {
        ZonedDateTime today = ZonedDateTime.now();
        ZonedDateTime firstInMonth = today.with(TemporalAdjusters.firstDayOfMonth());

        while (firstInMonth.getDayOfMonth() == today.getDayOfMonth())
            System.out.println(firstInMonth.with(TemporalAdjusters.next(firstInMonth.getDayOfWeek())));
    }

}
