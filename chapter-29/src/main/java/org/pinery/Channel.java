package org.pinery;

public interface Channel<E extends Message> {
    /**
     * dispatch 方法用于 负责  message的调度
     */
    void dispatch(E message);
}
