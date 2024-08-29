package org.pinery;

import org.pinery.mutiple.ChatServer;

import java.io.IOException;

/**
 * @Author ${USER}
 * @DateTime ${DATE} ${TIME}
 * @Description
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        //Operator oper = new Operator();
        //oper.call("message");


        new ChatServer().startServer();



    }
}