package org.pinery.mutiple;

import org.pinery.BasicThreadPool;
import org.pinery.service.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 **/
public class ChatServer {
    private final int port;
    private ThreadPool threadPool;
    private ServerSocket serverSocket;

    public ChatServer(int port) {
        this.port = port;
    }
    public ChatServer() {
        this(13312);
    }

    public void startServer()throws IOException{
        this.threadPool = new BasicThreadPool(1, 4, 2, 1000);
        this.serverSocket = new ServerSocket(port);
        this.serverSocket.setReuseAddress(true);
        System.out.println("Chat server is started and listen at port: " + port);
        //开始监听
        this.listen();
    }

    private void listen() throws IOException{
        for (; ; ) {
            Socket client = serverSocket.accept();
            this.threadPool.execute(new ClientHandler(client));
        }
    }

}
