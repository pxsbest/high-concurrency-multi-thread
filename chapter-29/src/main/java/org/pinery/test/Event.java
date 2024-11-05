package org.pinery.test;

/**
 * Event 只包含了该 Event所属的 类型和数据
 **/
public class Event {
    private final String type;
    private final String data;

    public Event(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getType() {
        return type;
    }
}
