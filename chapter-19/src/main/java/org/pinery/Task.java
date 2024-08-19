package org.pinery;

/**
 * 提供给调用者实现计算逻辑
 **/
public interface Task<IN, OUT> {
    OUT get(IN input);
}
