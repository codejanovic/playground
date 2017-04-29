package io.github.codejanovic.playground;

public interface BinaryConsumer<T> extends AcceptableConsumer<T> {
    default BinaryConsumer<T> or(AcceptableConsumer<T> other) {
        return c -> mayAccept(c) || other.mayAccept(c);
    }

    default BinaryConsumer<T> and(AcceptableConsumer<T> other) {
        return c -> mayAccept(c) && other.mayAccept(c);
    }
}
