package org.pinery;

public interface Message {
    /**
     * 这是 Message 类型
     */
    Class<? extends  Message> getType();
}
