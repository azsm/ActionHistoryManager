package com.zizo.action;

public interface Action {
    default boolean isCancelable() {
        return true;
    }
}
