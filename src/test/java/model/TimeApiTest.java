package model;

import junit.framework.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeApiTest {

    @Test
    public void getNewYorkTime() {
        Assert.fail();
    }

    @Test
    public void numberOfDaysBetweenTwoDates() {
        LocalDate startDate = LocalDate.now().minusDays(10);
        LocalDate endDate = LocalDate.now();

        long days = 0; //FIXME

        Assert.assertEquals(10, days);
    }


    @Test
    public void countNumberOfDaysInApril2015() {

        int lengthOfApril = 0; //FIXME

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
        //FIXME
    }
}
