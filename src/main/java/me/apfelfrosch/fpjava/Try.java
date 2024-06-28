package me.apfelfrosch.fpjava;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class Try {

    private Try() {}

    public static void runIgnoreExceptions(Runnable r) {
        try {
            r.run();
        } catch (Exception e) {
        }
    }

    public static <T> Either<T, Exception> run(Supplier<T> c) {
        try {
            return Either.left(c.get());
        } catch (Exception e) {
            return Either.right(e);
        }
    }

    public static Builder build(Runnable r) {
        return new Builder(r);
    }

    public static final class Builder {

        private final Runnable r;
        private final Map<Class<? extends Exception>, Consumer<? extends Exception>> handlers = new HashMap<>();
        private Optional<Consumer<Exception>> catchAllHandler = Optional.empty();

        public Builder(Runnable r) {
            this.r = r;
        }

        public <T extends Exception> Builder catchException(Class<T> clazz, Consumer<T> c) {
            handlers.put(clazz, c);
            return this;
        }

        public Builder catchAll(Consumer<Exception> c) {
            catchAllHandler = Optional.of(c);
            return this;
        }

        public void run() {
            try {
                r.run();
            } catch (Exception e) {
                Consumer<Exception> h = (Consumer<Exception>) handlers.get(e.getClass());
                if (h != null) {
                    h.accept(e);
                } else {
                    catchAllHandler.ifPresent(c -> c.accept(e));
                }
            }
        }
    }

}
