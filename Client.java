import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private final static int PORT = 8000;
    private final static String ADRESS = "127.0.0.1";

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;
    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Client client = new Client();
        client.go();

    }

    public void go() {
        Scanner scn = new Scanner(System.in); 
        setUpNetworking();
        Thread readerThread = new Thread(() -> {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
         // sendMessage thread 
         Thread sendMessage = new Thread(new Runnable()  
         { 
             @Override
             public void run() { 
                 while (true) { 
   
                     // read the message to deliver. 
                     String msg = scn.nextLine(); 
                       
                     
                         // write on the output stream 
                         writer.println(msg);
                         writer.flush();
                     
                 } 
             } 
         }); 
         readerThread.start();
         sendMessage.start();
    }
                
        

    public void setUpNetworking() {
        try {
            socket = new Socket(ADRESS, PORT);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
