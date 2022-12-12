package ru.khavantsev;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
		System.out.println("started");
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            Socket clientSocket = serverSocket.accept();
            new Thread(() -> {
                try {
                    clientSocket.getOutputStream().write("Hello server1 2\r\n".getBytes());
                    clientSocket.close();
                } catch (Throwable t){
                    System.out.println(t);
                }
            }).start();
        }
    }
}