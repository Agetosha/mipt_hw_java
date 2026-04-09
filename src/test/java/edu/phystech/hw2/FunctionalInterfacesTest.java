package edu.phystech.hw2;

import org.junit.jupiter.api.Test;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalInterfacesTest {

    public Predicate<Integer> isPositive() {
        return x -> x > 0;
    }

    public Function<String, Integer> parser() {
        return Integer::parseInt;
    }

    public Consumer<Object> printer() {
        return System.out::println;
    }

    public Supplier<String> constantSupplier() {
        return () -> "Java";
    }

    @Test
    void testPredicate() {
        Predicate<Integer> predicate = isPositive();
        assertTrue(predicate.test(5));
        assertFalse(predicate.test(-1));
    }

    @Test
    void testFunction() {
        Function<String, Integer> function = parser();
        assertEquals(123, function.apply("123"));
    }

    @Test
    void testSupplier() {
        Supplier<String> supplier = constantSupplier();
        assertEquals("Java", supplier.get());
    }
    
    @Test
    void testConsumer() {
        Consumer<Object> consumer = printer();
        assertDoesNotThrow(() -> consumer.accept("Testing printer..."));
    }
}