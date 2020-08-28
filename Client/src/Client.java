import domashenko.Core;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try (Core core = new Core("127.0.0.1", 8000)) {
            System.out.println("Connected to server!");
            String request = "Visaginas";
            System.out.println("Request: " + request);
            core.writeLine(request);

            String response = core.readLine();
            System.out.println("Response: " + response);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
