package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class EchoServer {
    private final int port;
    private boolean keepRunning = true;
    private final Map<String, EchoServer.ServerAction> serverActions = new HashMap<>();

    public EchoServer(int port) {
        this.port = port;

        initActions();
    }

    private void initActions() {
        serverActions.put("Exit", (OutputStream o, String t) -> {keepRunning = false; answer(o, "Server stopped");});
    }

    private interface ServerAction {
        void execute(OutputStream o, String text);
    }

    private void answer(OutputStream o, String text) {
        try {
            o.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
            o.write(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        try (ServerSocket server = new ServerSocket(this.port)) {
            while (keepRunning) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String msg = in.lines()
                                    .filter(s -> s.contains("/?"))
                                    .map(s -> s.split(" ")[1].split("=")[1])
                                    .findAny().orElse("");
                    serverActions.getOrDefault(msg, this::answer).execute(out, msg);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer(9000).run();
    }
}
