package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    StringBuilder msg = new StringBuilder();
                    String message = in.readLine();
                    while (!message.isEmpty()) {
                        msg.append(message);
                        System.out.println(message);
                        message = in.readLine();
                    }
                    if (msg.indexOf("Exit") != -1) {
                        out.write("HTTP/1.1 500 STOP\r\n\r\n".getBytes());
                        out.write("Bye ".getBytes());
                        out.flush();
                        server.close();
                    } else if (msg.indexOf("Hello") != -1) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Hello ".getBytes());
                        out.flush();
                    } else if (msg.indexOf("Any") != -1) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("What? ".getBytes());
                        out.flush();
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.flush();
                    }
                }
            }
        }
    }
}