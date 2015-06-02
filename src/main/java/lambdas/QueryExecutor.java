package lambdas;

public class QueryExecutor {
    public void run(UnemploymentQuery query) {
        query.execute().forEach(
                region -> System.out.println(region.getNazwa())
        );
    }
}
