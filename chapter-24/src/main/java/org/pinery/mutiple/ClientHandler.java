package org.pinery.mutiple;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * 响应客户端连接的 Handler
 **/
public class ClientHandler implements Runnable{
    private final Socket socket;
    private final String clientIdentify;

    public ClientHandler(final Socket socket) {
        this.socket = socket;
        this.clientIdentify = socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
    }

    @Override
    public void run() {
        try {
            this.chat();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void chat() throws IOException{
        BufferedReader bufferedReader = wrap2Reader(this.socket.getInputStream());
        PrintStream printStream = wrap2Print(this.socket.getOutputStream());
        String received;
        while ((received = bufferedReader.readLine()) != null) {
            System.out.printf("client:%s-message:%s\n", clientIdentify, received);
            if (received.equals("quit")) {
                write2Client(printStream, "client will close");
                socket.close();
                break;
            }
            write2Client(printStream, "Server:" + received);
        }
    }

    //将输出字节流封装成 BufferedReader 缓冲字符流
    private BufferedReader wrap2Reader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }


    private PrintStream  wrap2Print(OutputStream outputStream) {
        return new PrintStream(outputStream);
    }


    //该方法主要用于向客户端发送消息
    private void write2Client(PrintStream print, String message) {
        print.println(message);
        print.flush();
    }





}
