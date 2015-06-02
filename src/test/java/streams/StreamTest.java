package streams;

import com.beust.jcommander.internal.Lists;
import model.Region;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    @Test
    public void shouldFilterAndSortList() {
        List<Region> regions = Region.RegionRepository.bezrobocie2014();
        List<Region> result = Lists.newArrayList();
        for (Region r : regions) {
            if (r.getIloscZarejestrowanych() < 20) {
                result.add(r);
            }
        }
        Collections.sort(result, Region.comparator);
    }

    @Test
    public void shouldFilterAndSortListUsingLambda() {
        List<Region> regions = Region.RegionRepository.bezrobocie2014()
                .stream()
                .filter(r -> r.getIloscZarejestrowanych() < 20)
                .sorted(Region.comparator)
                .collect(Collectors.toList());
    }
}
