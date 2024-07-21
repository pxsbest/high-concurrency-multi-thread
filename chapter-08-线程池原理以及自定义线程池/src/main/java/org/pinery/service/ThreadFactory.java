package org.pinery.service;

/**
 * 创建线程的工厂,提供了创建线程的接口,以便于个性化地定制 Thread,比如Thread应该被加到哪个Group中
 * 优先级,线程名字以及是否为守护线程等.
 **/
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
