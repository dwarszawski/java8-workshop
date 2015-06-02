package lambdas;

import model.Region;

import java.util.List;

@FunctionalInterface
public interface UnemploymentQuery {
    public List<Region> execute();
}

