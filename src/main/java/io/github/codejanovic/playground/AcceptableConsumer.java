package io.github.codejanovic.playground;

import java.util.function.Consumer;

public interface AcceptableConsumer<T> extends Consumer<T> {
    boolean mayAccept(T t);

    @Override
    default void accept(T t) {
        mayAccept(t);
    }

    default boolean accepted() {
        return true;
    }
}
