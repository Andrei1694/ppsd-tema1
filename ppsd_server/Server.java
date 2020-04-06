package ppsd_server;

import java.io.*;
import java.net.*;
import java.util.Vector;

import ppsd_server.ClientHandler;

public class Server  
{ 
  public static int PORT = 8000;
  private final static int MAX_CONNECTIONS = 3;
  public static void main(String[] args) {
      try{
          ServerSocket serverSocket = new ServerSocket(PORT);
          while(true){
              Socket clientSocket = serverSocket.accept();
              OutputStream os = clientSocket.getOutputStream();
              ClientHandler clientHandler = new ClientHandler(clientSocket);
              clientHandler.run();
          }
      }catch(IOException e){
        e.printStackTrace();
      }
  }
} 