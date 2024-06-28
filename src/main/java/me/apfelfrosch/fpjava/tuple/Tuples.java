package me.apfelfrosch.fpjava.tuple;

public final class Tuples {

    private Tuples() {
    }

    public static <A, B> Tuple2<A, B> of(A a, B b) {
        return new Tuple2<>(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C> of(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> of(A a, B b, C c, D d) {
        return new Tuple4<>(a, b, c, d);
    }

    public static <A, B> MutTuple2<A, B> ofMut(A a, B b) {
        return new MutTuple2<>(a, b);
    }

    public static <A, B, C> MutTuple3<A, B, C> ofMut(A a, B b, C c) {
        return new MutTuple3<>(a, b, c);
    }

    public static <A, B, C, D> MutTuple4<A, B, C, D> ofMut(A a, B b, C c, D d) {
        return new MutTuple4<>(a, b, c, d);
    }

}
