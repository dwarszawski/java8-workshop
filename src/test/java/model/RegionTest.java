package model;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RegionTest {

    @Test
    public void shouldRemoveMazowieckie() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();

        list.removeIf(region -> region.getWojewodztwo().equals(Region.Wojewodztwo.MAZOWIECKIE));

        Assert.assertFalse(list.stream().anyMatch(r -> r.getWojewodztwo().equals(Region.Wojewodztwo.MAZOWIECKIE)));
    }


    @Test
    public void shouldFindRegionsWithUnemploymentHigherThan10Percent() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();

        List<Region> result = list.stream().filter(r -> r.getStopaBezrobocia() > 10).collect(Collectors.toList());

        result.forEach((region) -> Assert.assertTrue(region.getStopaBezrobocia() > 10));
    }

    @Test
    public void groupPodregionByWojewodztwo() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();

        Map<Region.Wojewodztwo, List<Region>> map = list.stream().collect(Collectors.groupingBy(region -> region.getWojewodztwo()));

        Assert.assertTrue(map.containsKey(Region.Wojewodztwo.ŁÓDZKIE));
    }


    @Test
    public void shouldPrintŁódzkieRegiony() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        String result = list.stream().filter(region -> region.getWojewodztwo()
                .equals(Region.Wojewodztwo.ŁÓDZKIE))
                .map(Region::getNazwa)
                .collect(Collectors.joining(" i ", "Podregiony łódzkie to: ", "."));


        Assert.assertEquals("Podregiony łódzkie to: łódzki i m. Łódź i piotrkowski i sieradzki i skierniewicki.", result);
    }


    @Test
    public void shouldPrintRegionsCommaSeparated() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();

        Collector<Region, StringJoiner, String> regionCollector = Collector.of(
                () -> new StringJoiner(","),
                (j, d) -> j.add((d.getNazwa())),
                (j1, j2) -> j1.merge(j2),
                StringJoiner::toString);

        String names = list.stream().collect(regionCollector);

        Assert.assertEquals("jeleniogórski,legnicko-głogowski,wałbrzyski,wrocławski,m. Wrocław,bydgosko-toruński,grudziądzki,włocławski,bialski,chełmsko-zamojski,lubelski,puławski,gorzowski,zielonogórski,łódzki,m. Łódź,piotrkowski,sieradzki,skierniewicki,krakowski,m. Kraków,nowosądecki,oświęcimski,tarnowski,ciechanowsko-płocki,ostrołęcko-siedlecki,radomski,m.st. Warszawa,warszawski-wschodni,warszawski-zachodni,nyski,opolski,krośnieński,przemyski,rzeszowski,tarnobrzeski,białostocki,łomżyński,suwalski,gdański,słupski,starogardzki,trójmiejski,bielski,bytomski,częstochowski,gliwicki,katowicki,rybnicki,sosnowiecki,tyski,kielecki,sandomiersko-jędrzejowski,elbląski,ełcki,olsztyński,kaliski,koniński,leszczyński,pilski,poznański,m. Poznań,koszaliński,stargardzki,m. Szczecin,szczeciński",
                names);
    }

    @Test
    public void shouldReturnUniqueProvinces() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();

        List<Region.Wojewodztwo> provinces = list.stream().map(a -> a.getWojewodztwo()).distinct().collect(Collectors.toList());

        Assert.assertEquals(provinces.size(), 16);
    }

    @Test
    public void getRegionWithLowestStopaBezrobocia() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();

        Region result = list.stream().reduce((a, b) -> a.getStopaBezrobocia() > b.getStopaBezrobocia() ? b : a).get();

        Assert.assertEquals(3.2, result.getStopaBezrobocia());
    }
}
