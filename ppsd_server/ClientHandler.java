package ppsd_server;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class ClientHandler implements Runnable {
    private final Socket clientSocket;
    boolean isloggedin;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
		
	} 
  
    public void handleClientSocket() throws IOException, InterruptedException {
        InputStream is = clientSocket.getInputStream();
        OutputStream os = clientSocket.getOutputStream();
        BufferedReader reader =new BufferedReader(new InputStreamReader(is));
        String line;
        while(( line = reader.readLine() ) != null){
            if("quit".equalsIgnoreCase(line)){
                break;
            }
            String msg = "You typed: " + line + "\n";
            os.write(msg.getBytes());
        }
        clientSocket.close();
    }
  
    } 
