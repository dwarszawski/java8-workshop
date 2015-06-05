package model;

import junit.framework.Assert;
import org.junit.Test;

import java.time.*;

public class TimeApiTest {

    @Test
    public void getNewYorkTime() {
        //FIXME
        Assert.fail();
    }

    @Test
    public void numberOfDaysBetweenTwoDates() {
        LocalDate startDate = LocalDate.now().minusDays(10);
        LocalDate endDate = LocalDate.now();

        //FIXME
        long days = 0;

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
        //FIXME
        Assert.fail();
    }
}
