package org.pinery.usages;

/**
 * 用户聊天的事件
 **/
public class UserChatEvent extends UserOnlineEvent {
    private final String message;

    public UserChatEvent(User user, String message) {
        super(user);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
