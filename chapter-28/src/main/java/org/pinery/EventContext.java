package org.pinery;

import java.lang.reflect.Method;

/**
 * @Author gensci
 * @DateTime 2024/9/20 15:37
 * @Description
 **/
public interface EventContext {
    String getSource();
    Object getSubscriber();
    Method getSubscribe();
    Object getEvent();
}
