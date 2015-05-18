package lambdas;

import model.Podregion;

import java.util.List;

@FunctionalInterface
public interface UnemploymentQuery {
    public List<Podregion> execute();
}

