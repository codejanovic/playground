package io.github.codejanovic.playground;

import java.util.function.Consumer;

public final class Builder {

    public static <T> FluentConsumer<T> may(AcceptableConsumer<T> consumer) {
        return consumer::mayAccept;
    }

    public static <T> AcceptableConsumer<T> alwaysDoThis(Consumer<T> consumer)  {
        return new AcceptableConsumer<T>() {
            @Override
            public boolean mayAccept(T t) {
                consumer.accept(t);
                return accepted();
            }
        };
    }

    public static <T> AcceptableConsumer<T> doThis(Consumer<T> consumer)  {
        return alwaysDoThis(consumer);
    }

    public static <T> AcceptableConsumer<T> elseDoThis(Consumer<T> consumer)  {
        return alwaysDoThis(consumer);
    }
}
