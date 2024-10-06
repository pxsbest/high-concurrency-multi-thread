package org.pinery;


/**
 *
 **/
public interface EventExceptionHandler {
    void handle(Throwable throwable, EventContext context);
}
