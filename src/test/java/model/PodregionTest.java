package model;

import junit.framework.Assert;
import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PodregionTest {

    @Test
    public void shouldRemoveMazowieckie() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();
        Assert.assertFalse(list.stream().anyMatch(r -> r.getWojewodztwo().equals(Podregion.Wojewodztwo.MAZOWIECKIE)));
    }


    @Test
    public void shouldFindRegionsWithUnemploymentHigherThan10Percent() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();
        list.forEach((region) -> Assert.assertTrue(region.getStopaBezrobocia() > 10));
    }

    @Test
    public void groupPodregionByWojewodztwo() {
        Map<Podregion.Wojewodztwo, List<Podregion>> map = new HashMap<>();
        Assert.assertTrue(map.containsKey(Podregion.Wojewodztwo.ŁÓDZKIE));
    }


    @Test
    public void shouldPrintŁódzkieRegiony() {
        String result = "";
        Assert.assertEquals("Podregiony łódzkie to: łódzki i m. Łódź i piotrkowski i sieradzki i skierniewicki.", result);
    }


    @Test
    public void shouldPrintRegionsCommaSeparated() {
        String names = "";
        Assert.assertEquals("jeleniogórski,legnicko-głogowski,wałbrzyski,wrocławski,m. Wrocław,bydgosko-toruński,grudziądzki,włocławski,bialski,chełmsko-zamojski,lubelski,puławski,gorzowski,zielonogórski,łódzki,m. Łódź,piotrkowski,sieradzki,skierniewicki,krakowski,m. Kraków,nowosądecki,oświęcimski,tarnowski,ciechanowsko-płocki,ostrołęcko-siedlecki,radomski,m.st. Warszawa,warszawski-wschodni,warszawski-zachodni,nyski,opolski,krośnieński,przemyski,rzeszowski,tarnobrzeski,białostocki,łomżyński,suwalski,gdański,słupski,starogardzki,trójmiejski,bielski,bytomski,częstochowski,gliwicki,katowicki,rybnicki,sosnowiecki,tyski,kielecki,sandomiersko-jędrzejowski,elbląski,ełcki,olsztyński,kaliski,koniński,leszczyński,pilski,poznański,m. Poznań,koszaliński,stargardzki,m. Szczecin,szczeciński",
                names);
    }

    @Test
    public void shouldReturnUniqueProvinces() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();
        Assert.assertEquals(list.size(), 16);
    }

    @Test
    public void getRegionWithLowestStopaBezrobocie() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();;
        Assert.assertEquals(27,6, list.get(0).getIloscZarejestrowanych());
    }

    @Test
    public void countNumberOfDaysInApril2015() {
        int lengthOfApril = 0;
        Assert.assertEquals(30, lengthOfApril);
    }

    @Test
    public void getNextMonday() {
        LocalDateTime nextMonday = LocalDateTime.now();
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