package com.nazaninfz.rabbitconsumer.interfaces;

public abstract class UseCase<I, O> {
    public abstract O execute(I input);
}
