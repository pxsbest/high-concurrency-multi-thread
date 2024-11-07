package org.pinery.usages;

import org.pinery.async.AsyncEventDispatcher;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * 用户在聊天室的线程
 **/
public class UserChatThread extends Thread {
    private final User user;
    private final AsyncEventDispatcher dispatcher;

    public UserChatThread(User user, AsyncEventDispatcher dispatcher) {
        super(user.getName());
        this.user = user;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        try {
            //User上线,发送 online Event
            dispatcher.dispatch(new UserOnlineEvent(user));
            for (int i = 0; i < 5; i++) {
                //发送User的聊天信息
                dispatcher.dispatch(new UserChatEvent(user, getName() + "-Hello-" + i));
                //短暂休眠 1~10
                TimeUnit.SECONDS.sleep(current().nextInt(10));
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            //User下线,发送Offline Event
            dispatcher.dispatch(new UserOfflineEvent(user));
        }
    }
}
