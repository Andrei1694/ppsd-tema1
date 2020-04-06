import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;
    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void sendMessage(String message) {
        writer.println(message);
        writer.flush();
    }
}