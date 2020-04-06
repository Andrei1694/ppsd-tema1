import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;
    public static void main(String[] args) {
        Client client = new Client();
        client.setUpNetworking();
    }
    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1", 8000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            String mesajServer = reader.readLine();
            System.out.println("Thread mesaj server:"+mesajServer);
            writer.close();
            reader.close();
            socket.close(); 

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
   
}