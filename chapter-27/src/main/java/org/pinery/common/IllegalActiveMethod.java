package org.pinery.common;


//若方法不符合,则其被转换为 Active方法时会抛出异常
public class IllegalActiveMethod extends Exception {
    public IllegalActiveMethod(String message) {
        super(message);
    }
}

