package org.pinery.usages;

import org.pinery.async.AsyncEventDispatcher;

/**
 *
 **/
public class UserChatApplication {
    public static void main(String[] args) {
        //定义异步的 Router
        final AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();
        //为Router 注册 Channel 和 Event 之间的关系
        dispatcher.registerChannel(UserOnlineEvent.class, new UserOnlineEventChannel());
        dispatcher.registerChannel(UserOfflineEvent.class, new UserOfflineEventChannel());
        dispatcher.registerChannel(UserChatEvent.class, new UserChatEventChannel());

        //启动三个登录聊天室的User
        new UserChatThread(new User("Leo"),dispatcher).start();
        new UserChatThread(new User("Alex"), dispatcher).start();
        new UserChatThread(new User("Tina"),dispatcher).start();
    }
}
