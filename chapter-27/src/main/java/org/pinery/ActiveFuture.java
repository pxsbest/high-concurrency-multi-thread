package org.pinery;

/**
 *
 **/
public class ActiveFuture<T> extends FutureTask<T> {
    @Override
    public void finish(T result) {
        super.finish(result);
    }
}
