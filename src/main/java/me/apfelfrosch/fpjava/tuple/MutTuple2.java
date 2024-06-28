package me.apfelfrosch.fpjava.tuple;

import java.util.Objects;

public final class MutTuple2<A, B> {

    private A a;
    private B b;

    MutTuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutTuple2<?, ?> mutTuple2 = (MutTuple2<?, ?>) o;
        return Objects.equals(a, mutTuple2.a) && Objects.equals(b, mutTuple2.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "MutTuple2{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
