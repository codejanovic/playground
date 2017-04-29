package io.github.codejanovic.playground;

import org.junit.Test;

import java.util.function.Consumer;

public class WhenConsumerConsumerTest {

    @Test
    public <T> void test() {
        consume(new FluentConsumer<String>() {
            @Override
            public boolean mayAccept(String s) {
                System.out.println("try do this: " + s);
                return accepted();
            }
        }.only().when(s -> !s.isEmpty()).and(new AcceptableConsumer<String>() {
            @Override
            public boolean mayAccept(String s) {
                System.out.println("AND try do this: " + s);
                return accepted();
            }
        })
                .or(new AcceptableConsumer<String>() {
            @Override
            public boolean mayAccept(String s) {
                System.out.println("or else do this: " + s);
                return accepted();
            }
        }));

    }

    @Test
    public void testFluent() {
        consume(Builder.may(Builder.doThis((String s) -> System.out.println("try do this: " + s)))
                .only().when((String s) -> !s.isEmpty())
                .and(Builder.doThis((String s) -> System.out.println("AND try do this: " + s)))
                .or(Builder.elseDoThis((String s) -> System.out.println("or else do this: " + s))));
    }

    private void consume(Consumer<String> consumer) {
        consumer.accept("test");
        consumer.accept("t");
        consumer.accept("");
    }

}