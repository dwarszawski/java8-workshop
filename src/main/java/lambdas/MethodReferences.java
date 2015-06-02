package lambdas;

public class MethodReferences {
    private static Integer op1(Integer value) {
        return ++value;
    }
    private Integer op2(Integer value) {
        return ++value;
    }

    SequenceLike<Integer> nextInt1 =  i -> MethodReferences.op1(i);
    SequenceLike<Integer> nextInt2 = MethodReferences::op1;
    SequenceLike<Integer> nextInt3 = this::op2;
    SequenceLike<Integer> nextInt4 = i -> {
        return op1(i);
    };
}
