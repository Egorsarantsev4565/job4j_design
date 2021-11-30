package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    List<String> msg = new ArrayList<>();
                    String message = in.readLine();
                    while (!message.isEmpty()) {
                        msg.add(message);
                        System.out.println(message);
                        message = in.readLine();
                    }
                    for (String rsl : msg) {
                        if (rsl.contains("Bye")) {
                            out.write("HTTP/1.1 500 STOP\r\n\r\n".getBytes());
                            out.flush();
                            server.close();
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.flush();

                }
            }
        }
    }
}