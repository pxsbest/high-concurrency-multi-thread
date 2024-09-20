package org.pinery.common;

import org.pinery.ActiveFuture;
import org.pinery.Future;
import org.pinery.OrderService;
import org.pinery.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 是通用 Active Object 的核心类,其负责生成 Service的代理以及构建 ActiveMessage
 **/
public class ActiveServiceFactory {
    //定义ActiveMessageQueue,用于存放ActiveMessage
    private final static ActiveMessageQueue queue = new ActiveMessageQueue();

    public static <T> T active(T instance) {
        //生成Service的代理类
        Object proxy = Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), new ActiveInvocationHandler<>(instance));
        return (T) proxy;
    }


    //测试
    public static void main(String[] args) throws InterruptedException {
        OrderService orderService = active(new OrderServiceImpl());
        Future<String> future = orderService.findOrderDetails(23423);
        System.out.println("i will be returned immediately");
        System.out.println(future.get());

    }








    //ActiveInvocationHandler 是InvocationHandler的子类,生成 Proxy时需要使用到
    private static class ActiveInvocationHandler<T> implements InvocationHandler {
        private final T instance;

        ActiveInvocationHandler(T instance) {
            this.instance = instance;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //如果方法被 @ActiveMethod标记,则会转换为 ActiveMessage
            if (method.isAnnotationPresent(ActiveMethod.class)) {
                //检查该方法是否符合规范
                this.checkMethod(method);
                ActiveMessage.Builder builder = new ActiveMessage.Builder();
                builder.useMethod(method).withObjects(args).forService(instance);
                Object result = null;
                if (this.isReturnFutureType(method)) {
                    result = new ActiveFuture<>();
                    builder.returnFuture((ActiveFuture) result);
                }
                //将 ActiveMessage加入到队列中
                queue.offer(builder.build());
                return result;
            } else {
                //如果是普通方法,则直接使用
                return method.invoke(instance, args);
            }
        }


        //检查有返回值的方法是否为 Future,否则将抛出 IllegalActiveMethod
        private void checkMethod(Method method) throws IllegalActiveMethod {
            if (!isReturnVoidType(method) && !isReturnFutureType(method)) {
                throw new IllegalActiveMethod("the method [" + method.getName() + " return type must be void/Future");
            }
        }

        //判断方法是否为 Future 返回类型
        private boolean isReturnFutureType(Method method) {
            return method.getReturnType().isAssignableFrom(Future.class);
        }

        //判断方法是否无返回类型
        private boolean isReturnVoidType(Method method) {
            return method.getReturnType().equals(Void.TYPE);
        }
    }
}