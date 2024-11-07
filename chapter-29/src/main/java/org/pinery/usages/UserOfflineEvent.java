package org.pinery.usages;

import org.pinery.Event;

/**
 * 用户下线事件
 **/
public class UserOfflineEvent extends UserOnlineEvent {
    public UserOfflineEvent(User user) {
        super(user);
    }
}
