package org.pinery;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author gensci
 **/
public class FooEventDrivenExample {
    //用于处理 A 类型的 Event
    public static void handleEventA(Event e){
        System.out.println(e.getData().toLowerCase());
    }

    //用于处理 B 类型的 Event
    public static void handleEventB(Event e) {
        System.out.println(e.getData().toUpperCase());
    }

    public static void main(String[] args) {
        Queue<Event> events = new LinkedList<>();
        events.add(new Event("A", "Hello"));
        events.add(new Event("A", "I am Event A"));
        events.add(new Event("B", "I am Event B"));

        Event e;
        while (!events.isEmpty()) {
            //从消息队列中不断移除,根据不同的类型进行处理
            e=events.remove();
            switch (e.getType()) {
                case "A":
                    handleEventA(e);
                    break;
                case "B":
                    handleEventB(e);
                    break;
            }
        }
    }

}
