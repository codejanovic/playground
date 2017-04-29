package io.github.codejanovic.playground;

public interface FluentConsumer<T> extends AcceptableConsumer<T> {
    default WhenConsumer<T> only() {
        return c -> { mayAccept(c); return accepted();};
    }

}
