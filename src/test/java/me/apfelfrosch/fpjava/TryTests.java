package me.apfelfrosch.fpjava;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TryTests {

    @Test
    public void testTry() {
        Runnable throwsException = () -> "".charAt(0);
        assertDoesNotThrow(() -> Try.runIgnoreExceptions(throwsException));
        AtomicInteger i = new AtomicInteger(0);
        Try.build(throwsException)
                .catchException(StringIndexOutOfBoundsException.class, e -> i.set(1))
                .run();
        assertEquals(i.get(), 1);

        Try.build(throwsException)
                .catchException(NullPointerException.class, e -> i.set(1))
                .catchAll(e -> i.set(2))
                .run();
        assertEquals(i.get(), 2);

        var res = Try.run(() -> "".charAt(0));
        assertTrue(res.isRight());
        res.ifRight(e -> assertInstanceOf(StringIndexOutOfBoundsException.class, e));

        res = Try.run(() -> "a".charAt(0));
        assertTrue(res.isLeft());
        res.ifLeft(c -> assertEquals('a', c));
    }

}
