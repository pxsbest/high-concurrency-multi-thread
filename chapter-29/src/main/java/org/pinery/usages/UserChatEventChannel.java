package org.pinery.usages;

import org.pinery.Event;
import org.pinery.async.AsyncChannel;

/**
 * 用户聊天Event,直接在控制台输出即可
 **/
public class UserChatEventChannel extends AsyncChannel {
    @Override
    protected void handle(Event message) {
        UserChatEvent event=(UserChatEvent)message;
        System.out.println("The User["+event.getUser().getName()+"] say: "+event.getMessage());
    }
}
