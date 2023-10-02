package study.java8to11.functionalInterface;

import java.util.function.Function;

public class Function1 implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
