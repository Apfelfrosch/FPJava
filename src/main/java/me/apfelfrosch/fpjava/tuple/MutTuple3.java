package me.apfelfrosch.fpjava.tuple;

import java.util.Objects;

public final class MutTuple3<A, B, C> {

    private A a;
    private B b;
    private C c;

    MutTuple3(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutTuple3<?, ?, ?> mutTuple3 = (MutTuple3<?, ?, ?>) o;
        return Objects.equals(a, mutTuple3.a) && Objects.equals(b, mutTuple3.b) && Objects.equals(c, mutTuple3.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "MutTuple3{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

}
