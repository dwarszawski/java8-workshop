package lambdas;

public class MethodReferences {
    private static Integer op1(Integer value) {
        return ++value;
    }

    private Integer op2(Integer value) {
        return ++value;
    }

    MethodReferences instance = new MethodReferences();

    SequenceLike<Integer> nextInt1 = MethodReferences::op1;
    SequenceLike<Integer> nextInt2 = instance::op2;
    SequenceLike<Integer> nextInt3 = this::op2;
    SequenceLike<Integer> nextInt4 = i -> {
        return op1(i);
    };
}
