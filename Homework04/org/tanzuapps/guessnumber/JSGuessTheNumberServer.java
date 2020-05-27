package org.tanzuapps.guessnumber;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class JSGuessTheNumberServer {

    // Create and main list of active clients based on their host name / ip address
    static ConcurrentHashMap<String, Socket> activeClients = new ConcurrentHashMap<String, Socket>();

    public static void main(String[] args) {
        // server is listening on port 1234
        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(1234);
            System.out.println("Server started on port 1234.");
            // running infinite loop for getting
            // client request
            while (true) {
                // Accept the incoming request
                s = ss.accept();
                // obtain input and output streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                String clientIP = s.getInetAddress().getHostAddress();
                System.out.println("New client request received : " + s + " : " + clientIP);

                // Create a new Thread with this object.
                Thread clientThread = new Thread(new ClientHandler(s, clientIP, dis, dos));
                clientThread.setName(clientIP);

                // start the thread.
                clientThread.start();

                // add this client to active clients list
                activeClients.put(clientIP, s);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                ss.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}

// ClientHandler class
class ClientHandler implements Runnable {
    private String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;

    // constructor
    public ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
    }

    @Override
    public void run() {
        int[] range = new int[] { 1, 100 };
        String received = "";
        boolean matched = false;
        boolean cont = false;
        do {
            try {
                JSGuessTheNumber jsGuessTheNumber = new JSGuessTheNumber(range[0], range[1]);
                System.out.println("Number to guess (" + name + "): " + jsGuessTheNumber.getNumber2Guess());
                do {
                    dos.writeUTF("Your chance of guessing it correctly " + jsGuessTheNumber.probability() + "%!");
                    dos.writeUTF("Guess the number between " + range[0] + " and " + range[1]);
                    received = dis.readUTF();
                    System.out.println("User guess(" + name + ")" + received);
                    int userGuess = Integer.parseInt(received);
                    matched = jsGuessTheNumber.isMatch(userGuess);
                    if(!matched)
                        dos.writeUTF("Try again!\n");
                } while (!matched);
                dos.writeUTF("\nYou guessed it!");
                dos.writeUTF("Do you want to play a new game? (yes/no)"); // prompt user to input yes or no
                received = dis.readUTF();
                cont = received.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
            } catch (Exception e) {
                // TODO: handle exception
            }
        } while (cont);
        try {
            dos.writeUTF("#close");
            // closing resources
            this.dis.close();
            this.dos.close();
            this.s.close();
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }
}
