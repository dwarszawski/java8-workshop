package model;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RegionTest {

    @Test
    public void shouldRemoveMazowieckie() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();

        //FIXME

        Assert.assertFalse(list.stream().anyMatch(r -> r.getWojewodztwo().equals(Region.Wojewodztwo.MAZOWIECKIE)));
    }


    @Test
    public void shouldFindRegionsWithUnemploymentHigherThan10Percent() {
        List<Region> result = Region.RegionRepository.bezrobocie2014();

        //FIXME

        result.forEach((region) -> Assert.assertTrue(region.getStopaBezrobocia() > 10));
    }

    @Test
    public void groupPodregionByWojewodztwo() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        Map<Region.Wojewodztwo, Region> map = Collections.emptyMap();

        //FIXME

        Assert.assertTrue(map.containsKey(Region.Wojewodztwo.ŁÓDZKIE));
    }


    @Test
    public void shouldPrintŁódzkieRegiony() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        String result = "";

        //FIXME

        Assert.assertEquals("Podregiony łódzkie to: łódzki i m. Łódź i piotrkowski i sieradzki i skierniewicki.", result);
    }


    @Test
    public void shouldPrintRegionsCommaSeparated() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        String names = "";

        //FIXME

        Assert.assertEquals("jeleniogórski,legnicko-głogowski,wałbrzyski,wrocławski,m. Wrocław,bydgosko-toruński,grudziądzki,włocławski,bialski,chełmsko-zamojski,lubelski,puławski,gorzowski,zielonogórski,łódzki,m. Łódź,piotrkowski,sieradzki,skierniewicki,krakowski,m. Kraków,nowosądecki,oświęcimski,tarnowski,ciechanowsko-płocki,ostrołęcko-siedlecki,radomski,m.st. Warszawa,warszawski-wschodni,warszawski-zachodni,nyski,opolski,krośnieński,przemyski,rzeszowski,tarnobrzeski,białostocki,łomżyński,suwalski,gdański,słupski,starogardzki,trójmiejski,bielski,bytomski,częstochowski,gliwicki,katowicki,rybnicki,sosnowiecki,tyski,kielecki,sandomiersko-jędrzejowski,elbląski,ełcki,olsztyński,kaliski,koniński,leszczyński,pilski,poznański,m. Poznań,koszaliński,stargardzki,m. Szczecin,szczeciński",
                names);
    }

    @Test
    public void shouldReturnUniqueProvinces() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        List<Region.Wojewodztwo> provinces = Collections.emptyList();

        //FIXME

        Assert.assertEquals(provinces.size(), 16);
    }

    @Test
    public void getRegionWithLowestStopaBezrobocia() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        Region result = null;

        //FIXME

        Assert.assertEquals(3.2, result.getStopaBezrobocia());
    }
}