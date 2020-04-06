import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) {
        int port = 8000;
        int maxConnections = 3;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(maxConnections <= 3){
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket);
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                writer.println("Hello World !");
                writer.flush();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}