package ppsd_server;
import java.io.*;
import java.net.*;
import ppsd_server.ClientHandler;

public class Server {
    public static void main(String args[]) {
        int port = 8000;
        int maxConnections = 3;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(maxConnections <= 3){
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}