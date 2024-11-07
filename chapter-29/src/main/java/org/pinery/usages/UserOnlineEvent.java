package org.pinery.usages;

import org.pinery.Event;

/**
 * 用户上线事件
 **/
public class UserOnlineEvent extends Event {
    private final User user;

    public UserOnlineEvent(User user) {
        this.user=user;
    }

    public User getUser() {
        return user;
    }
}
