package com.zizo.action;

import java.util.LinkedList;
import java.util.Queue;

public class ActionManager<T> {
    // Action stocker
    private Queue<Action<T>> predecessorQueue = new LinkedList<>();
    private Queue<Action<T>> successorQueue = new LinkedList<>();

    private T value;

    public ActionManager(T value) {
        this.value = value;
    }

    public void goBack() {
        Action action = predecessorQueue.element();
        if(!action.isCancelable()) {
            throw new UnsupportedOperationException();
        }
        action = predecessorQueue.poll();
        successorQueue.offer(action);
        action.cancel(value);
    }

    public void goForward() {
        Action action = successorQueue.poll();
        predecessorQueue.offer(action);
        action.doAction(value);
    }

    public void doSomething(Action action) {
        action.doAction(value);
        predecessorQueue.offer(action);
        successorQueue.clear();
    }
}
