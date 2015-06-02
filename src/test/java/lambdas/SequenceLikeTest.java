package lambdas;

import junit.framework.Assert;
import org.testng.annotations.Test;

public class SequenceLikeTest {
    @Test
    public void shouldAddIntegers() {

        SequenceLike<Integer> op1 = new SequenceLike<Integer>() {
            @Override
            public Integer next(Integer value) {
                return ++value;
            }
        };

        Assert.assertEquals(3, op1.next(2).intValue());
    }
}