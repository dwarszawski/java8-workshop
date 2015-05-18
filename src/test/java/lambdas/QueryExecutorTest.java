package lambdas;

import model.Podregion;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class QueryExecutorTest{
    @Test
    public void shouldRunQuery() {

        QueryExecutor executor = new QueryExecutor();

        //you can make this with anonymous class
        executor.run(new UnemploymentQuery() {
            @Override
            public List<Podregion> execute() {
                return executor.podregions.stream()
                        .filter(r -> r.getIloscZarejestrowanych() > 48)
                        .collect(toList());
            }
        });

        System.out.println("*****************************************");
        //or by lambda expression
        executor.run(() ->executor.podregions.stream()
                .filter(r -> r.getIloscZarejestrowanych() > 48)
                .collect(toList()));

    }
}