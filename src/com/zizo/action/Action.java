package com.zizo.action;

public interface Action<T> {
    default boolean isCancelable() {
        return true;
    }

    void doAction(T currentValue);
    void cancel(T currentValue);
}
