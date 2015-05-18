package model;

import junit.framework.Assert;
import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;

public class PodregionTest {

    @Test
    public void shouldRemoveMazowieckie() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();

        list.removeIf(region -> region.getWojewodztwo().equals(Podregion.Wojewodztwo.MAZOWIECKIE));

        Assert.assertFalse(list.stream().anyMatch(r -> r.getWojewodztwo().equals(Podregion.Wojewodztwo.MAZOWIECKIE)));
    }


    @Test
    public void shouldFindRegionsWithUnemploymentHigherThan10Percent() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();

        List<Podregion> highUnemployment = list.stream().filter(r -> r.getStopaBezrobocia() > 10).collect(toList());

        highUnemployment.forEach((region) -> Assert.assertTrue(region.getStopaBezrobocia() > 10));
    }

    @Test
    public void groupPodregionByWojewodztwo() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();
        Map<Podregion.Wojewodztwo, List<Podregion>> map = list.stream().collect(groupingBy(region -> region.getWojewodztwo()));

        map.get(Podregion.Wojewodztwo.ŁÓDZKIE).forEach(c -> System.out.println(c.getNazwa()));
        Assert.assertTrue(map.containsKey(Podregion.Wojewodztwo.ŁÓDZKIE));
    }


    @Test
    public void shouldPrintŁódzkieRegiony() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();
        String result = list.stream().filter(region -> region.getWojewodztwo()
                .equals(Podregion.Wojewodztwo.ŁÓDZKIE))
                .map(Podregion::getNazwa)
                .collect(joining(" i ", "Podregiony łódzkie to: ", "."));

        Assert.assertEquals("Podregiony łódzkie to: łódzki i m. Łódź i piotrkowski i sieradzki i skierniewicki.", result);
    }


    @Test
    public void shouldPrintRegionsCommaSeparated() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();
        Collector<Podregion, StringJoiner, String> devNameCollector = Collector.of(
                () -> new StringJoiner(","),
                (j, d) -> j.add((d.getNazwa())),
                (j1, j2) -> j1.merge(j2),
                StringJoiner::toString);
        String names = list.stream().collect(devNameCollector);
        Assert.assertEquals("jeleniogórski,legnicko-głogowski,wałbrzyski,wrocławski,m. Wrocław,bydgosko-toruński,grudziądzki,włocławski,bialski,chełmsko-zamojski,lubelski,puławski,gorzowski,zielonogórski,łódzki,m. Łódź,piotrkowski,sieradzki,skierniewicki,krakowski,m. Kraków,nowosądecki,oświęcimski,tarnowski,ciechanowsko-płocki,ostrołęcko-siedlecki,radomski,m.st. Warszawa,warszawski-wschodni,warszawski-zachodni,nyski,opolski,krośnieński,przemyski,rzeszowski,tarnobrzeski,białostocki,łomżyński,suwalski,gdański,słupski,starogardzki,trójmiejski,bielski,bytomski,częstochowski,gliwicki,katowicki,rybnicki,sosnowiecki,tyski,kielecki,sandomiersko-jędrzejowski,elbląski,ełcki,olsztyński,kaliski,koniński,leszczyński,pilski,poznański,m. Poznań,koszaliński,stargardzki,m. Szczecin,szczeciński",
                names);
    }

    @Test
    public void shouldReturnUniqueProvinces() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();
        List<Podregion.Wojewodztwo> provinces = list.stream().map(a -> a.getWojewodztwo()).distinct().collect(toList());
        Assert.assertEquals(provinces.size(), 16);
    }

    @Test
    public void getRegionWithLowestStopaBezrobocie() {
        List<Podregion> list = Podregion.RegionRepository.bezrobocie2014();;
        list.stream().reduce((a, b) -> a.getIloscZarejestrowanych() > b.getIloscZarejestrowanych() ? b : a).ifPresent(Podregion::getIloscZarejestrowanych);
        Assert.assertEquals(27,6, list.get(0).getIloscZarejestrowanych());
    /*            list.stream().reduce((sum, b) -> sum += b.getAge());*/
    }

    @Test
    public void countNumberOfDaysInApril2015() {
        int lengthOfApril = YearMonth.of(2015, Month.APRIL.getValue()).lengthOfMonth();
        Assert.assertEquals(30, lengthOfApril);
    }

    @Test
    public void getNextMonday() {
        ZonedDateTime today = ZonedDateTime.now();
        LocalDateTime nextMonday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).toLocalDateTime();
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