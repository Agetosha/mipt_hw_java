package edu.phystech.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Functional {

    public static <T, R> List<R> map(List<? extends T> list, Function<? super T, ? extends R> function) {
        List<R> result = new ArrayList<>(list.size());
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static <T, R> R reduce(List<? extends T> list, BiFunction<R, ? super T, R> accumulator, R identity) {
        R result = identity;
        for (T item : list) {
            result = accumulator.apply(result, item);
        }
        return result;
    }
}