package org.pinery;

/**
 * @Author gensci
 * @DateTime 2024/11/5 12:24
 * @Description
 **/
public class EventDispatcherExample {
    /**
     * InputEvent 中定义了两个属性 X和Y,主要用于在其他 Channel中的运算
     */
    static class InputEvent extends Event {
        private final int x;
        private final int y;

        public InputEvent(int x, int y) {
            this.x=x;
            this.y=y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    /**
     * 用于存放结果的 Event
     */
    static class ResultEvent extends Event {
        private final int result;

        public ResultEvent(int result) {
            this.result=result;
        }

        public int getResult() {
            return result;
        }
    }

    /**
     * 处理 ResultEvent的 Handler(Channel), 只是简单地将计算结果输出到控制台
     */
    static class ResultEventHandler implements Channel<ResultEvent> {
        @Override
        public void dispatch(ResultEvent message) {
            System.out.println("The result is: "+message.getResult());
        }
    }

    /**
     * InputEventHandler需要向 Router发送 Event,因此在构造的时候需要传入Dispatcher
     */
    static class InputEventHandler implements Channel<InputEvent> {

        private final EventDispatcher dispatcher;

        public InputEventHandler(EventDispatcher dispatcher) {
            this.dispatcher=dispatcher;
        }

        /**
         * 将计算的结果构造成新的 Event提交给 Router
         */
        @Override
        public void dispatch(InputEvent message) {
            System.out.printf("X:%d,Y:%d\n", message.getX(), message.getY());
            int result=message.getX()+message.getY();
            dispatcher.dispatch(new ResultEvent(result));
        }
    }


    public static void main(String[] args) {
        //构造Router
        EventDispatcher dispatcher = new EventDispatcher();
        //将Event和Handler(Channel)的绑定关系注册到Dispatcher
        dispatcher.registerChannel(InputEvent.class, new InputEventHandler(dispatcher));
        dispatcher.registerChannel(ResultEvent.class, new ResultEventHandler());
        dispatcher.dispatch(new InputEvent(1,2));
    }
}
