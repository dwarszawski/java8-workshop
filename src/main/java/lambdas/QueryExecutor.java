package lambdas;

import model.Podregion;

import java.util.List;

public class QueryExecutor{
    List<Podregion> podregions = Podregion.RegionRepository.bezrobocie2014();

    public void run(UnemploymentQuery query){
        query.execute().forEach(region -> System.out.println(region.getNazwa()));
    }
}
