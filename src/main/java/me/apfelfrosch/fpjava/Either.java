package me.apfelfrosch.fpjava;

import java.util.function.Consumer;

public final class Either<Left, Right> {

    private final EitherState state;
    private final Object v;

    private Either(EitherState state, Object v) {
        this.state = state;
        this.v = v;
    }

    public static <Left, Right> Either<Left, Right> left(Left left) {
        return new Either<>(EitherState.LEFT, left);
    }

    public static <Left, Right> Either<Left, Right> right(Right right) {
        return new Either<>(EitherState.RIGHT, right);
    }

    public Either<Left, Right> ifLeft(Consumer<Left> c) {
        if (state == EitherState.LEFT) {
            c.accept((Left) v);
        }
        return this;
    }

    public Either<Left, Right> ifRight(Consumer<Right> c) {
        if (state == EitherState.RIGHT) {
            c.accept((Right) v);
        }
        return this;
    }

    public boolean isLeft() {
        return state == EitherState.LEFT;
    }

    public boolean isRight() {
        return state == EitherState.RIGHT;
    }

    private enum EitherState {
        LEFT,
        RIGHT
    }

}
