package org.pinery;


/**
 * 假设大厅共有四台出号机,这就意味着有四个线程在同时工作,用程序模拟一下叫号的过程,约定当天最多受理50笔业务.
 */


/**
 * 代表大厅里的叫号机
 **/
public class TicketWindow extends Thread {
    //柜台名称
    private final String name;

    //最多受理50笔业务
    private static final int MAX = 50;

    //private int index = 1;

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台: " + name + " 当前的号码是: " + (index++));
        }
    }


    public static void main(String[] args) {
        TicketWindow ticketWindow_1 = new TicketWindow("一号出号机");
        ticketWindow_1.start();

        TicketWindow ticketWindow_2 = new TicketWindow("二号出号机");
        ticketWindow_2.start();

        TicketWindow ticketWindow_3 = new TicketWindow("三号出号机");
        ticketWindow_3.start();

        TicketWindow ticketWindow_4 = new TicketWindow("四号出号机");
        ticketWindow_4.start();

    }


}
