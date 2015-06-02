package lambdas;

@FunctionalInterface
public interface SequenceLike<T> {
   public T next(T value);
}
