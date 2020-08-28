import domashenko.Core;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started!");
            while (true) {
                Core core = new Core(server);
                new Thread(() -> {
                    String request = core.readLine();
                    System.out.println("Request:" + request);
                    String response = (int) (Math.random() * 30 - 10) + "";
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    core.writeLine(response);
                    System.out.println("Response: " + response);
                    try {
                        core.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
