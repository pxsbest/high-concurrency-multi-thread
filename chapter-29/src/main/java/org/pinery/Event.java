package org.pinery;

/**
 * Evnet是对 Message的 一个最简单的实现.
 **/
public class Event implements Message {

    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }


}
