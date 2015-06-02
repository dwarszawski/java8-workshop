package lambdas;

import model.Region;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class QueryExecutorTest {
    @Test
    public void shouldRunQuery() {
        QueryExecutor executor = new QueryExecutor();

        List<Region> regions = Region.RegionRepository.bezrobocie2014();
        executor.run(() -> regions.stream()
                .filter(r -> r.getIloscZarejestrowanych() > 48)
                .collect(toList()));
    }
}