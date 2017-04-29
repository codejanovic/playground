package io.github.codejanovic.playground;

import java.util.function.Predicate;

public interface WhenConsumer<T> extends AcceptableConsumer<T> {
    default BinaryConsumer<T> when(Predicate<T> condition) {
        return c -> condition.test(c) && mayAccept(c);
    }
}
