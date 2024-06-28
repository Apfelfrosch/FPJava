package me.apfelfrosch.fpjava.tuple;

import java.util.Objects;

public final class MutTuple4<A, B, C, D> {

    private A a;
    private B b;
    private C c;
    private D d;

    MutTuple4(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutTuple4<?, ?, ?, ?> mutTuple4 = (MutTuple4<?, ?, ?, ?>) o;
        return Objects.equals(a, mutTuple4.a) && Objects.equals(b, mutTuple4.b) && Objects.equals(c, mutTuple4.c) && Objects.equals(d, mutTuple4.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "MutTuple4{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
